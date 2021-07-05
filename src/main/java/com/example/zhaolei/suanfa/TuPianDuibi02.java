package com.example.zhaolei.suanfa;

import junit.framework.Assert;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;


/**
 * 图片对比相似度工具
 */
public class TuPianDuibi02 {

    public static void main(String[] args) {
        File file = new File("F:\\文件\\0.jpg");
        File file1 = new File("F:\\文件\\0.jpg");


        File file2 = new File("F:\\文件\\营业执照.jpg");
        File file3 = new File("F:\\文件\\营业执照02.jpg");

        pictureComparison(file2,file3);

    }

    public static void pictureComparison( File fileInput, File fileOutPut) {
        BufferedImage bufileInput = null;
        try {
            bufileInput = ImageIO.read(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
        DataBuffer dafileInput = bufileInput.getData().getDataBuffer();
        int sizefileInput = dafileInput.getSize();
        BufferedImage bufileOutPut = null;
        try {
            bufileOutPut = ImageIO.read(fileOutPut);
        } catch (IOException e) {
            e.printStackTrace();
        }
        DataBuffer dafileOutPut = bufileOutPut.getData().getDataBuffer();
        int sizefileOutPut = dafileOutPut.getSize();
        int flagF=0;
        if (sizefileInput == sizefileOutPut) {//像素
            for (int j = 0; j < sizefileInput; j++) {
                if (dafileInput.getElem(j) != dafileOutPut.getElem(j)) {
                    flagF++;
                }
            }
        }else {
            flagF=(sizefileInput+sizefileOutPut)/2;//相识度为0
        }
        double similarity=1-(double)(flagF*2)/(sizefileInput+sizefileOutPut);//相似度
        System.out.println("图片对比相似度："+similarity*100+"%");
        //Assert.assertTrue(similarity==1, "图片对比相似度："+similarity);
    }
}


