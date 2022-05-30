package com.project.alihammoud.apollosquest;

import java.util.Date;

public class ChatHelper {
    private String name;
    private String message;

    public long  getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    private long  timeStamp;


    public ChatHelper(){

    }
    public ChatHelper(String name, long  timeStamp, String message) {
        this.name = name;
        this.timeStamp = timeStamp;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
