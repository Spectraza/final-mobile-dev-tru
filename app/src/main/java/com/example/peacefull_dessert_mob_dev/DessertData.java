package com.example.peacefull_dessert_mob_dev;
/**
 * Not really sure what this class is and how it relates to Dessert.java class
 * Object model??
 *
 * @author Valeriia Savych
 * @since 2025
 * @documenter Rion Miyazaki
 */
public class DessertData {
    private String image;
    private String name;
    private String price;
    private String quantity;
    private String description;
    private String rate;

    public DessertData(String image, String name, String price, String quantity, String description, String rate) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.rate = rate;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    public String getRate() {
        return rate;
    }
}

