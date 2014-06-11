package com.peejay.chart;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class ChartUtilTest {

    @Test
    public void shouldConvertChartToImageByteArray() throws IOException {
        // given
        Chart chart = mock(Chart.class);
        given(chart.asBufferedImage(117, 135)).willReturn(aBufferedImage());
        byte[] expectedImageBinary = {-1, -40, -1, -32, 0, 16, 74, 70, 73, 70, 0, 1, 2, 0, 0, 1, 0, 1, 0, 0, -1, -37, 0, 67, 0, 8, 6, 6, 7, 6, 5, 8, 7, 7, 7, 9, 9, 8, 10, 12, 20, 13, 12, 11, 11, 12, 25, 18, 19, 15, 20, 29, 26, 31, 30, 29, 26, 28, 28, 32, 36, 46, 39, 32, 34, 44, 35, 28, 28, 40, 55, 41, 44, 48, 49, 52, 52, 52, 31, 39, 57, 61, 56, 50, 60, 46, 51, 52, 50, -1, -37, 0, 67, 1, 9, 9, 9, 12, 11, 12, 24, 13, 13, 24, 50, 33, 28, 33, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, -1, -64, 0, 17, 8, 0, -121, 0, 117, 3, 1, 34, 0, 2, 17, 1, 3, 17, 1, -1, -60, 0, 31, 0, 0, 1, 5, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, -1, -60, 0, -75, 16, 0, 2, 1, 3, 3, 2, 4, 3, 5, 5, 4, 4, 0, 0, 1, 125, 1, 2, 3, 0, 4, 17, 5, 18, 33, 49, 65, 6, 19, 81, 97, 7, 34, 113, 20, 50, -127, -111, -95, 8, 35, 66, -79, -63, 21, 82, -47, -16, 36, 51, 98, 114, -126, 9, 10, 22, 23, 24, 25, 26, 37, 38, 39, 40, 41, 42, 52, 53, 54, 55, 56, 57, 58, 67, 68, 69, 70, 71, 72, 73, 74, 83, 84, 85, 86, 87, 88, 89, 90, 99, 100, 101, 102, 103, 104, 105, 106, 115, 116, 117, 118, 119, 120, 121, 122, -125, -124, -123, -122, -121, -120, -119, -118, -110, -109, -108, -107, -106, -105, -104, -103, -102, -94, -93, -92, -91, -90, -89, -88, -87, -86, -78, -77, -76, -75, -74, -73, -72, -71, -70, -62, -61, -60, -59, -58, -57, -56, -55, -54, -46, -45, -44, -43, -42, -41, -40, -39, -38, -31, -30, -29, -28, -27, -26, -25, -24, -23, -22, -15, -14, -13, -12, -11, -10, -9, -8, -7, -6, -1, -60, 0, 31, 1, 0, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, -1, -60, 0, -75, 17, 0, 2, 1, 2, 4, 4, 3, 4, 7, 5, 4, 4, 0, 1, 2, 119, 0, 1, 2, 3, 17, 4, 5, 33, 49, 6, 18, 65, 81, 7, 97, 113, 19, 34, 50, -127, 8, 20, 66, -111, -95, -79, -63, 9, 35, 51, 82, -16, 21, 98, 114, -47, 10, 22, 36, 52, -31, 37, -15, 23, 24, 25, 26, 38, 39, 40, 41, 42, 53, 54, 55, 56, 57, 58, 67, 68, 69, 70, 71, 72, 73, 74, 83, 84, 85, 86, 87, 88, 89, 90, 99, 100, 101, 102, 103, 104, 105, 106, 115, 116, 117, 118, 119, 120, 121, 122, -126, -125, -124, -123, -122, -121, -120, -119, -118, -110, -109, -108, -107, -106, -105, -104, -103, -102, -94, -93, -92, -91, -90, -89, -88, -87, -86, -78, -77, -76, -75, -74, -73, -72, -71, -70, -62, -61, -60, -59, -58, -57, -56, -55, -54, -46, -45, -44, -43, -42, -41, -40, -39, -38, -30, -29, -28, -27, -26, -25, -24, -23, -22, -14, -13, -12, -11, -10, -9, -8, -7, -6, -1, -38, 0, 12, 3, 1, 0, 2, 17, 3, 17, 0, 63, 0, -28, -19, 101, -122, 91, -24, 97, -68, -103, -32, -127, -101, 15, 42, -90, -14, -93, -44, 14, -3, -85, -76, -66, -16, 29, -123, -83, -18, -89, 111, 38, -81, 114, -29, 78, -123, 101, -97, -54, -78, -34, -33, 54, 54, -123, 93, -36, -16, 107, -127, -99, 83, 112, 96, -33, 118, -69, -71, 126, 32, 105, 55, 26, -18, -65, 116, -1, 0, -38, -106, -48, 106, 113, 67, 26, 73, 104, -54, -77, 71, -80, 40, 56, 57, -17, -118, 0, -93, 119, -32, -67, 54, -53, 67, -45, -81, -11, 29, 97, -32, 107, -56, 98, -100, 1, 108, 89, 10, -65, 37, 81, -77, -53, 40, -25, 7, 29, 105, -70, -81, -61, -53, 27, 25, 53, 88, 96, -42, 37, -102, 109, 54, -39, 110, 37, 86, -73, -38, 14, -19, -69, 64, 59, -67, 26, -95, -105, -58, -38, 58, 120, 6, 77, 22, 11, 43, -79, 113, 60, 48, -85, 67, 35, -17, -122, 41, -108, -110, -14, -95, 102, 36, 110, 39, -18, -116, 99, 25, -18, 105, 53, 15, -120, 58, 117, -50, -91, -30, 75, -107, -73, -71, -39, -86, 89, -63, 4, 32, -127, -107, 100, 10, 14, -18, 125, -88, 2, -27, -9, -62, 121, -83, 53, 27, 59, 86, -44, 14, 46, -75, 69, -79, 71, 49, 96, 24, -52, 6, 111, 48, 115, -2, -53, 46, 61, 69, 98, 77, -31, 107, 19, -30, -35, 55, 69, -79, -43, -4, -8, 47, 74, 15, 59, -53, 27, -94, 44, -20, -91, 89, 115, -9, -122, -36, -29, -36, 87, 71, 123, -15, 122, -42, -18, -25, 75, -107, -84, -18, -97, -20, 26, -53, 93, -115, -40, -55, -73, 104, -27, 80, -65, -17, 15, 51, 24, -12, 90, -96, -34, 43, -45, 117, -113, 31, -23, -102, -38, 125, -81, -20, 90, 69, -94, 121, -126, 85, 30, 100, -52, -77, 54, 48, 1, -11, -111, 122, -6, 26, 0, -21, 52, -35, 3, -61, -98, 17, -48, -46, -13, 83, -74, -73, -67, 114, -14, -125, 60, -88, -52, -91, -107, -126, -120, -8, -54, -85, 54, 120, 13, -33, 53, -71, 127, 38, -109, 124, -117, 4, -6, 109, -99, -59, -83, -28, -1, 0, 100, -76, 81, 105, -77, -53, 57, 68, -53, 72, 62, -17, -33, -29, 3, -8, 120, -86, 86, 18, -37, -22, -38, 102, -87, 12, 99, 111, -38, -30, -72, -73, -102, 39, -97, 116, 50, -18, -5, -78, 97, -113, -54, 85, 114, 48, -93, -99, -34, -62, -72, -115, 119, -59, -79, -24, 58, -114, -123, -91, 91, 45, -44, 112, 105, -105, -26, -30, 120, 85, -15, 29, -62, -18, 70, 81, -2, -47, -7, 91, -81, 66, 104, 2, -51, -33, -62, -8, 99, -44, 0, 77, 74, -32, 88, -76, 23, 51, 100, 91, -18, -105, 48, -74, -42, 80, -71, -7, -77, -40, -9, -84, 125, 83, -64, -23, -91, -8, -105, 80, -47, 102, -44, -53, 125, -101, 75, -109, 82, 73, 4, 92, -70, -86, -109, -75, -122, 120, 60, 87, 98, 60, 123, 21, -43, -11, -10, -123, -91, 71, 49, -107, 44, -17, 91, -49, -36, 18, 88, -26, -109, 116, -125, 110, 15, 1, 115, -76, -100, -25, 32, 87, 43, 115, -15, 7, 71, -109, -30, 100, 94, 35, 91, 9, -115, -117, 89, 125, -102, -26, 34, -117, -66, 66, 65, 4, -97, 92, -115, -93, -16, -96, 11, -70, -121, -62, 113, 101, 117, 52, 83, 107, 46, 17, 69, -88, -115, -4, -113, -66, -13, 72, -53, -73, -81, -16, -19, -49, -29, 80, -38, -4, 35, 55, -112, 73, 36, 90, -68, -124, -57, -86, -55, -89, -80, 16, 14, 21, 100, 42, 100, -21, -8, -30, -84, 106, 63, 22, -76, -19, 67, 77, -122, 7, -74, -69, 51, -90, -84, 46, -117, -112, -68, -64, -77, -76, -118, -67, 122, -123, 96, 63, 10, 125, -121, -59, -83, 63, 78, -118, -16, 69, 101, 118, 90, 123, -53, -71, -7, 0, 124, -110, -66, -27, 29, 122, -114, 40, 2, -92, -1, 0, 8, -95, -120, 95, -95, -41, 36, 51, 91, -36, -67, -68, 67, -20, -33, 44, -116, -80, 9, -78, -57, 119, -54, 49, -111, -8, 10, -61, -15, 119, -127, 109, 60, 43, -94, -37, 92, -74, -84, -14, 95, 73, -80, -3, -99, -19, -54, -92, -86, -54, 9, 104, -33, -95, -37, -100, 28, -13, -6, 103, 67, -59, 127, 20, 83, 83, -47, -75, 27, 77, 18, 77, 66, -58, 123, -53, -15, 57, -112, 54, -52, -59, -28, 44, 101, 73, 7, -43, 106, -66, -65, -29, -115, 14, -9, -31, -17, -4, 35, -70, 117, -107, -30, 51, -55, 12, -111, -57, 112, -37, -46, -49, 102, -35, -37, 24, -110, 112, -40, 110, 56, -58, -29, 64, 28, 22, -4, 1, -51, 20, -43, 28, 117, -94, -128, 58, -119, 115, -125, -58, 106, -116, -125, 45, -45, 21, -39, 39, -121, 102, -104, 55, 3, 56, -49, 21, -50, 106, 122, 123, 90, 74, 80, -113, -106, -128, 49, -92, 4, -114, -36, 113, 80, 108, -61, 114, 50, 62, -75, 109, -2, 94, 8, -86, -78, 55, 63, 45, 0, 56, 4, -17, 90, -70, 44, -26, -55, -82, -18, -94, -104, 35, -57, 14, 87, 29, 91, 44, 23, 3, -2, -6, -84, 96, -19, -11, -87, -83, -26, 17, 76, -114, -54, -91, 51, -122, 86, -24, 87, -72, -96, 15, -95, 124, 55, 99, -87, 95, 120, 15, 69, 75, 27, 29, 57, -124, -42, -54, 46, 38, -72, 102, 7, -85, 116, 11, -55, -19, -41, -5, -33, 90, -57, -42, 60, 27, 113, 123, -85, -22, 22, -42, -77, 105, -2, 109, -104, 70, -122, 27, -104, 90, 86, 104, -39, 121, 59, -104, -31, 126, 111, 65, -21, 91, 62, 8, -42, -41, 67, -16, 28, 86, -9, -53, -13, 89, -30, 37, 8, 119, 22, 12, 126, 79, -52, 48, -4, -21, -118, -15, -122, -71, -30, -115, 31, -59, 112, -8, -126, 98, -62, -38, 56, -38, 31, -77, 72, -118, -101, -94, -12, 36, 14, 121, -25, -21, -118, 0, -25, 117, 31, 13, -36, -24, 94, 51, -80, -70, -45, -42, 8, 69, -19, -51, -70, -61, 18, 51, 13, -77, 59, 96, -123, 61, 66, -122, 82, 127, 28, 87, 61, -83, -35, 65, 30, -71, -85, 67, 101, 13, -77, -23, -19, 125, 43, 65, -5, -95, -62, 111, 109, -69, 91, -17, 1, -73, -74, 113, -19, 94, -101, -66, -42, 93, 111, -62, 95, 104, -13, 36, 18, 127, -89, -85, -25, -3, 74, -96, 7, -97, -96, -36, 127, 10, -14, -85, -106, 91, -51, 94, -30, 117, -73, 91, 116, -106, 102, -108, 66, -121, -120, -61, 54, -32, -93, -40, 103, 20, 0, -3, 63, 76, 6, 63, 62, 117, 33, 79, -35, -89, -36, -37, -92, -116, 35, -119, 57, -49, 90, -71, 117, 114, -119, 0, 68, -64, 61, -15, 76, -78, 115, 59, 4, 92, 111, 29, 13, 0, 98, -36, 105, -49, 22, -29, -23, -44, 85, 76, 98, -70, -99, 70, -40, -86, 3, -69, 44, 70, 13, 99, -117, 57, 37, 56, 69, -51, 0, 84, 68, 37, 104, -83, 116, -45, 93, 80, 111, -64, 62, -108, 80, 7, -77, -64, 30, 25, 26, 39, 65, -69, 29, -123, 114, 30, 43, -77, 35, 108, -85, 30, 7, -15, 100, 116, -81, 95, -97, -61, -2, 76, 74, -64, 111, -112, 119, -11, -82, 3, -59, -6, 125, -38, -71, 87, 81, -79, -70, 96, 80, 7, -106, -49, 111, -98, -100, 85, 79, -77, -13, -45, -11, -83, -37, -85, 50, -84, 87, -72, -86, 127, 103, 42, 49, -118, 0, -51, 54, -8, -2, 26, 99, -62, -91, 125, 15, -67, 118, 26, 79, -123, 53, 13, 86, -62, 125, 65, 81, 99, -45, -19, -50, -39, 110, 27, -79, -29, -128, 58, -109, -51, 117, -66, 13, -16, 110, -107, 117, 30, -89, -30, 9, -107, -82, -84, -83, -117, 69, 101, 3, 12, -84, -101, 6, 26, 87, 3, -17, 18, -39, -62, -12, 24, -17, -40, 2, -106, -125, 51, -67, -25, -121, 116, -51, 69, -26, -35, -87, 105, -113, 27, 3, -14, -107, 104, -36, 52, 79, -63, -28, -123, 13, -41, -79, -23, 92, -121, -60, 61, 49, -76, -115, 124, 125, -94, -62, -10, -19, 35, 97, -121, -102, 66, 86, 69, -6, -13, 94, -107, -1, 0, 8, -122, -78, -102, -18, -123, -30, 75, -72, -116, -78, 90, 9, 21, -32, 25, 47, -75, -112, -31, -101, -116, 3, -115, -39, 29, -66, 85, 25, 38, -69, 57, -83, -76, -19, 82, 55, -110, 72, 86, 88, -38, 60, 126, -12, 112, 62, 94, -96, -6, 96, -25, 52, 1, -31, -2, 16, -15, 29, -35, -43, -2, -83, -30, -83, 100, -107, -74, -73, -74, 91, 59, 91, 75, 81, -109, 25, -36, -92, 21, 70, 97, -108, 24, -7, -66, 110, 119, 30, 121, -84, -51, 75, -61, 87, -16, -79, -68, -119, -31, -66, -73, -104, 9, 82, -30, -41, -18, -80, 110, 120, 82, 1, 29, 122, 99, -118, -20, -12, 79, 0, 90, -21, -34, 41, -105, 85, -14, 38, -121, 74, -114, 38, 91, 8, -50, 80, 72, -127, 54, -17, 11, -1, 0, 60, -39, -101, 62, -8, -49, -15, 98, -94, -8, -111, 104, 124, 63, -96, -23, -70, 13, -101, 59, -50, -9, 108, -10, -52, -93, 107, 109, 81, -78, 49, -11, 3, 98, -2, 20, 1, -25, -62, -58, -29, -97, 58, 57, 19, -116, -31, -58, 9, -85, -74, 5, 35, 102, 1, 113, -37, 62, -75, -12, 23, -119, 95, 79, 125, 14, 75, -85, -69, 91, 121, -48, 67, -26, -125, 34, 14, 65, 31, 40, -4, 107, -58, -75, 125, 54, 59, 27, -24, -25, -122, 16, -74, -73, -79, -7, -80, 99, -94, 115, -13, 39, -43, 79, 31, 76, 30, -12, 1, 64, -69, -56, 54, 50, 15, -10, 73, -92, -74, -119, -42, 71, 71, 80, -84, 125, 5, 91, -126, 38, 117, 85, 45, -56, -28, -25, -42, -83, -57, -89, -106, 59, -116, -108, 0, -119, 98, -101, 7, 7, 63, 74, 42, -28, 16, 31, 47, -26, 57, 57, -94, -128, 62, -127, -71, 109, -80, 57, -17, -118, -13, 127, 20, 95, 111, -36, -116, 6, 87, -14, 53, -24, 23, -9, 48, -37, -38, -76, -45, 56, 88, -108, 110, 102, 110, -128, 123, -41, -50, -1, 0, 17, 124, 115, 119, 15, -120, -53, 105, -122, 6, -46, -42, 40, -39, 24, 97, -124, -31, -122, 75, 14, -1, 0, -60, 63, -17, -102, 0, -110, -31, 119, -50, 73, 76, -113, 106, -122, 104, 35, -14, -103, -105, -88, -84, 43, 111, 29, 88, 75, 4, 107, 117, 5, -62, 77, -76, 9, 29, 21, 89, 73, -18, 64, -56, -59, 73, 39, -117, -76, 114, -54, -127, -27, -105, 127, 31, 44, 120, -38, 79, -82, 113, -6, 80, 7, -48, 26, 94, -127, 10, -4, 55, 77, 32, -115, -90, -22, -44, -105, -63, -63, 103, 113, -109, 89, -1, 0, 11, -28, -113, -5, 59, 84, -77, -14, -68, -89, -73, -68, 102, 17, -25, -18, -85, -115, -54, 63, 3, -72, 126, 20, -51, 111, 69, -105, -58, -2, 27, -48, -76, -8, -75, 9, 44, 35, 54, -1, 0, 107, 119, -116, 124, -19, -75, 66, 5, -10, 7, -52, 110, 127, -39, 21, 103, -63, 58, 46, -103, -31, 79, 14, -36, -38, -40, 75, 117, 117, 122, -60, -55, 119, 52, -111, 57, -110, 73, 0, -57, 60, 112, 56, -7, 71, 113, -49, 122, 0, -23, -81, -52, -97, 100, -108, -117, -93, 106, 19, 18, 52, -127, 67, 124, -85, -53, 15, -101, -79, 3, 25, -84, 127, 14, -37, -37, -22, 30, 22, -80, -73, -106, 55, 9, 53, -102, 121, -111, -97, -18, -78, -113, -105, -14, 56, -93, -30, 12, -19, 111, -32, 93, 113, 18, 55, -53, 105, -45, 47, -102, 49, -75, 114, -69, 121, 62, -68, -15, 90, 30, 29, -115, 83, 79, -78, 40, -93, 107, 90, 70, 67, 15, -91, 0, 89, 72, 34, 23, -113, 34, 34, -86, -58, -117, 2, -19, 24, 10, -93, -100, 99, -14, -81, 21, -15, -84, -77, 107, 95, 21, 44, 45, 2, 98, 61, 34, -35, -82, -114, 79, -34, 112, 60, -64, 7, -4, 8, 34, -29, -21, 94, -31, 113, 33, -75, -73, -106, 72, -93, 73, 36, 39, -9, 104, -51, -76, 51, 122, 19, -125, -114, -98, -107, -32, 62, 55, 123, -85, 63, 28, -66, -80, 68, 18, 59, 39, -111, 60, 113, -97, 48, -93, 118, -57, 3, -79, 3, -1, 0, -41, 64, 29, 47, -120, -68, 67, 21, -2, -77, 117, -94, 91, 56, 101, -14, -95, 93, -96, -10, -119, -91, 86, -2, 74, 107, 26, -14, -22, -63, 60, 33, 25, -44, 102, -114, 39, -75, -66, 34, 45, -51, -55, -36, -121, 112, 3, -81, 85, 21, -62, 106, -9, -41, -42, -38, -27, -67, -50, -118, -73, 80, -36, 44, 42, 55, -7, 95, 57, 110, -3, -79, -23, -46, -79, -11, 125, 35, 85, -77, -39, 115, -87, 69, 34, 79, 38, 3, -7, -78, -122, 114, 91, -26, 7, 3, -96, 43, -113, -13, -118, 0, -67, 127, -30, 57, 101, 102, 75, 54, -110, 52, -36, 12, 114, 1, -126, -35, -120, -4, -14, 127, -49, 29, 62, -125, -84, 77, -86, 68, -79, -7, 27, -99, 6, 46, 39, -35, -123, -49, 110, 49, -44, -11, -82, 109, 60, 9, -81, -1, 0, 99, -61, -86, -36, -37, -117, 107, 75, -115, -51, 23, -104, -31, 100, 117, -58, 119, 108, -21, -73, 3, -81, -29, -46, -67, 27, 79, -46, 18, -42, -46, 63, 38, 53, 68, 10, 8, 85, -23, -6, 80, 1, 21, -79, 41, -110, 59, -47, 91, -10, 54, -59, -31, 63, 38, 48, 104, -96, 14, -66, -9, 88, -14, 16, 22, 76, -113, 74, -14, 63, 26, -8, 35, 79, -41, -89, -118, 77, 10, -42, 27, 27, -5, -103, -16, -29, 36, 36, -91, -127, -29, 29, 23, -102, -12, -74, -37, 58, 47, -103, 70, -97, -90, 90, -55, -83, 91, 37, -44, 49, 78, -123, -78, -95, -44, 48, 12, 7, 4, 122, 17, -21, 64, 31, 54, 120, -105, -64, -38, -57, -123, 110, 108, 33, -66, 54, -41, 2, -8, 19, 3, 89, 75, -26, -121, 32, -128, 87, -41, 60, -113, -50, -97, 39, -125, -75, 75, 91, -75, -76, 109, 55, 80, -5, 105, 127, -8, -10, -5, 59, 110, 0, -128, 87, -89, 115, -49, 30, -43, -12, 39, -114, -12, 63, 11, 104, 30, 19, -69, -43, -94, -47, -84, 98, -68, -128, 110, -122, -28, -64, -34, 96, -109, 60, 49, 113, -13, 19, -98, -28, -41, 19, -16, -29, 88, -75, -118, -50, 93, 123, 88, -44, -61, -34, 67, 11, 74, -79, 78, -7, -110, 87, 61, 27, -98, -44, 1, 29, -65, -119, -68, 67, -90, -38, -35, 93, -8, -73, 79, -68, -45, 108, 70, -105, 53, -123, -116, -85, 106, -47, -2, -15, -116, 123, 83, 61, 71, 8, 112, 79, 124, -13, 94, -67, -32, 93, 98, 45, 111, -63, -70, 117, -14, -58, 34, 105, 33, 83, 34, -29, 25, 108, 114, 127, 26, -14, -49, 29, 120, -18, 95, 19, 120, 28, 71, 109, 24, -124, -52, -52, -77, 43, -100, 109, 81, -41, -6, 85, -17, -125, 55, -73, -111, -24, -53, 103, 115, 41, -14, -120, 45, 8, -35, -97, -109, -74, 61, 40, 3, -67, -8, -101, 32, -113, -31, -58, -73, -98, 55, 66, -87, -97, -9, -99, 87, -6, -42, -42, -113, 2, -37, -38, 66, 55, -17, 43, 4, 104, 9, -29, -115, -68, 87, 27, -15, 98, 57, 37, -8, 119, -85, -35, 11, -119, -74, -86, 91, -93, 64, 113, -77, -2, 62, 35, 59, -70, 103, 119, 110, -67, 43, -80, -45, -25, 18, -39, 71, 39, 4, 121, 72, -36, 127, -70, 40, 2, -106, -91, 127, 37, -82, -104, -91, -40, -18, 121, -92, 94, 58, -29, 123, 99, -12, -81, -100, -68, 102, 47, 45, -68, 69, 54, -91, 30, 94, -34, -23, -68, -62, 9, -31, -120, 24, 63, -54, -67, -9, 88, -66, -73, -71, -48, 96, -70, -69, -116, -26, 88, -110, 79, 40, 46, -26, 37, -128, 98, 54, -9, -81, 27, -15, 109, -78, 45, -65, -38, -101, 71, -68, 48, 39, -36, 55, 83, -120, 99, 25, -12, 79, -68, 127, 58, 0, -26, 44, 124, 69, 109, 38, -83, 20, 55, 49, 24, 109, -92, 59, 101, -112, 54, 79, -44, 87, -96, 107, 94, 26, -48, 27, -61, -70, 67, -61, 99, -25, -39, -36, 106, 9, 13, -43, -15, -70, 62, 122, 110, 111, -70, 1, -62, -128, 65, 81, -98, -62, -68, -74, -49, 79, -114, -26, -47, -28, 116, 17, 52, -49, -14, 99, -94, -128, 122, -116, -2, 63, -107, 119, -121, -62, 90, -116, 126, 27, -66, -45, 101, -44, -62, 67, 112, 35, 100, 73, 126, -26, -28, 108, -125, -19, -58, 104, 3, -46, 53, -35, 23, 69, -118, -21, 76, -72, 88, 126, -39, -76, -120, 29, -28, 121, -82, 55, 33, 27, 112, 88, 29, -128, 12, -28, -116, 115, -118, -62, -106, -27, 45, -17, 46, 45, 71, 34, 41, 25, 6, 61, -114, 43, -117, -47, -30, -15, -99, -34, -109, 107, 125, 121, 127, 112, -2, 29, -45, -91, 84, -124, -68, -95, 119, 21, 59, 84, 32, -58, 88, 14, 58, -10, -83, 63, 54, 107, -101, -87, 103, 102, 45, 36, -116, 93, -103, -113, 44, 77, 0, 116, -15, 106, -101, 23, 10, 5, 21, -49, -59, -65, -26, 12, -4, -25, -75, 20, 1, -33, -54, -37, 78, 65, -63, -59, 48, 93, -120, -62, -52, -110, 97, -44, -18, 12, 7, 67, 85, 46, -82, 88, -100, -81, 74, -90, 102, 96, -116, -68, -123, 110, -44, 1, -57, 120, -85, -61, -6, -113, -119, -11, -59, -109, 80, -15, 36, -25, 73, 50, 100, 91, -54, -18, -62, 46, 59, 14, 71, 94, 107, -127, -15, 22, -117, 127, -31, -19, 79, -20, 55, 92, -60, -88, 62, -49, 34, 54, -28, -110, 62, -52, -89, -46, -67, 90, -12, 117, -84, -101, -91, 19, 91, -117, 123, -124, 73, -96, 4, -78, -92, -88, 28, 41, -11, 25, -23, -8, 80, 7, -105, -58, 46, -81, 36, 91, 72, 89, -40, -56, 118, -86, -118, -9, -81, -121, -70, 71, -107, 21, -91, -49, 41, -10, 116, 16, 23, -1, 0, -98, -127, 71, 31, 95, -83, 113, 16, 88, -37, 90, -85, 11, 91, 104, -95, -33, -9, -118, 14, 79, -74, 79, 56, -10, -81, 66, -118, 73, 116, -65, -121, -74, 90, -115, -84, -47, 71, 113, -26, -108, 127, 49, 25, -63, 1, -120, -23, -72, 99, 24, -96, 14, -69, -59, 107, 107, 117, -31, 125, 66, -50, -23, 101, 54, -13, 90, -56, -81, -27, 46, -9, 3, 110, 73, 81, -36, -114, -65, -123, 100, -8, 118, 13, 71, 78, -8, 114, -74, -41, -89, -3, 48, 66, 85, 31, -5, -50, -33, 44, 95, -103, -37, -12, -84, 121, -68, 107, -86, -39, -22, -105, 54, -98, 93, -69, -57, 4, 54, -46, 111, 75, 118, 109, -34, 104, 81, -9, -73, 97, 126, 102, 29, 115, -57, -25, 92, -33, -117, 62, 37, -8, -126, -58, 2, -10, -115, 106, 18, 57, -103, 93, 37, -125, 59, -118, 48, 25, 7, 119, -82, 49, -57, 106, 0, -11, 9, 44, -98, -30, 82, 119, -72, 69, -29, -28, -12, -82, 39, -57, -79, -39, 46, -104, -42, -45, 24, -70, 99, -9, -115, -106, 53, -26, 94, 47, -8, -115, -30, 75, -63, -89, 61, -66, -84, -16, -63, 61, -86, 74, 99, -121, 104, -60, -68, -122, -58, 6, 71, 61, 43, -97, -16, -42, -93, 120, 124, 77, 97, 121, -86, -91, -51, -19, -84, 114, -122, -103, 37, 114, -59, -109, -8, -74, -28, -11, -18, 49, -34, -128, 58, 45, 71, 76, 109, 46, 120, -20, -38, 22, -117, 16, 70, -5, 24, -28, -115, -56, 27, 63, -114, 115, 82, -35, 107, 26, -59, -10, -100, -74, 30, 100, 12, -97, 117, -92, -105, -17, 1, 82, 107, 112, 61, -82, -83, 58, -107, 34, 38, 98, -16, -28, 96, 121, 100, -4, -72, -10, -19, -114, -40, -88, 45, -64, 96, 56, -59, 0, 111, -35, 107, 76, 124, 53, -91, -8, 118, -42, 70, 123, 91, 31, -99, -27, 43, -73, -52, -112, -25, -96, -20, -93, 39, -21, 81, -40, -36, 20, -5, -35, 77, 83, 17, 18, 55, 1, -127, -23, 86, 99, 94, 51, -64, -96, 13, 5, -7, -103, -114, 9, -94, -103, 1, 92, 28, -71, -49, -75, 20, 1, -40, -54, -125, -88, 28, -43, 103, 67, -125, -97, -54, -76, -82, 83, 111, 106, -50, -103, 75, 2, 122, 80, 6, 61, -46, 3, -48, 86, 100, -55, -98, -67, 107, 102, 88, -99, -40, 42, 43, 51, 19, -128, -86, 55, 19, 85, -91, -46, -75, 6, -71, -5, 63, -10, 117, -41, -38, 54, -7, -98, 87, -112, -37, -10, -25, 27, -79, -114, -98, -12, 1, -99, 107, 106, -41, 23, 49, 66, -95, -117, 72, -31, 6, 7, 114, 107, -44, 53, -59, -2, -52, -74, -77, -46, -19, -19, -68, -8, -94, 64, -84, 93, 119, 41, 95, -89, -87, -82, 83, -62, -74, 51, 69, -30, 29, 62, -30, -30, -46, -31, 32, 46, -58, 57, 12, 103, 14, -54, -84, -40, 95, 83, -14, -98, 7, -95, -82, -41, 83, -68, -119, -89, 14, -23, 41, 33, 25, -63, -114, 54, 99, -76, 99, 113, -29, -45, 35, -81, -83, 0, 115, -85, 111, -90, -68, 111, 34, -87, -79, -100, -29, 18, -59, 109, -105, 27, 70, 20, 124, -60, -126, 0, -29, 27, 127, 46, -75, -50, -22, -74, 94, 26, -70, -41, -83, 109, -82, 78, -87, -86, 45, -78, -122, 123, 53, 88, -60, 66, 66, 8, -27, 66, -116, -10, -29, -75, 122, 15, -104, -46, 71, -26, 36, 87, -82, -97, 123, 6, -43, -114, 71, -3, -13, -46, -71, -3, 82, -1, 0, 77, -80, -122, -34, -30, -46, 7, 120, -39, -124, -46, 56, -116, -31, 80, -14, -84, -51, -40, 48, -5, -66, -65, -91, 0, 115, 114, 71, -88, 79, 103, 53, -114, -115, -31, -3, 43, 70, -79, -103, 74, 55, -98, -126, 73, 10, -97, -10, 20, 28, 126, 53, 65, -12, 123, -115, 62, -35, 82, 86, -116, -122, 31, -64, -90, -35, 63, 8, -29, 106, -18, 99, -72, -43, -99, 85, 103, -77, -102, -59, 92, 18, -112, 37, -85, 73, 60, -128, 117, -62, -29, 3, 25, 31, -3, 106, -93, 125, 103, -88, 92, -37, -77, -57, 110, -15, -77, 49, -116, 59, -60, -45, 72, 91, -95, 92, 46, -43, 86, -49, 108, -75, 0, 114, 58, -4, 66, -17, -61, 118, 119, 103, 45, 113, 107, 59, 91, -52, 75, -69, 28, 16, 10, -28, -79, -55, -23, 92, -36, 100, -28, 113, -118, -23, -32, -47, -75, -120, -31, -44, -12, -37, -101, 11, -109, 113, 112, -85, 36, 10, -42, -20, -81, 38, -42, -22, 48, -66, -98, -90, -80, -41, 77, -65, -114, 31, 54, 75, 27, -107, -113, -54, 19, 121, -122, 38, 3, -53, 99, -123, 124, -1, 0, 116, -6, -48, 1, 20, -49, -64, -58, 77, 90, -115, -28, 45, -49, 31, 74, -85, 26, -15, -58, 106, -54, 49, -37, -49, 63, -115, 0, 95, -73, -56, 67, -56, -21, 69, 69, 109, 35, 5, 61, 5, 20, 1, -24, -105, 12, 79, -52, 114, 78, 43, 54, 71, 35, 60, 86, -44, -16, -122, 3, 7, 60, 99, 21, -105, 60, 56, -49, 31, -99, 0, 81, -75, -107, 34, -43, -83, 30, 71, 84, 69, -103, 75, 51, 30, 0, -36, 43, 114, -14, -10, -42, -19, 29, 98, -98, 9, 55, -23, -41, -111, 45, -69, 93, 121, 99, 113, -99, 49, -5, -62, -64, -115, -61, -98, -67, -72, -82, 118, -26, 47, -101, -91, 51, 76, -76, -114, -25, 92, -80, -126, 101, -35, 20, -105, 8, -82, -66, -93, 61, 40, 3, -76, -47, -11, 29, 62, 43, 93, 50, 25, 46, -29, -99, -20, -30, -75, 34, 37, -21, 27, -65, -103, 27, 62, -20, -32, -16, -36, -6, 1, -49, 81, 83, -91, -36, 22, -105, -112, 76, -20, 4, 102, 41, -111, -53, -112, 65, 30, 108, 32, -29, 4, -25, -27, -36, 127, 10, -85, -31, -85, 91, 37, -106, -19, -20, 89, 4, -84, -106, -23, 113, -10, 87, -109, -53, -34, 75, -18, 8, 72, -23, -64, -10, -94, 91, -87, -28, -46, -91, -100, -53, 34, 76, 32, -74, -109, 126, -17, -101, 50, 76, -24, -54, 123, 116, 81, -113, 122, 0, -72, 53, 59, 123, -17, 11, 52, 77, 36, 2, 66, -95, 22, 49, 62, -45, -123, -112, -113, -17, 47, 69, 0, -11, -26, -79, 117, 11, -3, 54, -21, -61, 80, 91, -92, -80, -91, -60, 112, 90, -92, -123, -28, 80, 25, 60, -78, 121, 30, -125, 36, 31, -21, -46, -91, -68, -110, 55, -67, -68, 77, -101, 22, 43, 93, 69, -108, -85, -98, 12, 13, 8, 67, -11, -3, -29, 86, 52, -10, 122, 117, -121, -120, -81, -39, -76, 121, 111, -54, 106, 81, -38, 42, 66, 55, -50, -79, -101, 87, -109, -9, 96, -80, -7, -125, 0, 126, -101, -88, 3, -84, 23, -42, -110, 93, 88, -127, 52, 47, 1, -45, 94, 49, 35, 79, -125, -72, -123, -62, -32, -111, -55, 29, -55, 6, -80, -81, 98, 95, -8, 69, -17, -31, 51, -7, 114, 71, 13, -64, -123, 99, -97, 14, -28, -69, 54, -42, 93, -60, -100, -1, 0, -84, 82, 58, 12, 114, 122, -103, -12, 11, 47, -75, 105, 126, 22, -102, 104, 21, 38, -68, 77, -41, -110, 23, 97, 36, -104, -115, -79, -114, -68, 19, -122, 60, -113, 106, -48, -68, -76, 22, 48, 88, -58, -116, -21, 44, -110, -64, 101, -109, 119, -52, 67, 73, -122, 95, 76, 80, 6, 84, 83, -61, -1, 0, 11, 78, -30, -7, -82, 99, -5, 38, -11, 85, -107, -91, 59, 127, -44, -96, -64, -2, 30, -71, -4, 106, -82, -71, -88, 105, -15, 120, 38, 77, 29, -91, -117, -5, 66, -49, 77, -73, -116, -74, -15, -106, -53, -112, -55, -113, 85, 49, 2, 127, -34, 21, -95, -30, 61, 48, 105, -46, 11, -104, -27, -13, -113, -99, 36, -118, -52, 119, 109, 81, -73, -27, -4, 14, -31, 92, 71, -114, -83, -43, -75, 91, 109, 74, 29, -66, 93, -12, 1, -104, -113, -17, -81, 7, -12, -37, 64, 28, -12, 78, 0, -5, -71, -89, -125, -106, -57, 122, -84, 1, 24, -32, -43, -56, 99, -55, 4, -11, -11, -96, 9, 98, 0, -125, -97, -46, -118, -79, 20, 75, -49, -52, 5, 20, 1, -23, 83, 72, -79, -25, -126, 112, 125, 107, 62, 105, -106, 92, -32, 98, -118, 40, 2, -92, -15, 111, 28, 17, 85, 21, 100, -74, -72, -114, -30, 38, 43, 44, 78, 29, 72, -20, 71, 74, 40, -96, 14, -25, -62, 90, 76, 86, -38, 4, 87, 65, -91, 73, 101, 4, -74, -42, -32, -31, -100, -125, -11, -7, -115, 99, 120, -123, -38, 11, 119, -122, 23, 117, -117, 43, -111, -58, 78, -46, 89, 70, 122, -32, 18, 72, 30, -76, 81, 64, 28, 38, -65, -30, -115, 102, 11, -104, -17, 35, -71, -116, -36, 70, 36, 69, 95, 41, 118, -80, -109, 27, -61, 12, 97, -127, -62, -25, 62, -126, -83, -24, 122, -90, -83, 14, -114, -38, -84, -9, 101, -75, 45, 74, -23, -18, 36, -112, -94, -97, 47, 11, -27, -126, -97, -35, 109, -69, -122, 71, 99, 69, 20, 1, -47, 120, 83, 80, -102, 72, -31, -79, 50, -72, 54, 127, 53, -71, 94, 2, -81, 32, -113, -61, 113, -4, -21, -82, -121, 79, -118, -18, 40, -124, -110, 72, -47, -84, -126, 68, 27, -7, 86, 13, -112, 65, -21, -116, -13, -118, 40, -96, 8, 53, -83, 56, 27, 86, 42, 78, 62, 102, -38, 122, 124, -57, 36, -3, 73, -28, -3, 77, 121, -66, -91, -115, 67, -62, 45, 23, 38, 77, 46, -9, -54, -55, -2, -29, 14, 63, -91, 20, 80, 7, 50, -74, -28, 58, -109, -54, -125, -13, 10, -45, -115, -20, -58, -17, -106, 108, 118, 25, 28, 81, 69, 0, 40, 104, -125, 49, 80, -37, 73, -29, 61, 104, -94, -118, 0, -1, -39};

        // when
        byte[] imageBinary = new ChartUtil().toImageByteArray(chart, 117, 135, "jpg");

        // then
        assertThat(imageBinary).isEqualTo(expectedImageBinary);
    }

    private BufferedImage aBufferedImage() throws IOException {
        InputStream iis = this.getClass().getResourceAsStream("/com/peejay/chart/ChartUtilTest.jpg");
        return ImageIO.read(iis);
    }

}