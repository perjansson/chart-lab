package com.peejay.chart.jensoftapi;

import com.peejay.chart.Chart;
import com.peejay.chart.ChartDTO;
import com.peejay.chart.ChartFactory;
import com.peejay.chart.ChartUtil;
import com.peejay.chart.jensoftapi.background.BackgroundImageChart;
import com.peejay.chart.jensoftapi.horizontalbar.JenSoftApiHorizontalBarChart;
import com.peejay.chart.jensoftapi.pie.PieChart;

import java.util.Map;

public class JenSoftApiChartFactory implements ChartFactory {

    private JenSoftApiChartProvider chartProvider;
    private ChartUtil chartUtil;

    public JenSoftApiChartFactory(JenSoftApiChartProvider chartProvider, ChartUtil chartUtil) {
        this.chartProvider = chartProvider;
        this.chartUtil = chartUtil;
    }

    @Override
    public ChartDTO createHorizontalBarChart(ChartInputDTO<Map<String, Double>> inputDTO) {
        JenSoftApiHorizontalBarChart chart = chartProvider.getHorizontalBarChart();
        chart.addBar("Total", 0d, 100d);
        Double accumulatedValue = 0d;
        for (String name : inputDTO.getInput().keySet()) {
            Double value = inputDTO.getInput().get(name);
            chart.addBar(name, accumulatedValue, value);
            accumulatedValue += value;
        }

        return createChartDTO(inputDTO, chart);
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
