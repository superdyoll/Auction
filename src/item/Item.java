/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package item;

import java.awt.image.BufferedImage;

/**
 *
 * @author Lloyd
 */
public class Item implements java.io.Serializable{

    private String title;
    private String description;
    private BufferedImage image;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public Item(String title, String description) {
        this.title = title;
        this.description = description;
    }
    
    
}
