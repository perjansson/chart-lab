package com.peejay.chart.jensoftapi;

import com.peejay.chart.ChartDTO;
import com.peejay.chart.ChartUtil;
import com.peejay.chart.jensoftapi.horizontalbar.JenSoftApiHorizontalBarChart;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class JenSoftApiChartFactoryTest {

    private JenSoftApiChartFactory chartFactory;
    private JenSoftApiChartProvider chartProvider;
    private ChartUtil chartUtil;

    @Before
    public void setUp() {
        chartProvider = mock(JenSoftApiChartProvider.class);
        chartUtil = mock(ChartUtil.class);
        chartFactory = new JenSoftApiChartFactory(chartProvider, chartUtil);
    }

    @Test
    public void shouldAddBarsWhenCreatingHorizontalBarChart() {
        // given
        JenSoftApiHorizontalBarChart chart = mock(JenSoftApiHorizontalBarChart.class);
        given(chartProvider.getHorizontalBarChart()).willReturn(chart);

        Map<String, Double> inputs = new TreeMap<String, Double>();
        inputs.put("Name 1", 75d);
        inputs.put("Name 2", 25d);
        ChartInputDTO<Map<String, Double>> inputDTO = new ChartInputDTO<Map<String, Double>>(inputs, 500, 300, "png");

        // when
        chartFactory.createHorizontalBarChart(inputDTO);

        // then
        verify(chart).addBar("Total", 0d, 100d);
        verify(chart).addBar("Name 1", 0d, 75d);
        verify(chart).addBar("Name 2", 75d, 25d);
    }

    @Test
    public void shouldReturnChartImageBinaryWhenCreatingHorizontalBarChart() {
        // given
        JenSoftApiHorizontalBarChart chart = mock(JenSoftApiHorizontalBarChart.class);
        given(chartProvider.getHorizontalBarChart()).willReturn(chart);

        Map<String, Double> inputs = mock(Map.class);
        ChartInputDTO<Map<String, Double>> inputDTO = new ChartInputDTO<Map<String, Double>>(inputs, 500, 300, "png");

        byte[] imageAsByteArray = {00, 01, 10, 11};
        given(chartUtil.toImageByteArray(chart, 500, 300, "png")).willReturn(imageAsByteArray);

        // when
        ChartDTO chartDTO = chartFactory.createHorizontalBarChart(inputDTO);

        // then
        assertThat(chartDTO.getImageAsByteArray()).isEqualTo(imageAsByteArray);
    }
}