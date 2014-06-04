package com.peejay.chart.jensoftapi;

public abstract class ChartInputDTO {

    private int width;
    private int height;
    private String type;

    protected ChartInputDTO(int width, int height, String type) {
        this.width = width;
        this.height = height;
        this.type = type;
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
