package com.peejay.chart.jensoftapi;

import com.peejay.chart.ChartInputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class BackgroundImageChartFactory {

    private final ChartProvider chartProvider;

    @Autowired
    public BackgroundImageChartFactory(ChartProvider chartProvider) {
        this.chartProvider = chartProvider;
    }

    public BackgroundImageChart createChart(ChartInputDTO<Map<String, Double>> inputDTO) {
        BackgroundImageChart chart = chartProvider.getBackgroundImageChart();
        // TODO: Use input values correctly on BackgroundImageChart
        return chart;
    }
}
