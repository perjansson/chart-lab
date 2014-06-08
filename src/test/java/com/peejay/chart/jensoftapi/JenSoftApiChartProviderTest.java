package com.peejay.chart.jensoftapi;

import com.peejay.chart.jensoftapi.horizontalbar.JenSoftApiHorizontalBarChart;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class JenSoftApiChartProviderTest {

    @Test
    public void shouldCreateNewJenSoftApiHorizontalBarChart() {
        // given
        JenSoftApiChartProvider provider = new JenSoftApiChartProvider();
        // when
        JenSoftApiHorizontalBarChart chart = provider.getHorizontalBarChart();
        // then
        assertThat(chart).isNotNull();
    }
}