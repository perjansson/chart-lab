package com.peejay.chart.jensoftapi;

import com.jensoft.core.palette.*;
import com.jensoft.core.plugin.stripe.StripePlugin;
import com.jensoft.core.plugin.stripe.painter.StripePalette;
import com.jensoft.core.plugin.symbol.*;
import com.jensoft.core.plugin.symbol.BarSymbol.MorpheStyle;
import com.jensoft.core.plugin.symbol.SymbolPlugin.SymbolNature;
import com.jensoft.core.plugin.symbol.painter.draw.BarDefaultDraw;
import com.jensoft.core.plugin.symbol.painter.effect.*;
import com.jensoft.core.plugin.symbol.painter.fill.BarFill1;
import com.jensoft.core.plugin.symbol.painter.fill.BarFill2;
import com.jensoft.core.view.View2D;
import com.jensoft.core.window.Window2D;
import com.peejay.chart.Chart;

import java.awt.*;
import java.awt.image.BufferedImage;

public class HorizontalBarChart extends View2D implements Chart {

    private BarSymbolLayer barLayer;

    public HorizontalBarChart() {
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
        StackedBarSymbol barSymbol = new StackedBarSymbol();
        barSymbol.setThemeColor(Color.WHITE);
        barSymbol.setBase(0);
        barSymbol.setAscentValue(base + value);
        barSymbol.setThickness(25);

        Stack offsetStack = new Stack("offset", NanoChromatique.LIGHT_GRAY, base);
        barSymbol.addStack(offsetStack);

        Stack valueStack = new Stack(name, NanoChromatique.DARK_GRAY, value);
        barSymbol.addStack(valueStack);

        barSymbol.setMorpheStyle(MorpheStyle.Rectangle);
        barSymbol.setBarFill(new BarFill1());
        //barSymbol.setBarDraw(new BarDefaultDraw());
        //barSymbol.setBarEffect(new BarEffect1());
        //barSymbol.setRound(5);
        barLayer.addSymbol(SymbolComponent.createStrut(BarSymbol.class, 10));
        barLayer.addSymbol(barSymbol);
    }

    @Override
    public BufferedImage asBufferedImage(int width, int height) {
        return this.getImageView(width, height);
    }
}