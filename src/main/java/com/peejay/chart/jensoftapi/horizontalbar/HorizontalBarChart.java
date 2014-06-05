package com.peejay.chart.jensoftapi.horizontalbar;

import java.awt.*;
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
import com.jensoft.core.plugin.symbol.painter.effect.*;
import com.jensoft.core.plugin.symbol.painter.fill.BarFill1;
import com.jensoft.core.plugin.symbol.painter.fill.BarFill2;
import com.jensoft.core.plugin.symbol.painter.label.BarSymbolDefaultLabel;
import com.jensoft.core.plugin.translate.TranslatePlugin;
import com.jensoft.core.plugin.zoom.box.ZoomBoxPlugin;
import com.jensoft.core.plugin.zoom.wheel.ZoomWheelPlugin;
import com.jensoft.core.view.View2D;
import com.jensoft.core.view.background.DarkViewBackground;
import com.jensoft.core.window.Window2D;
import com.peejay.chart.Chart;
import com.peejay.chart.jensoftapi.HorizontalBarChartInputDTO;

import javax.swing.border.Border;

public class HorizontalBarChart extends View2D implements Chart {

    public HorizontalBarChart(HorizontalBarChartInputDTO input) {
        setPlaceHolderAxisSouth(5);
        setPlaceHolderAxisWest(5);
        setPlaceHolderAxisEast(5);

        // window projection
        Window2D w2d = new Window2D.Linear(0, 100, 0, 0);
        registerWindow2D(w2d);

        SymbolPlugin barPlugin = new SymbolPlugin();
        barPlugin.setNature(SymbolNature.Horizontal);
        w2d.registerPlugin(barPlugin);

        BarSymbolLayer barLayer = new BarSymbolLayer();
        barPlugin.addLayer(barLayer);

        BarSymbol total = createBarSymbol("Total", 0d, 100d);
        barLayer.addSymbol(SymbolComponent.createStrut(BarSymbol.class, 10));
        barLayer.addSymbol(total);

        Double accumulatedValue = 0d;
        for (String name : input.getInput().keySet()) {
            Double value = input.getInput().get(name);
            BarSymbol b = createBarSymbol(name, accumulatedValue, value);
            barLayer.addSymbol(SymbolComponent.createStrut(BarSymbol.class, 10));
            barLayer.addSymbol(b);
            accumulatedValue += value;
        }
    }

    private BarSymbol createBarSymbol(String name, Double base, Double value) {
        BarSymbol b = new BarSymbol();
        b.setThemeColor(Color.BLACK);
        b.setThickness(40);
        b.setBase(base + 0);
        b.setAscentValue(value);
        b.setName(name);
        b.setSymbol(name);
        b.setMorpheStyle(MorpheStyle.Rectangle);
        b.setBarDraw(new BarDefaultDraw());
        b.setBarFill(new BarFill1());
        b.setBarEffect(new BarEffect3());
        return b;
    }

    @Override
    public BufferedImage asBufferedImage(int width, int height) {
        return this.getImageView(width, height);
    }
}