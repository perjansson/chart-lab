package com.peejay.chart.jensoftapi;

import com.peejay.chart.jensoftapi.horizontalbar.HorizontalBarChart;
import org.springframework.stereotype.Service;

/**
 * The sole purpose of this class is to extract the creating of the JenSoftApi specific chart class, so it can be mocked
 * out during test of the chart specific factory.
 */
@Service
public class ChartProvider {

    public HorizontalBarChart getHorizontalBarChart() {
        return new HorizontalBarChart();
    }

}
