/*
package com.example.zhaolei.suanfa;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class TuPianDuibi {

    public static void main(String[] args) {
        HistogramFilter str = new HistogramFilter();

        //String ystr="D:/kk/hh.jpg";
        //String bstr="D:/kk/ks/ll.jpg";
        //原图片
        String ystr = "D:/kk/hh.png";
        //对比的图片
        String bstr = "D:/kk/ks/hh.png";
        BufferedImage bid = null;
        BufferedImage bids = null;
        try {
            // URLClassLoader urlLoader = (URLClassLoader) jfrm.getClass().getClassLoader();
            // URL url = urlLoader.findResource(fileName);
            File imageFile = new File(ystr); // 原始图片文件
            File imageFiles = new File(bstr); // 原始图片文件
            bid = ImageIO.read(imageFile);
            bids = ImageIO.read(imageFiles);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //BufferedImage  y=str.getBufferedImage(ystr);
        //BufferedImage  b=str.getBufferedImage(bstr);

        double s = str.modelMatch(bid, bids);
        System.out.println("相似度" + s);
    }

    public static BufferedImage getBufferedImage(String str) {
        BufferedImage bid = null;
        try {
            // URLClassLoader urlLoader = (URLClassLoader) jfrm.getClass().getClassLoader();
            // URL url = urlLoader.findResource(fileName);
            File imageFile = new File(str); // 原始图片文件
            bid = ImageIO.read(imageFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bid;
    }


    private int redBins;
    private int greenBins;
    private int blueBins;

    public void HistogramFilter() {
        redBins = greenBins = blueBins = 4;
    }

    public void setGreenBinCount(int greenBinCount) {
        this.greenBins = greenBinCount;
    }


    public void setBlueBinCount(int blueBinCount) {
        this.blueBins = blueBinCount;

    }


    public float[] filter(BufferedImage src) {
        int width = src.getWidth();
        int height = src.getHeight();
        int[] inPixels = new int[width * height];
//        float[] histogramData = new float[redBins * greenBins * blueBins];
        float[] histogramData = new float[64];
        getRGB(src, 0, 0, width, height, inPixels);
        int index = 0;
        int redIdx = 0, greenIdx = 0, blueIdx = 0;
        int singleIndex = 0;
        float total = 0;
        for (int row = 0; row < height; row++) {
            int ta = 0, tr = 0, tg = 0, tb = 0;
            for (int col = 0; col < width; col++) {
                System.out.println("--------------------------");
                index = row * width + col;
                System.out.println(index);
                ta = (inPixels[index] >> 24) & 0xff;
                tr = (inPixels[index] >> 16) & 0xff;
                tg = (inPixels[index] >> 8) & 0xff;
                tb = inPixels[index] & 0xff;
                redIdx = (int) getBinIndex(redBins, tr, 255);
                greenIdx = (int) getBinIndex(greenBins, tg, 255);
                blueIdx = (int) getBinIndex(blueBins, tb, 255);
                System.out.println(redIdx + ";" + greenIdx + ";" + blueIdx); 
                singleIndex = redIdx + greenIdx * redBins + blueIdx * redBins * greenBins;
                //singleIndex ++;
                histogramData[singleIndex] += 1;
                System.out.println(); 
                total += 1;
            }

        }

        // start to normalize the histogram data

        for (int i = 0; i < histogramData.length; i++) {
            histogramData[i] = histogramData[i] / total;

        }
        return histogramData;

    }

    private float getBinIndex(int binCount, int color, int colorMaxValue) {
        float binIndex = (((float)color)/((float)colorMaxValue)) * ((float)binCount);
        if(binIndex >= binCount)
        binIndex = binCount -1 ;
        return binIndex;
        }
    public int[] getRGB( BufferedImage image, int x, int y, int width, int height, int[] pixels ) {
        int type = image.getType();
        if ( type == BufferedImage.TYPE_INT_ARGB || type == BufferedImage.TYPE_INT_RGB )
        return (int [])image.getRaster().getDataElements( x, y, width, height, pixels );
        return image.getRGB( x, y, width, height, pixels, 0, width );
        }
    public double modelMatch(BufferedImage sourceImage, BufferedImage candidateImage) {
        HistogramFilter hfilter = new HistogramFilter();
        float[] sourceData = hfilter.filter(sourceImage);
        float[] candidateData = hfilter.filter(candidateImage);
        double[] mixedData = new double[sourceData.length];
        for(int i=0; i<sourceData.length; i++ ) {
            mixedData[i] = Math.sqrt(sourceData[i] * candidateData[i]);
        }
        double similarity = 0;
        for(int i=0; i<mixedData.length; i++ ) {
            similarity += mixedData[i];
        }
        return similarity;

    }



}
*/
