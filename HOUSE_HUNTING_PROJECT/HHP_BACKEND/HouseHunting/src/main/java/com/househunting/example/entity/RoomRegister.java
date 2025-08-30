package com.househunting.example.entity;

import jakarta.persistence.*;

@Entity
public class RoomRegister {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private long mobile;
    private String address;

    @Lob
    @Column(name = "image", columnDefinition = "LONGBLOB")
    private byte[] image;

    private String propertyStutas;

    private long price;

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public RoomRegister(int id, String name, String email, long mobile, String address, byte[] image, String propertyStutas, long price) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
        this.image = image;
        this.propertyStutas = propertyStutas;
        this.price = price;
    }

    public RoomRegister() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getPropertyStutas() {
        return propertyStutas;
    }

    public void setPropertyStutas(String propertyStutas) {
        this.propertyStutas = propertyStutas;
    }
}
