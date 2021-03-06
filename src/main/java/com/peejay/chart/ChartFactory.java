package com.peejay.chart;

import java.util.List;
import java.util.Map;

public interface ChartFactory {

    ChartDTO createHorizontalBarChart(ChartInputDTO<Map<String, Double>> inputDTO);

    ChartDTO createVerticalBarChart(ChartInputDTO<List<Map<String, Double>>> inputDTO);

    ChartDTO createPieChart(ChartInputDTO<Map<String, Double>> inputDTO);

    ChartDTO createBackgroundChart(ChartInputDTO<Map<String, Double>> inputDTO);

}
