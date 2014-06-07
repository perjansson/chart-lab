package com.peejay.jensoftapi;

import com.peejay.chart.Chart;
import com.peejay.chart.jensoftapi.JenSoftApiChartFactory;
import com.peejay.chart.jensoftapi.pie.PieChart;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class JenSoftAPIChartFactoryTest {

    @Test
    public void shouldCreatePieChart() {
        // given
        JenSoftApiChartFactory factory = new JenSoftApiChartFactory();
        // when
        Chart pieChart = factory.createPieChart();
        // then
        assertThat(pieChart).isInstanceOf(PieChart.class);
    }

}
