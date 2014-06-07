package com.peejay.chart.jensoftapi;

import com.peejay.chart.Chart;
import com.peejay.chart.ChartDTO;
import com.peejay.chart.ChartFactory;
import com.peejay.chart.ChartUtil;
import com.peejay.chart.jensoftapi.background.BackgroundImageChart;
import com.peejay.chart.jensoftapi.horizontalbar.JenSoftApiHorizontalBarChart;
import com.peejay.chart.jensoftapi.horizontalbar.JenSoftApiHorizontalBarChartFactory;
import com.peejay.chart.jensoftapi.pie.PieChart;

public class JenSoftApiChartFactory implements ChartFactory {

    private JenSoftApiHorizontalBarChartFactory horizontalBarChartFactory;
    private ChartUtil chartUtil;

    public JenSoftApiChartFactory(JenSoftApiHorizontalBarChartFactory horizontalBarChartFactory, ChartUtil chartUtil) {
        this.horizontalBarChartFactory = horizontalBarChartFactory;
        this.chartUtil = chartUtil;
    }

    @Override
    public ChartDTO createHorizontalBarChart(HorizontalBarChartInputDTO input) {
        JenSoftApiHorizontalBarChart chart = horizontalBarChartFactory.createChart();
        chart.addBar("Total", 0d, 100d);
        Double accumulatedValue = 0d;
        for (String name : input.getInput().keySet()) {
            Double value = input.getInput().get(name);
            chart.addBar(name, accumulatedValue, value);
            accumulatedValue += value;
        }

        return createChartDTO(input, chart);
    }

    private ChartDTO createChartDTO(ChartInputDTO input, Chart chart) {
        byte[] imageAsByteArray = chartUtil.toImageByteArray(chart, input.getWidth(), input.getHeight(), input.getType());
        return new ChartDTO(imageAsByteArray);
    }

    @Override
    @Deprecated
    public Chart createPieChart() {
        return new PieChart();
    }

    @Override
    @Deprecated
    public Chart createBackgroundChart() {
        return new BackgroundImageChart();
    }

}
