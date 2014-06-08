package com.peejay.chart.jensoftapi.horizontalbar;

import com.peejay.chart.jensoftapi.ChartInputDTO;
import com.peejay.chart.jensoftapi.ChartProvider;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class HorizontalBarChartFactoryTest {

    private HorizontalBarChartFactory horizontalBarChartFactory;
    private ChartProvider chartProvider;

    @Before
    public void setUp() {
        chartProvider = mock(ChartProvider.class);
        horizontalBarChartFactory = new HorizontalBarChartFactory(chartProvider);
    }

    @Test
    public void shouldAddBarsWhenCreatingHorizontalBarChart() {
        // given
        HorizontalBarChart chart = mock(HorizontalBarChart.class);
        given(chartProvider.getHorizontalBarChart()).willReturn(chart);

        Map<String, Double> inputs = new TreeMap<String, Double>();
        inputs.put("Name 1", 75d);
        inputs.put("Name 2", 25d);
        ChartInputDTO<Map<String, Double>> inputDTO = new ChartInputDTO<Map<String, Double>>(inputs, 500, 300, "png");

        // when
        horizontalBarChartFactory.createChart(inputDTO);

        // then
        verify(chart).addBar("Total", 0d, 100d);
        verify(chart).addBar("Name 1", 0d, 75d);
        verify(chart).addBar("Name 2", 75d, 25d);
    }

}