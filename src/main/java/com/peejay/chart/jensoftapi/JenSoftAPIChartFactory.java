package com.peejay.chart.jensoftapi;

import com.peejay.chart.Chart;
import com.peejay.chart.ChartDTO;
import com.peejay.chart.ChartFactory;
import com.peejay.chart.ChartUtil;
import com.peejay.chart.jensoftapi.background.BackgroundImageChart;
import com.peejay.chart.jensoftapi.horizontalbar.HorizontalBarChart;
import com.peejay.chart.jensoftapi.horizontalbar.HorizontalBarChartFactory;
import com.peejay.chart.jensoftapi.pie.PieChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class JenSoftApiChartFactory implements ChartFactory {

    private final HorizontalBarChartFactory horizontalBarChartFactory;
    private final ChartUtil chartUtil;

    @Autowired
    public JenSoftApiChartFactory(HorizontalBarChartFactory horizontalBarChartFactory, ChartUtil chartUtil) {
        this.horizontalBarChartFactory = horizontalBarChartFactory;
        this.chartUtil = chartUtil;
    }

    @Override
    public ChartDTO createHorizontalBarChart(ChartInputDTO<Map<String, Double>> inputDTO) {
        HorizontalBarChart chart = horizontalBarChartFactory.createChart(inputDTO);
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
