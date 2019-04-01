package com.cba533.cours5.notification.model;

public class MessageModel {
    private String message;
    private String sender;

    public MessageModel() {
        this.message = "";
        this.sender = "";
    }


    public MessageModel(String message, String sender) {
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
