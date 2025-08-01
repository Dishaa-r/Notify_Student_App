package com.example.notifyme;
public class UserHelperClass {
    String Phone,Name,Password, StudClass, Batch;

    public UserHelperClass() {

    }
    public UserHelperClass(String phno, String name, String pwd) {
        this.Phone = phno;
        this.Name = name;
        this.Password = pwd;
    }
    public UserHelperClass(String phno, String pwd,String text1,String text2){
        this.Phone = phno;
        this.Password = pwd;
        this.StudClass = text1;
        this.Batch = text2;
    }

    public String getPhno() {
        return Phone;
    }

    public void setPhno(String phno) {
        this.Phone = phno;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getPwd() {
        return Password;
    }

    public void setPwd(String pwd) {
        this.Password = pwd;
    }

    public String getStudClass() {
        return StudClass;
    }

    public void setStudClass(String studClass) {
        StudClass = studClass;
    }

    public String getBatch() {
        return Batch;
    }

    public void setBatch(String batch) {
        this.Batch = batch;
    }
}
