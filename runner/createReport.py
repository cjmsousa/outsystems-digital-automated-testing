# Define imports
import sys, os, json, time

REPORT_DATA_PLACEHOLDER = "*************{ReportData}*************"


# Define report template
def defineReportTemplate():

    # Define HTML template
    return ("<html>\n"
            "   <head>\n"
            "       <title>Digital Automated Testing Report</title>\n"
            "       <style>\n"
            "           .feature { margin: 20 0 10 0; padding: 5; background-color: #3d85c6; color:#ffffff; }\n"
            "           .scenario { margin: 20 0 10 20; padding: 5;  color:#ffffff; }\n"
            "           .step { margin: 10 0 0 40; padding: 5; color:#ffffff; }\n"
            "           .passed { background-color: #6aa84f; }\n"
            "           .failed { background-color: #aa2000; }\n"
            "           .skipped { background-color: #bf9000; }\n"
            "       </style>\n"
            "       <script>"
            "       function expandCollapse() {"
            "       </script>"
            "   </head>\n"
            "   <body>\n" +
            REPORT_DATA_PLACEHOLDER +
            "   </body>\n"
            "</html>\n")


# Get parameters
reportDirectory = sys.argv[1]
reportFile = sys.argv[2]

# Define report template
fullReportHtml = defineReportTemplate()

# Iterate report files
reportData = ""
for filename in os.listdir(reportDirectory):

    # Only process json files
    if filename.endswith(".json"):

        # Read scenario output
        jsonReport = json.load(open(reportDirectory + "\\" + filename))

        # Print Feature data
        reportData += "\t\t<div class='feature'>" + jsonReport[0]["keyword"] + ": " + jsonReport[0]["name"] + " (" + \
                      time.ctime(os.path.getmtime(reportDirectory + "\\" + filename)) + ")</div>\n"

        # Iterate Scenario data
        for element in jsonReport[0]["elements"]:

            # Iterate Step data
            stepData = ""
            scenarioFormattingClass = "passed"
            for step in element["steps"]:

                # Step data
                stepData += "\t\t<div class='step " + step["result"]["status"] + "'>" + step["name"] + "</div>\n"

                # Check if
                if step["result"]["status"] == "failed" or step["result"]["status"] == "skipped":
                    scenarioFormattingClass = "failed"

            # Print Scenario data
            reportData += "\t\t<div class='scenario " + scenarioFormattingClass + "'>" + element["keyword"] + ": " +\
                          element["name"] + "</div>\n"

            # Print Step data
            reportData += stepData

# Add feature report to full report
fullReportHtml = fullReportHtml.replace(REPORT_DATA_PLACEHOLDER, reportData)

# Write report file
file = open(reportDirectory + "\\" + reportFile, "w")
file.write(fullReportHtml)
file.close()
