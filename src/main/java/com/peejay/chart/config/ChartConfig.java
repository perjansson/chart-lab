package com.peejay.chart.config;

import com.peejay.chart.ChartFactory;
import com.peejay.chart.jensoftapi.JenSoftApiChartFactory;
import com.peejay.chart.jensoftapi.horizontalbar.JenSoftApiHorizontalBarChartFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChartConfig {

    @Bean
    public ChartFactory chartFactory() {
        return new JenSoftApiChartFactory(jenSoftHorizontalBarChartFactory());
    }

    private JenSoftApiHorizontalBarChartFactory jenSoftHorizontalBarChartFactory() {
        return new JenSoftApiHorizontalBarChartFactory();
    }


}
