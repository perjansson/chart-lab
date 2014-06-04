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

@JenSoftView(background = DarkViewBackground.class)
public class HorizontalBarChart extends View2D implements Chart {

    public HorizontalBarChart(HorizontalBarChartInputDTO input) {
        super();

        setPlaceHolderAxisSouth(80);
        setPlaceHolderAxisWest(120);
        setPlaceHolderAxisEast(120);

        Color red = new Color(254, 206, 12);
        Color green = new Color(125, 186, 39);
        Color orange = new Color(223, 167, 59);

        // bar 1
        BarSymbol b1 = new BarSymbol();
        b1.setThemeColor(orange);
        b1.setThickness(20);
        b1.setBase(-30);
        b1.setAscentValue(62);
        b1.setName("b1");
        b1.setSymbol("bar 1");
        b1.setMorpheStyle(MorpheStyle.Round);
        b1.setBarDraw(new BarDefaultDraw());
        b1.setBarFill(new BarFill1());
        b1.setBarEffect(new BarEffect4());

        // bar 2
        BarSymbol b2 = new BarSymbol();
        b2.setThemeColor(green);
        b2.setThickness(20);
        b2.setBase(-30);
        b2.setDescentValue(83);
        b2.setName("b2");
        b2.setSymbol("bar 2");
        b2.setMorpheStyle(MorpheStyle.Round);
        b2.setBarDraw(new BarDefaultDraw());
        b2.setBarFill(new BarFill1());
        b2.setBarEffect(new BarEffect4());
        b2.setBarLabel(new BarSymbolDefaultLabel(0, 0));

        // bar 3
        BarSymbol b3 = new BarSymbol();
        b3.setThemeColor(red);
        b3.setThickness(20);
        b3.setBase(-30);
        b3.setDescentValue(47);
        b3.setName("b3");
        b3.setSymbol("bar 3");
        b3.setMorpheStyle(MorpheStyle.Rectangle);
        b3.setBarDraw(new BarDefaultDraw());
        b3.setBarFill(new BarFill1());
        b3.setBarEffect(new BarEffect4());

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

        barLayer.addSymbol(SymbolComponent.createGlue(BarSymbol.class));
        barLayer.addSymbol(b1);
        barLayer.addSymbol(SymbolComponent.createGlue(BarSymbol.class));
        barLayer.addSymbol(b2);
        barLayer.addSymbol(SymbolComponent.createGlue(BarSymbol.class));
        barLayer.addSymbol(b3);
        barLayer.addSymbol(SymbolComponent.createGlue(BarSymbol.class));

        w2d.registerPlugin(new OutlinePlugin());

        Legend legend = new Legend("H Bar Simple Chart");
        legend.setConstraints(new LegendConstraints(LegendPosition.South, 0.8f, LegendAlignment.Rigth));
        LegendPlugin legendPlugin = new LegendPlugin();
        legendPlugin.addLegend(legend);
        w2d.registerPlugin(legendPlugin);

        ZoomBoxPlugin zoomTool = new ZoomBoxPlugin();
        w2d.registerPlugin(zoomTool);

        TranslatePlugin toolTranslate = new TranslatePlugin();
        w2d.registerPlugin(toolTranslate);

        ZoomWheelPlugin zoomWheel = new ZoomWheelPlugin();
        w2d.registerPlugin(zoomWheel);

    }

    @Override
    public BufferedImage asBufferedImage(int width, int height) {
        return this.getImageView(width, height);
    }
}