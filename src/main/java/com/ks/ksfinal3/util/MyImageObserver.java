package com.ks.ksfinal3.util;

import java.awt.*;
import java.awt.image.ImageObserver;

public class MyImageObserver implements ImageObserver {
    @Override
    public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
        if ((infoflags & ImageObserver.ERROR) != 0) {
            System.out.println("Error loading image.");
            return false; // Stop further updates
        }
        if ((infoflags & ImageObserver.ALLBITS) != 0) {
            System.out.println("Image loaded successfully.");
            return false; // Stop further updates
        }
        // Handle other flags as needed
        return true; // Continue receiving updates
    }
}