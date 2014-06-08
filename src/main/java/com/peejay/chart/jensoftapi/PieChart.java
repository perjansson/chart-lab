package com.peejay.chart.jensoftapi;

import com.jensoft.core.catalog.nature.JenSoftView;
import com.jensoft.core.palette.ColorPalette;
import com.jensoft.core.palette.InputFonts;
import com.jensoft.core.palette.RosePalette;
import com.jensoft.core.plugin.pie.Pie;
import com.jensoft.core.plugin.pie.Pie.PieNature;
import com.jensoft.core.plugin.pie.PiePlugin;
import com.jensoft.core.plugin.pie.PieSlice;
import com.jensoft.core.plugin.pie.PieToolkit;
import com.jensoft.core.plugin.pie.painter.effect.*;
import com.jensoft.core.plugin.pie.painter.fill.PieRadialFill;
import com.jensoft.core.plugin.pie.painter.label.AbstractPieSliceLabel.Style;
import com.jensoft.core.plugin.pie.painter.label.PieBorderLabel;
import com.jensoft.core.plugin.pie.painter.label.PieBorderLabel.LinkStyle;
import com.jensoft.core.view.View2D;
import com.jensoft.core.window.Window2D;
import com.peejay.chart.Chart;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PieChart extends View2D implements Chart {

    public PieChart() {
        super(2);

        Window2D window = new Window2D.Linear(-1, 1, -1, 1);
        registerWindow2D(window);

        PiePlugin piePlugin = new PiePlugin();
        window.registerPlugin(piePlugin);

        Pie pie = new Pie("pie", 80);
        pie.setPieNature(PieNature.User);
        pie.setCenterX(0);
        pie.setCenterY(0);
        pie.setPieFill(new PieRadialFill());
        pie.setStartAngleDegree(40);

        PieLinearEffect linearFX = new PieLinearEffect();
        linearFX.setIncidenceAngleDegree(120);
        linearFX.setOffsetRadius(5);

        PieCubicEffect cubicFX = new PieCubicEffect();
        cubicFX.setCubicKey(CubicEffectFrame.Round4.getKeyFrame());
        pie.setPieEffect(cubicFX);

        PieReflectionEffect reflectionFX = new PieReflectionEffect();
        reflectionFX.setBlurEnabled(false);
        reflectionFX.setOpacity(0.6f);
        reflectionFX.setLength(0.5f);
        reflectionFX.setReflectLabel(false);

        PieCompoundEffect compoundFX = new PieCompoundEffect(linearFX, cubicFX, reflectionFX);
        pie.setPieEffect(compoundFX);

        PieSlice s1 = PieToolkit.createSlice("s1", new Color(240, 240, 240, 240), 5, 0);
        PieSlice s2 = PieToolkit.createSlice("s2", RosePalette.COALBLACK, 5, 0);
        PieSlice s3 = PieToolkit.createSlice("s3", new Color(78, 148, 44), 30, 0);
        PieSlice s4 = PieToolkit.createSlice("s4", RosePalette.AEGEANBLUE, 5, 0);
        PieSlice s5 = PieToolkit.createSlice("s5", RosePalette.INDIGO, 45, 0);

        PieToolkit.pushSlices(pie, s1, s2, s3, s4, s5);
        piePlugin.addPie(pie);

        pie.setPassiveLabelAtMinPercent(18);

        // LABELS
        float[] fractions = {0f, 0.5f, 1f};
        Color[] colors = {new Color(0, 0, 0, 100), new Color(0, 0, 0, 255), new Color(0, 0, 0, 255)};
        Stroke s = new BasicStroke(2);
        pie.setPassiveLabelAtMinPercent(0);

        Font f = InputFonts.getNoMove(10);
        // LABEL 1
        PieBorderLabel label1 = PieToolkit.createBorderLabel("SILVER", ColorPalette.WHITE, f, 30);
        label1.setStyle(Style.Both);
        label1.setOutlineStroke(s);
        label1.setShader(fractions, colors);
        label1.setOutlineColor(RosePalette.REDWOOD);
        label1.setOutlineRound(20);
        label1.setLinkColor(RosePalette.COALBLACK);
        label1.setLinkStyle(LinkStyle.Line);
        label1.setLinkExtends(30);
        label1.setMargin(60);

        s1.addSliceLabel(label1);

        // LABEL 2
        PieBorderLabel label2 = PieToolkit.createBorderLabel("RHODIUM", ColorPalette.WHITE, f, 30);
        label2.setStyle(Style.Both);
        label2.setOutlineStroke(s);
        label2.setShader(fractions, colors);
        label2.setOutlineColor(RosePalette.LIME);
        label2.setOutlineRound(20);
        label2.setLinkColor(RosePalette.COALBLACK);
        label2.setLinkExtends(30);
        label2.setLinkStyle(LinkStyle.Line);
        label2.setMargin(40);
        s2.addSliceLabel(label2);

        // LABEL 3
        PieBorderLabel label3 = PieToolkit.createBorderLabel("COPPER", ColorPalette.WHITE, f, 30);
        label3.setStyle(Style.Both);
        label3.setOutlineStroke(s);
        label3.setShader(fractions, colors);
        label3.setOutlineColor(RosePalette.EMERALD);
        label3.setOutlineRound(20);
        label3.setLinkColor(RosePalette.COALBLACK);
        label3.setLinkStyle(LinkStyle.Line);
        label3.setLinkExtends(30);
        label3.setMargin(50);
        s3.addSliceLabel(label3);

        PieBorderLabel label4 = PieToolkit.createBorderLabel("PALLADIUM", ColorPalette.WHITE, f, 30);
        label4.setStyle(Style.Both);
        label4.setOutlineStroke(s);
        label4.setOutlineColor(RosePalette.COBALT);
        label4.setShader(fractions, colors);
        label4.setOutlineRound(20);
        label4.setLinkColor(RosePalette.COALBLACK);
        label4.setLinkStyle(LinkStyle.Line);
        label4.setLinkExtends(30);
        label4.setMargin(70);
        s4.addSliceLabel(label4);

        PieBorderLabel label5 = PieToolkit.createBorderLabel("PLATINIUM", ColorPalette.WHITE, f, 30);
        label5.setStyle(Style.Both);
        label5.setOutlineStroke(s);
        label5.setOutlineColor(RosePalette.COBALT);
        label5.setShader(fractions, colors);
        label5.setOutlineRound(20);
        label5.setLinkColor(RosePalette.COALBLACK);
        label5.setLinkStyle(LinkStyle.Line);
        label5.setLinkExtends(30);
        label5.setMargin(70);
        s5.addSliceLabel(label5);
    }

    @Override
    public BufferedImage asBufferedImage(int width, int height) {
        return this.getImageView(width, height);
    }
}
