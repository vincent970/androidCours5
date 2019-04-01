package com.cba533.cours5.notification.model;

public class ImportantMessageModel {
    public String message;
    public String sender;

    public ImportantMessageModel() {
        message = "";
        sender = "";
    }

    public ImportantMessageModel(String message, String sender) {
        this.message = message;
        this.sender = sender;
    }


    public String getMessage() {
        return message;
    }

    public String getSender() {
        return sender;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
