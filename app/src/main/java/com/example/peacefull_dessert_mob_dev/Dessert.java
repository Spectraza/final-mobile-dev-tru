package com.example.peacefull_dessert_mob_dev;
/**
 * Dessert object model class for defining all needed dessert information
 * to be included in every dessert
 * Each dessert has a name, price, description, and image
 *
 * !!Check Dessert Data.java class and resolve confusion!!
 *
 * @author Valeriia Savych
 * @since 2025
 * @documenter Rion Miyazaki
 */
public class Dessert {
    private String name;
    private String price;
    private String briefDescription;

    private int imageResourceId;

    public Dessert(String name, String price, String briefDescription, int imageResourceId) {
        this.name = name;
        this.price = price;
        this.briefDescription = briefDescription;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }
    public String getPrice() {
        return price;
    }
    public String getBriefDescription() {
        return briefDescription;
    }
    public int getImageResourceId() {
        return imageResourceId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public void setBriefDescription(String briefDescription) {
        this.briefDescription = briefDescription;
    }
    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }
    
}
