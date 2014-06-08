package com.peejay.chart.jensoftapi.horizontalbar;

import java.awt.*;
import java.awt.image.BufferedImage;

import com.jensoft.core.plugin.symbol.BarSymbol;
import com.jensoft.core.plugin.symbol.BarSymbol.MorpheStyle;
import com.jensoft.core.plugin.symbol.BarSymbolLayer;
import com.jensoft.core.plugin.symbol.SymbolComponent;
import com.jensoft.core.plugin.symbol.SymbolPlugin;
import com.jensoft.core.plugin.symbol.SymbolPlugin.SymbolNature;
import com.jensoft.core.plugin.symbol.painter.draw.BarDefaultDraw;
import com.jensoft.core.plugin.symbol.painter.effect.*;
import com.jensoft.core.plugin.symbol.painter.fill.BarFill1;
import com.jensoft.core.view.View2D;
import com.jensoft.core.window.Window2D;
import com.peejay.chart.Chart;

public class JenSoftApiHorizontalBarChart extends View2D implements Chart {

    private BarSymbolLayer barLayer;

    public JenSoftApiHorizontalBarChart() {
        setPlaceHolderAxisSouth(5);
        setPlaceHolderAxisWest(5);
        setPlaceHolderAxisEast(5);

        Window2D w2d = new Window2D.Linear(0, 100, 0, 0);
        registerWindow2D(w2d);

        SymbolPlugin barPlugin = new SymbolPlugin();
        barPlugin.setNature(SymbolNature.Horizontal);
        w2d.registerPlugin(barPlugin);

        barLayer = new BarSymbolLayer();
        barPlugin.addLayer(barLayer);
    }

    public void addBar(String name, Double base, Double value) {
        BarSymbol barSymbol = new BarSymbol();
        barSymbol.setThemeColor(Color.BLACK);
        barSymbol.setThickness(40);
        barSymbol.setBase(base + 0);
        barSymbol.setAscentValue(value);
        barSymbol.setName(name);
        barSymbol.setSymbol(name);
        barSymbol.setMorpheStyle(MorpheStyle.Rectangle);
        barSymbol.setBarDraw(new BarDefaultDraw());
        barSymbol.setBarFill(new BarFill1());
        barSymbol.setBarEffect(new BarEffect3());
        barLayer.addSymbol(SymbolComponent.createStrut(BarSymbol.class, 10));
        barLayer.addSymbol(barSymbol);
    }

    @Override
    public BufferedImage asBufferedImage(int width, int height) {
        return this.getImageView(width, height);
    }

}