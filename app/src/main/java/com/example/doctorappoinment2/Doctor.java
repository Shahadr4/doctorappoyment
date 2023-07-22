package com.example.doctorappoinment2;

public class Doctor {
    String drname;
    String dpartment;
    String image;

    public Doctor(String drname, String dpartment) {
        this.drname = drname;
        this.dpartment = dpartment;

    }

    public String getDrname() {
        return drname;
    }

    public void setDrname(String drname) {
        this.drname = drname;
    }

    public String getDpartment() {
        return dpartment;
    }

    public void setDpartment(String dpartment) {
        this.dpartment = dpartment;
    }
}
