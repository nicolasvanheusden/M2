package fr.uge.jee.springmvc.rectangle.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class RectangleForm {

    @NotNull
    @Min(0)
    private int width;
    @NotNull
    @Min(0)
    private int height;

    public RectangleForm(int width, int height) {
        this.width = width;
        this.height = height;
    }


    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "RectangleForm{" +
            "width=" + width +
            ", height=" + height +
            '}';
    }
}
