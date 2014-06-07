package com.peejay.chart.jensoftapi;

import com.peejay.chart.ChartDTO;
import com.peejay.chart.ChartUtil;
import com.peejay.chart.jensoftapi.horizontalbar.JenSoftApiHorizontalBarChart;
import com.peejay.chart.jensoftapi.horizontalbar.JenSoftApiHorizontalBarChartFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class JenSoftApiChartFactoryTest {

    private JenSoftApiChartFactory factory;
    private JenSoftApiHorizontalBarChartFactory horizontalBarChartFactory;
    private ChartUtil chartUtil;

    @Before
    public void setUp() {
        horizontalBarChartFactory = mock(JenSoftApiHorizontalBarChartFactory.class);
        chartUtil = mock(ChartUtil.class);
        factory = new JenSoftApiChartFactory(horizontalBarChartFactory, chartUtil);
    }

    @Test
    public void shouldAddBarsWhenCreatingHorizontalBarChart() {
        // given
        JenSoftApiHorizontalBarChart chart = mock(JenSoftApiHorizontalBarChart.class);
        given(horizontalBarChartFactory.createChart()).willReturn(chart);

        Map<String, Double> inputs = new TreeMap<String, Double>();
        inputs.put("Name 1", 75d);
        inputs.put("Name 2", 25d);
        HorizontalBarChartInputDTO input = new HorizontalBarChartInputDTO(inputs, 500, 300, "png");

        // when
        factory.createHorizontalBarChart(input);

        // then
        verify(chart).addBar("Total", 0d, 100d);
        verify(chart).addBar("Name 1", 0d, 75d);
        verify(chart).addBar("Name 2", 75d, 25d);
    }

    @Test
    public void shouldReturnChartImageBinaryWhenCreatingHorizontalBarChart() {
        // given
        JenSoftApiHorizontalBarChart chart = mock(JenSoftApiHorizontalBarChart.class);
        given(horizontalBarChartFactory.createChart()).willReturn(chart);

        Map<String, Double> inputs = mock(Map.class);
        HorizontalBarChartInputDTO input = new HorizontalBarChartInputDTO(inputs, 500, 300, "png");

        byte[] imageAsByteArray = {00, 01, 10, 11};
        given(chartUtil.toImageByteArray(chart, 500, 300, "png")).willReturn(imageAsByteArray);

        // when
        ChartDTO chartDTO = factory.createHorizontalBarChart(input);

        // then
        assertThat(chartDTO.getImageAsByteArray()).isEqualTo(imageAsByteArray);
    }
}