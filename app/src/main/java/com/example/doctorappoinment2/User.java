package com.example.doctorappoinment2;

import java.io.Serializable;

public class User implements Serializable {
    String phone_num;
    String password;

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
