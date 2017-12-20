SET JDK_DIRECTORY=C:\Program Files\Java\jdk1.8.0_112\bin
SET PYTHON_DIRECTORY=C:\Users\cms\AppData\Local\Programs\Python\Python36-32\
SET BROWSER=C:\Program Files (x86)\Google\Chrome\Application\chrome.exe

SET DEPENDENCY_DIRECTORY=..\dependency
SET FEATURE_DIRECTORY=..\feature
SET CLASS_DIRECTORY=..\out\production\OutSystemsDigitalAutomatedTesting
SET REPORT_DIRECTORY=..\report
SET REPORT_FILENAME=report.html

SET STEP_PACKAGE=com.outsystems.digital.automatedtesting.step

DEL %REPORT_DIRECTORY%\*.feature.json

FOR %%F IN (%FEATURE_DIRECTORY%\*) DO (
   "%JDK_DIRECTORY%\java" -enableassertions -cp "%DEPENDENCY_DIRECTORY%\*;%CLASS_DIRECTORY%" cucumber.api.cli.Main -p json:%REPORT_DIRECTORY%\%%~nxF.json --glue %STEP_PACKAGE% %FEATURE_DIRECTORY%\%%~nxF
)

"%PYTHON_DIRECTORY%python" createReport.py %REPORT_DIRECTORY% %REPORT_FILENAME%

"%BROWSER%" "%REPORT_DIRECTORY%\%REPORT_FILENAME%"