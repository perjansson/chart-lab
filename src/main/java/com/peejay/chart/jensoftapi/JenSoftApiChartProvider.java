package com.peejay.chart.jensoftapi;

import com.peejay.chart.Chart;
import com.peejay.chart.jensoftapi.horizontalbar.JenSoftApiHorizontalBarChart;

public class JenSoftApiChartProvider {

    public JenSoftApiHorizontalBarChart getHorizontalBarChart() {
        return new JenSoftApiHorizontalBarChart();
    }

}
