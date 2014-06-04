package com.peejay.chart.jensoftapi.horizontalbar;

import java.awt.Color;
import java.awt.image.BufferedImage;

import com.jensoft.core.catalog.nature.JenSoftView;
import com.jensoft.core.palette.InputFonts;
import com.jensoft.core.plugin.legend.Legend;
import com.jensoft.core.plugin.legend.LegendConstraints;
import com.jensoft.core.plugin.legend.LegendConstraints.LegendAlignment;
import com.jensoft.core.plugin.legend.LegendConstraints.LegendPosition;
import com.jensoft.core.plugin.legend.LegendPlugin;
import com.jensoft.core.plugin.metrics.AxisMetricsPlugin;
import com.jensoft.core.plugin.metrics.manager.ModeledMetricsManager.MetricsModelRangeCollections;
import com.jensoft.core.plugin.outline.OutlinePlugin;
import com.jensoft.core.plugin.symbol.BarSymbol;
import com.jensoft.core.plugin.symbol.BarSymbol.MorpheStyle;
import com.jensoft.core.plugin.symbol.BarSymbolLayer;
import com.jensoft.core.plugin.symbol.SymbolComponent;
import com.jensoft.core.plugin.symbol.SymbolPlugin;
import com.jensoft.core.plugin.symbol.SymbolPlugin.SymbolNature;
import com.jensoft.core.plugin.symbol.painter.draw.BarDefaultDraw;
import com.jensoft.core.plugin.symbol.painter.effect.BarEffect4;
import com.jensoft.core.plugin.symbol.painter.fill.BarFill1;
import com.jensoft.core.plugin.symbol.painter.label.BarSymbolDefaultLabel;
import com.jensoft.core.plugin.translate.TranslatePlugin;
import com.jensoft.core.plugin.zoom.box.ZoomBoxPlugin;
import com.jensoft.core.plugin.zoom.wheel.ZoomWheelPlugin;
import com.jensoft.core.view.View2D;
import com.jensoft.core.view.background.DarkViewBackground;
import com.jensoft.core.window.Window2D;
import com.peejay.chart.Chart;
import com.peejay.chart.jensoftapi.HorizontalBarChartInputDTO;

public class HorizontalBarChart extends View2D implements Chart {

    public HorizontalBarChart(HorizontalBarChartInputDTO input) {
        setPlaceHolderAxisSouth(40);
        setPlaceHolderAxisWest(10);
        setPlaceHolderAxisEast(10);

        // window projection
        Window2D w2d = new Window2D.Linear(-100, 120, 0, 0);
        registerWindow2D(w2d);

        SymbolPlugin barPlugin = new SymbolPlugin();
        barPlugin.setNature(SymbolNature.Horizontal);
        w2d.registerPlugin(barPlugin);

        AxisMetricsPlugin.ModeledMetrics southMetrics = new AxisMetricsPlugin.ModeledMetrics.S();
        w2d.registerPlugin(southMetrics);
        southMetrics.setMetricsFont(InputFonts.getNeuropol(12));
        southMetrics.registerMetricsModels(MetricsModelRangeCollections.NanoGiga);

        BarSymbolLayer barLayer = new BarSymbolLayer();
        barPlugin.addLayer(barLayer);

        Double accumulatedValue = 0d;
        for (String name : input.getInput().keySet()) {
            Double value = input.getInput().get(name);
            BarSymbol b = new BarSymbol();
            b.setThemeColor(Color.BLACK);
            b.setThickness(20);
            b.setBase(accumulatedValue + 0);
            b.setAscentValue(accumulatedValue + value);
            b.setName(name);
            b.setSymbol(name);
            b.setMorpheStyle(MorpheStyle.Rectangle);
            b.setBarDraw(new BarDefaultDraw());
            b.setBarFill(new BarFill1());
            b.setBarEffect(new BarEffect4());
            barLayer.addSymbol(SymbolComponent.createGlue(BarSymbol.class));
            barLayer.addSymbol(b);

            accumulatedValue += value;
        }

        w2d.registerPlugin(new OutlinePlugin(Color.BLACK));
    }

    @Override
    public BufferedImage asBufferedImage(int width, int height) {
        return this.getImageView(width, height);
    }
}