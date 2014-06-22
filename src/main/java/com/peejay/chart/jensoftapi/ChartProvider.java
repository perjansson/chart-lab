package com.peejay.chart.jensoftapi;

import org.springframework.stereotype.Service;

/**
 * The sole purpose of this class is to extract the creating of the JenSoftApi specific chart class, so it can be mocked
 * out during test of the chart specific factory.
 */
@Service
public class ChartProvider {

    public HorizontalBarChart getHorizontalBarChart() {
        return new HorizontalBarChart();
    }

    public VerticalBarChart getVerticalBarChart() {
        return new VerticalBarChart();
    }

    public PieChart getPieChart() {
        return new PieChart();
    }

    public BackgroundImageChart getBackgroundImageChart() {
        return new BackgroundImageChart();
    }

}
