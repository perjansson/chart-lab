package com.peejay.chart.jensoftapi;

import com.peejay.chart.ChartDTO;
import com.peejay.chart.ChartInputDTO;
import com.peejay.chart.ChartUtil;
import com.peejay.chart.JenSoftApiChartFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class JenSoftApiChartFactoryTest {

    private JenSoftApiChartFactory chartFactory;

    private HorizontalBarChartFactory horizontalBarChartFactory;
    private PieChartFactory pieChartFactory;
    private BackgroundImageChartFactory backgroundImageChartFactory;
    private ChartUtil chartUtil;

    @Before
    public void setUp() {
        horizontalBarChartFactory = mock(HorizontalBarChartFactory.class);
        pieChartFactory = mock(PieChartFactory.class);
        backgroundImageChartFactory = mock(BackgroundImageChartFactory.class);
        chartUtil = mock(ChartUtil.class);
        chartFactory = new JenSoftApiChartFactory(horizontalBarChartFactory, pieChartFactory, backgroundImageChartFactory, chartUtil);
    }

    @Test
    public void shouldReturnChartImageBinaryWhenCreatingHorizontalBarChart() {
        // given
        Map<String, Double> inputs = mock(Map.class);
        ChartInputDTO<Map<String, Double>> inputDTO = new ChartInputDTO<Map<String, Double>>(inputs, 500, 300, "png");

        HorizontalBarChart chart = mock(HorizontalBarChart.class);
        given(horizontalBarChartFactory.createChart(inputDTO)).willReturn(chart);

        byte[] imageAsByteArray = {00, 01, 10, 11};
        given(chartUtil.toImageByteArray(chart, 500, 300, "png")).willReturn(imageAsByteArray);

        // when
        ChartDTO chartDTO = chartFactory.createHorizontalBarChart(inputDTO);

        // then
        assertThat(chartDTO.getImageAsByteArray()).isEqualTo(imageAsByteArray);
    }
}