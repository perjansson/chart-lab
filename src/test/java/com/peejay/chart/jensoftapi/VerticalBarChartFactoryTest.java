package com.peejay.chart.jensoftapi;

import com.peejay.chart.ChartInputDTO;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class VerticalBarChartFactoryTest {

    private VerticalBarChartFactory factory;
    private ChartProvider chartProvider;

    @Before
    public void setUp() {
        chartProvider = mock(ChartProvider.class);
        factory = new VerticalBarChartFactory(chartProvider);
    }

    @Test
    public void shouldAddBarStacksWhenCreatingVerticalBarChart() {
        // given
        VerticalBarChart chart = mock(VerticalBarChart.class);
        given(chartProvider.getVerticalBarChart()).willReturn(chart);

        Map<String, Double> inputs1 = new TreeMap<String, Double>();
        inputs1.put("Name 1:1", 10d);
        inputs1.put("Name 1:2", 15d);
        inputs1.put("Name 1:3", 50d);
        inputs1.put("Name 1:4", 15d);
        inputs1.put("Name 1:5", 10d);

        Map<String, Double> inputs2 = new TreeMap<String, Double>();
        inputs2.put("Name 2:1", 5d);
        inputs2.put("Name 2:2", 20d);
        inputs2.put("Name 2:3", 50d);
        inputs2.put("Name 2:4", 20d);
        inputs2.put("Name 2:5", 5d);

        Map<String, Double> inputs3 = new TreeMap<String, Double>();
        inputs3.put("Name 3:1", 15d);
        inputs3.put("Name 3:2", 20d);
        inputs3.put("Name 3:3", 30d);
        inputs3.put("Name 3:4", 20d);
        inputs3.put("Name 3:5", 15d);

        List<Map<String, Double>> inputs = Arrays.asList(inputs1, inputs2, inputs3);

        ChartInputDTO<List<Map<String, Double>>> inputDTO = new ChartInputDTO<List<Map<String, Double>>>(inputs, 500, 300, "png");

        // when
        factory.createChart(inputDTO);

        // then
        verify(chart).addStackBars(Arrays.asList(10d, 15d, 50d, 15d, 10d));
        verify(chart).addStackBars(Arrays.asList(5d, 20d, 50d, 20d, 5d));
        verify(chart).addStackBars(Arrays.asList(15d, 20d, 30d, 20d, 15d));
    }

}