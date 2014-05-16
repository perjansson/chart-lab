package com.peejay.chart.jensoftapi.pie;

import org.junit.Test;

import java.awt.image.BufferedImage;

import static org.fest.assertions.Assertions.assertThat;

public class PieChartTest {

    @Test
    public void shouldGetBufferedImageFromPieChart() {
        // given
        PieChart pieChart = new PieChart();
        // when
        BufferedImage image = pieChart.asBufferedImage(700, 300);
        // then
        assertThat(image).isNotNull();
        assertThat(image.getWidth()).isEqualTo(700);
        assertThat(image.getHeight()).isEqualTo(300);
    }

}
