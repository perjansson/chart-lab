package com.peejay.chart.jensoftapi;

import com.jensoft.core.plugin.grid.Grid;
import com.jensoft.core.plugin.grid.GridPlugin;
import com.jensoft.core.plugin.stripe.StripePlugin;
import com.jensoft.core.plugin.stripe.painter.StripePalette;
import com.jensoft.core.plugin.symbol.*;
import com.jensoft.core.plugin.symbol.BarSymbol.MorpheStyle;
import com.jensoft.core.plugin.symbol.SymbolPlugin.SymbolNature;
import com.jensoft.core.plugin.symbol.painter.draw.BarDefaultDraw;
import com.jensoft.core.plugin.symbol.painter.effect.BarEffect2;
import com.jensoft.core.plugin.symbol.painter.effect.BarEffect3;
import com.jensoft.core.plugin.symbol.painter.effect.BarEffect4;
import com.jensoft.core.plugin.symbol.painter.effect.BarEffect5;
import com.jensoft.core.plugin.symbol.painter.fill.AbstractBarDefaultFill;
import com.jensoft.core.plugin.symbol.painter.fill.BarFill1;
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

        StripePlugin stripePlugin = new StripePlugin.MultiplierStripe.V(0, 20);
        StripePalette bp = new StripePalette();
        bp.addPaint(new Color(255, 255, 255, 40));
        bp.addPaint(new Color(0, 0, 0, 60));
        stripePlugin.setStripePalette(bp);
        stripePlugin.setAlpha(0.3f);
        //w2d.registerPlugin(stripePlugin);

        barLayer = new BarSymbolLayer();
        barPlugin.addLayer(barLayer);

        setBackground(Color.WHITE);
    }

    public void addBar(String name, Double base, Double value) {
        StackedBarSymbol barSymbol = new StackedBarSymbol();
        barSymbol.setThemeColor(new Color(255, 255, 255));
        barSymbol.setBase(0);
        barSymbol.setAscentValue(base + value);
        barSymbol.setThickness(25);
        barSymbol.setMorpheStyle(MorpheStyle.Rectangle);
        barSymbol.setBarDraw(new BarDefaultDraw());
        barSymbol.setBarFill(new BarFill1());
        barSymbol.setBarEffect(new BarEffect4());

        Stack offsetStack = new Stack("offset", new Color(235, 137, 92), base);
        barSymbol.addStack(offsetStack);

        Stack valueStack = new Stack(name, new Color(119, 150, 98), value);
        barSymbol.addStack(valueStack);

        barLayer.addSymbol(SymbolComponent.createStrut(BarSymbol.class, 10));
        barLayer.addSymbol(barSymbol);
    }

    @Override
    public BufferedImage asBufferedImage(int width, int height) {
        return this.getImageView(width, height);
    }
}