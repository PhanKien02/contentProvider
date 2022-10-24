package com.example.contentprovider;

public class Contact {
    String name;
    String sdt;

    public Contact() {
    }

    public Contact(String name, String sdt) {
        this.name = name;
        this.sdt = sdt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
}
