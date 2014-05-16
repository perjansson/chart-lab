package com.peejay.chart.jensoftapi;

import com.peejay.chart.Chart;
import com.peejay.chart.ChartFactory;
import com.peejay.chart.jensoftapi.background.BackgroundImageChart;
import com.peejay.chart.jensoftapi.pie.PieChart;

// TODO: If construction of pie chart gets complicated a chart specific builders might be in order.
public class JenSoftAPIChartFactory implements ChartFactory {

    @Override
    public Chart createPieChart() {
        return new PieChart();
    }

    @Override
    public Chart createBackgroundChart() {
        return new BackgroundImageChart();
    }

}
