package com.peejay.chart.jensoftapi;

import org.junit.Test;

import java.awt.image.BufferedImage;

import static org.fest.assertions.Assertions.assertThat;

public class VerticalBarChartTest {

    @Test
    public void shouldGetBufferedImageFromPieChart() {
        // given
        VerticalBarChart chart = new VerticalBarChart();
        // when
        BufferedImage image = chart.asBufferedImage(700, 300);
        // then
        assertThat(image).isNotNull();
        assertThat(image.getWidth()).isEqualTo(700);
        assertThat(image.getHeight()).isEqualTo(300);
    }
}