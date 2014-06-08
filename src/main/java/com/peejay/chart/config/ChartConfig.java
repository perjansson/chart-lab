package com.peejay.chart.config;

import com.peejay.chart.ChartFactory;
import com.peejay.chart.ChartUtil;
import com.peejay.chart.jensoftapi.JenSoftApiChartFactory;
import com.peejay.chart.jensoftapi.JenSoftApiChartProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChartConfig {

    @Bean
    public ChartFactory chartFactory() {
        return new JenSoftApiChartFactory(jenSoftHorizontalBarChartFactory(), new ChartUtil());
    }

    private JenSoftApiChartProvider jenSoftHorizontalBarChartFactory() {
        return new JenSoftApiChartProvider();
    }


}
