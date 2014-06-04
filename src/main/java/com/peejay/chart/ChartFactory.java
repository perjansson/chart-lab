package com.peejay.chart;

import com.peejay.chart.jensoftapi.HorizontalBarChartInputDTO;

public interface ChartFactory {

    Chart createPieChart();

    Chart createBackgroundChart();

    ChartDTO createHorizontalBarChart(HorizontalBarChartInputDTO input);

}
