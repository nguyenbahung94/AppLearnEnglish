package com.example.asus.applearnenglish.model;

/**
 * Created by Asus on 9/23/2017.
 */

public class UnitEnglish {
    private String unit;
    private String title;

    public UnitEnglish() {
    }

    public UnitEnglish(String unit, String title) {
        this.unit = unit;
        this.title = title;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
