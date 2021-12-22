package com.email.constant;

public class Constant {


    private String message= "Hi Sir/Mam," +'\n' +
            "This is a test email"+ '\n' +
            "Thanks"+ '\n' +
            "Vivek";

    private  String subject = "spring boot test email";
    private String to="vivek.sri1996@gmail.com";
    private String from="viveksri0810@gmail.com";
    private String pass="XXXXXXXXXX";



    public String getMessage() {
        return message;
    }

    public  String getSubject() {
        return subject;
    }

    public  String getTo() {
        return to;
    }

    public  String getFrom() {
        return from;
    }

    public String getPass() {
        return pass;
    }
}
