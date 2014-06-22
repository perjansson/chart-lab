package com.peejay.chart.jensoftapi;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class ChartProviderTest {

    @Test
    public void shouldCreateNewInstanceOfHorizontalBarChart() {
        // given
        ChartProvider provider = new ChartProvider();
        // when
        HorizontalBarChart chart1 = provider.getHorizontalBarChart();
        HorizontalBarChart chart2 = provider.getHorizontalBarChart();
        // then
        assertThat(chart1).isNotNull();
        assertThat(chart2).isNotNull();
        assertThat(chart1).isNotEqualTo(chart2);
    }

    @Test
    public void shouldCreateNewInstanceOfVerticalBarChart() {
        // given
        ChartProvider provider = new ChartProvider();
        // when
        VerticalBarChart chart1 = provider.getVerticalBarChart();
        VerticalBarChart chart2 = provider.getVerticalBarChart();
        // then
        assertThat(chart1).isNotNull();
        assertThat(chart2).isNotNull();
        assertThat(chart1).isNotEqualTo(chart2);
    }

}