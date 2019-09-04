package com.example.p535;

public class Item {
    String name;
    String nation;
    int imgId;
    String img;
    public Item() {

    }

    public Item(String name, String nation) {
        this.name = name;
        this.nation = nation;
    }

    public Item(String name, String nation, String img) {
        this.name = name;
        this.nation = nation;
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Item(String name, String nation, int imgId) {
        this.name = name;
        this.nation = nation;
        this.imgId = imgId;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
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
