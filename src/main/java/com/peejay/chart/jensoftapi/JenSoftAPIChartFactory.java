package com.peejay.chart.jensoftapi;

import com.peejay.chart.Chart;
import com.peejay.chart.ChartFactory;
import com.peejay.chart.jensoftapi.pie.PieChart;

public class JenSoftAPIChartFactory implements ChartFactory {

    @Override
    public Chart createPieChart() {
        // TODO: If construction of pie chart gets complicated a chart specific builder might be in order.
        return new PieChart();
    }

}
