package com.example.cityguide;

import android.graphics.drawable.GradientDrawable;

public class CategoriesHelperClass {
    int image;
    String title,description;

    public CategoriesHelperClass(int image, String title, String description) {
        this.image = image;
        this.title = title;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
