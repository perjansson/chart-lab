package com.peejay.chart.jensoftapi;

import com.peejay.chart.jensoftapi.horizontalbar.HorizontalBarChart;
import org.springframework.stereotype.Service;

@Service
public class ChartProvider {

    public HorizontalBarChart getHorizontalBarChart() {
        return new HorizontalBarChart();
    }

}
