package com.peejay.chart.jensoftapi;

import com.peejay.chart.Chart;
import com.peejay.chart.ChartDTO;
import com.peejay.chart.ChartFactory;
import com.peejay.chart.ChartUtil;
import com.peejay.chart.jensoftapi.background.BackgroundImageChart;
import com.peejay.chart.jensoftapi.horizontalbar.HorizontalBarChart;
import com.peejay.chart.jensoftapi.pie.PieChart;

// TODO: If construction of pie chart gets complicated a chart specific builders might be in order.
public class JenSoftAPIChartFactory implements ChartFactory {

    public static final String IMAGE_TYPE = "png";

    @Override
    public Chart createPieChart() {
        return new PieChart();
    }

    @Override
    public Chart createBackgroundChart() {
        return new BackgroundImageChart();
    }

    @Override
    public ChartDTO createHorizontalBarChart(HorizontalBarChartInputDTO input) {
        HorizontalBarChart chart = new HorizontalBarChart(input);
        byte[] imageAsByteArray = ChartUtil.toImageByteArray(chart, 450, 350, IMAGE_TYPE);
        return new ChartDTO(imageAsByteArray);
    }

}
