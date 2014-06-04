package com.peejay.chart;

public class ChartDTO {

    private byte[] imageAsByteArray;

    public ChartDTO(byte[] imageAsByteArray) {
        this.imageAsByteArray = imageAsByteArray;
    }

    public byte[] getImageAsByteArray() {
        return imageAsByteArray;
    }
}
