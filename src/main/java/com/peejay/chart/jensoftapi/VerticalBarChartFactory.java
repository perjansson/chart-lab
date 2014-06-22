package com.peejay.chart.jensoftapi;

import com.peejay.chart.ChartInputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class VerticalBarChartFactory {

    private final ChartProvider chartProvider;

    @Autowired
    public VerticalBarChartFactory(ChartProvider chartProvider) {
        this.chartProvider = chartProvider;
    }

    public VerticalBarChart createChart(ChartInputDTO<List<Map<String, Double>>> inputDTO) {
        VerticalBarChart chart = chartProvider.getVerticalBarChart();
        for (Map<String, Double> valueMap : inputDTO.getInput()) {
            List<Double> values = new ArrayList<Double>(valueMap.values());
            chart.addStackBars(values);
        }
        return chart;
    }
}
