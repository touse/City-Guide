package com.example.cityguide;

public class MostViewedHelperClass {

    int imageview;
    String title,description;

    public MostViewedHelperClass(int imageview, String title) {
        this.imageview = imageview;
        this.title = title;
      //  this.description = description;
    }



    public int getImageView() {
        return imageview;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
