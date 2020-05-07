package com.example.ht;

public class UserSave {
    protected String accName;
    private String accPassword;
    private String accEmail;
    private String accPhone;

    public UserSave ( String accName, String accPassword, String accEmail, String accPhone) {
        this.accName = accName;
        this.accPassword = accPassword;
        this.accEmail = accEmail;
        this.accPhone = accPhone;
    }
    public String toString() {
        return accName;
    }

    public String getAccName() {
        return accName;
    }
    public String getAccPassword() {
        return accPassword;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }
    public void setAccPassword(String accPassword) {
        this.accPassword = accPassword;
    }
    public void setAccEmail(String accEmail) {
        this.accEmail = accEmail;
    }
    public void setAccPhone(String accPhone) {
        this.accPhone = accPhone;
    }
}



