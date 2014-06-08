package com.peejay.chart;

import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class ChartUtil {

    public byte[] toImageByteArray(Chart chart, int width, int height, String imageType) {
        byte[] imageInByteArray;
        BufferedImage image = chart.asBufferedImage(width, height);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, imageType, baos);
            baos.flush();
            imageInByteArray = baos.toByteArray();
            baos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return imageInByteArray;
    }

}
