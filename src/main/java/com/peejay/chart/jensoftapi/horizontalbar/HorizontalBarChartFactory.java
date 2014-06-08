package com.peejay.chart.jensoftapi.horizontalbar;

import com.peejay.chart.jensoftapi.ChartInputDTO;
import com.peejay.chart.jensoftapi.ChartProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class HorizontalBarChartFactory {

    private final ChartProvider chartProvider;

    @Autowired
    public HorizontalBarChartFactory(ChartProvider chartProvider) {
        this.chartProvider = chartProvider;
    }

    public HorizontalBarChart createChart(ChartInputDTO<Map<String, Double>> inputDTO) {
        HorizontalBarChart chart = chartProvider.getHorizontalBarChart();
        chart.addBar("Total", 0d, 100d);
        Double accumulatedValue = 0d;
        for (String name : inputDTO.getInput().keySet()) {
            Double value = inputDTO.getInput().get(name);
            chart.addBar(name, accumulatedValue, value);
            accumulatedValue += value;
        }
        return chart;
    }
}
