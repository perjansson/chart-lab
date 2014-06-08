package com.peejay.chart;

import com.peejay.chart.jensoftapi.ChartInputDTO;

import java.util.Map;

public interface ChartFactory {

    Chart createPieChart();

    Chart createBackgroundChart();

    ChartDTO createHorizontalBarChart(ChartInputDTO<Map<String, Double>> inputDTO);

}
