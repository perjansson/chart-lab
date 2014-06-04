package com.peejay.chart.jensoftapi;

import java.util.Map;

public class HorizontalBarChartInputDTO extends ChartInputDTO {

    private Map<String, Double> input;

    public HorizontalBarChartInputDTO(Map<String, Double> input, int width, int height) {
        super(width, height);
        this.input = input;
    }

    public Map<String, Double> getInput() {
        return input;
    }
}
