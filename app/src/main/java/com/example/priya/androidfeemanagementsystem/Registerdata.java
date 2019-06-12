package com.example.priya.androidfeemanagementsystem;

public class Registerdata {

    int accountant_id;
    String name;
    String password;
    String cpassword;
    String mobile_number;
    String email_id;


    public int getID()

    {
        return this.accountant_id;
    }

    // setting id
    public void setID(int id)

    {
        this.accountant_id = id;
    }
    public String getName() {
        // TODO Auto-generated method stub
        return name;
    }

    // setting  first name
    public void setName(String name)

    {
        this.name = name;
    }

    public String getPassword()

    {
        return password;
    }

    public void setPassword(String password)

    {
        this.password = password;
    }

    public String getCPassword()

    {
        return cpassword;
    }

    public void setCPassword(String cpassword)

    {
        this.cpassword = cpassword;
    }
    public String getMobNo() {
        // TODO Auto-generated method stub
        return mobile_number;
    }

    public void setMobNo(String mobile_number)
    {
        this.mobile_number = mobile_number;
    }
    public String getEmailId() {
        // TODO Auto-generated method stub
        return email_id;
    }

    public void setEmailId(String email_id)

    {
        this.email_id = email_id;
    }

}
