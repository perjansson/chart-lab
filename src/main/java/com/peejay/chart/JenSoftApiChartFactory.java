package com.peejay.chart;

import com.peejay.chart.jensoftapi.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class JenSoftApiChartFactory implements ChartFactory {

    private final HorizontalBarChartFactory horizontalBarChartFactory;
    private VerticalBarChartFactory verticalBarChartFactory;
    private final PieChartFactory pieChartFactory;
    private final BackgroundImageChartFactory backgroundImageChartFactory;
    private final ChartUtil chartUtil;

    @Autowired
    public JenSoftApiChartFactory(HorizontalBarChartFactory horizontalBarChartFactory, VerticalBarChartFactory verticalBarChartFactory, PieChartFactory pieChartFactory, BackgroundImageChartFactory backgroundImageChartFactory, ChartUtil chartUtil) {
        this.horizontalBarChartFactory = horizontalBarChartFactory;
        this.verticalBarChartFactory = verticalBarChartFactory;
        this.pieChartFactory = pieChartFactory;
        this.backgroundImageChartFactory = backgroundImageChartFactory;
        this.chartUtil = chartUtil;
    }

    @Override
    public ChartDTO createHorizontalBarChart(ChartInputDTO<Map<String, Double>> inputDTO) {
        HorizontalBarChart chart = horizontalBarChartFactory.createChart(inputDTO);
        return createChartDTO(inputDTO, chart);
    }

    @Override
    public ChartDTO createVerticalBarChart(ChartInputDTO<List<Map<String, Double>>> inputDTO) {
        VerticalBarChart chart = verticalBarChartFactory.createChart(inputDTO);
        return createChartDTO(inputDTO, chart);
    }

    @Override
    public ChartDTO createPieChart(ChartInputDTO<Map<String, Double>> inputDTO) {
        PieChart chart = pieChartFactory.createChart(inputDTO);
        return createChartDTO(inputDTO, chart);
    }

    @Override
    public ChartDTO createBackgroundChart(ChartInputDTO<Map<String, Double>> inputDTO) {
        BackgroundImageChart chart = backgroundImageChartFactory.createChart(inputDTO);
        return createChartDTO(inputDTO, chart);
    }

    private ChartDTO createChartDTO(ChartInputDTO input, Chart chart) {
        byte[] imageAsByteArray = chartUtil.toImageByteArray(chart, input.getWidth(), input.getHeight(), input.getType());
        return new ChartDTO(imageAsByteArray);
    }

}
