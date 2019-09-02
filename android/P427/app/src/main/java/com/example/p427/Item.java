package com.example.p427;

public class Item {
    String name;
    String phone;
    int imgId;
    public Item() {

    }

    public Item(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public Item(String name, String phone, int imgId) {
        this.name = name;
        this.phone = phone;
        this.imgId = imgId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public int getImgId() {
        return imgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
