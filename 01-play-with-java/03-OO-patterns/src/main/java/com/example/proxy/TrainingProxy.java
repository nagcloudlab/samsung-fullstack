package com.example.proxy;

public class TrainingProxy implements Training{

    private Training training=new TrainingImpl();
    Logging logging=new Logging();
    Security security=new Security();


    @Override
    public String getJavaTraining() {
        logging.doLog();
        security.authorize();
        return training.getJavaTraining();
    }

    @Override
    public String getJavascriptTraining() {
        logging.doLog();
        security.authorize();
        return training.getJavascriptTraining();
    }
}
