package com.peejay.chart.jensoftapi;

import com.jensoft.core.palette.TangoPalette;
import com.jensoft.core.plugin.symbol.*;
import com.jensoft.core.plugin.symbol.BarSymbol.MorpheStyle;
import com.jensoft.core.plugin.symbol.SymbolPlugin.SymbolNature;
import com.jensoft.core.plugin.symbol.painter.draw.BarDefaultDraw;
import com.jensoft.core.plugin.symbol.painter.effect.BarEffect4;
import com.jensoft.core.plugin.symbol.painter.fill.BarFill1;
import com.jensoft.core.view.View2D;
import com.jensoft.core.window.Window2D;
import com.peejay.chart.Chart;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class VerticalBarChart extends View2D implements Chart {

    private BarSymbolLayer barLayer;

    public VerticalBarChart() {
        setPlaceHolderAxisSouth(5);
        setPlaceHolderAxisWest(5);
        setPlaceHolderAxisEast(5);

        Window2D w2d = new Window2D.Linear(0, 100, 0, 0);
        registerWindow2D(w2d);

        SymbolPlugin barPlugin = new SymbolPlugin();
        barPlugin.setNature(SymbolNature.Vertical);
        w2d.registerPlugin(barPlugin);

        barLayer = new BarSymbolLayer();
        barPlugin.addLayer(barLayer);

        setBackground(Color.WHITE);
    }

    public void addStackBars(List<Double> values) {
        List<Stack> stacks = new ArrayList<Stack>();
        for (int i = 0; i < values.size(); i++) {
            Stack stack = SymbolToolkit.createStack("stack " + i, getColorForStack(i), values.get(i));
            stacks.add(stack);
        }
        StackedBarSymbol barSymbol = SymbolToolkit.createStackedBarSymbol("b1", 0, 30, BarSymbol.SymbolInflate.Ascent, 100, stacks);
        barLayer.addSymbol(SymbolComponent.createStrut(BarSymbol.class, 10));
        barLayer.addSymbol(barSymbol);
    }

    private Color getColorForStack(int i) {
        if (i == 0 || i == 4) {
            return TangoPalette.ALUMINIUM1;
        } else if (i == 1 || i == 3) {
            return TangoPalette.ALUMINIUM2;
        } else {
            return TangoPalette.ALUMINIUM3;
        }
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