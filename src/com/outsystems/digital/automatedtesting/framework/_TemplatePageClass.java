package com.outsystems.digital.automatedtesting.framework;

public class _TemplatePageClass extends Page {

    //Singleton object
    private static _TemplatePageClass _instance = null;

    //Constructor
    private _TemplatePageClass() {
    }

    //Singleton Instance
    public static _TemplatePageClass getInstance() {
        if (_instance == null) {
            _instance = new _TemplatePageClass();
        }
        return (_instance);
    }
}




