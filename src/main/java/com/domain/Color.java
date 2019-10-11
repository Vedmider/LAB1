package com.domain;

public enum Color {
    ORANGE("Orange"),
    BLACK("Black"),
    YELLOW("Yellow"),
    RED("Red"),
    GREEN("Green"),
    BROWN("Brown"),
    WHITE("White");

    String colorTitle;

    Color(String colorTitle) {
        this.colorTitle = colorTitle;
    }

    public String getColorTitle() {
        return colorTitle;
    }

    @Override
    public String toString() {
        return "Color{title=" + colorTitle + "}";
    }
}
