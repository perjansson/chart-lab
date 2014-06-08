package com.peejay.chart;

public class ChartInputDTO<T extends Object> {

    private T input;
    private int width;
    private int height;
    private String type;

    public ChartInputDTO(T input, int width, int height, String type) {
        this.input = input;
        this.width = width;
        this.height = height;
        this.type = type;
    }

    public T getInput() {
        return input;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getType() {
        return type;
    }
}
