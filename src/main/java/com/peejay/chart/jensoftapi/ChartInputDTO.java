package com.peejay.chart.jensoftapi;

public abstract class ChartInputDTO {

    private int width;
    private int height;

    protected ChartInputDTO(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
