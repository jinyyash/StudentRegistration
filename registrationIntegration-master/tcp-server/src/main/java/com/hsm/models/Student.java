package com.hsm.models;

public class Student {
    private String nic;
    private String name;
    private String address;
    private String tel;

    public Student() {
        this.nic = nic;
    }

    public Student(String nic, String name, String address, String tel) {
        this.nic = nic;
        this.name = name;
        this.address = address;
        this.tel = tel;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
