package com.peejay.chart.jensoftapi;

import com.peejay.chart.ChartInputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PieChartFactory {

    private final ChartProvider chartProvider;

    @Autowired
    public PieChartFactory(ChartProvider chartProvider) {
        this.chartProvider = chartProvider;
    }

    public PieChart createChart(ChartInputDTO<Map<String, Double>> inputDTO) {
        PieChart chart = chartProvider.getPieChart();
        // TODO: Use input values correctly on PieChart
        return chart;
    }
}
