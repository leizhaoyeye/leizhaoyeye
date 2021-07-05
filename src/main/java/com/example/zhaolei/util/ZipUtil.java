package com.example.zhaolei.util;

import com.alibaba.fastjson.util.IOUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * @ClassName: ZipUtil
 * @Description: zip压缩工具类
 * @author: xingliang.hou
 * @date: 2019-11-21
 * @Copyright: 2019 www.dbappsecurity.com.cn. All rights reserved.
 */
@Slf4j
public class ZipUtil {

    private static final int BUFFER_SIZE = 1024;

    public static void unZipFiles(String zipPath, String descDir) throws IOException {
        File zipFile = new File(zipPath);
        OutputStream out = null;
        try (ZipFile zip = new ZipFile(zipFile, Charset.forName("GBK"))) {
            Enumeration entries = zip.entries();
            while (entries.hasMoreElements()) {
                ZipEntry entry = (ZipEntry) entries.nextElement();
                String zipEntryName = entry.getName();
                InputStream in = zip.getInputStream(entry);
                String outPath = (descDir + File.separator + zipEntryName).replaceAll("\\\\", "/");
                // 判断路径是否存在,不存在则创建文件路径
                File file = new File(outPath.substring(0, outPath.lastIndexOf('/')));
                if (!file.exists()) {
                    file.mkdirs();
                }
                // 判断文件全路径是否为文件夹,如果是上面已经上传,不需要解压
                if (new File(outPath).isDirectory()) {
                    continue;
                }
                // 输出文件路径信息
                out = new FileOutputStream(outPath);
                byte[] buf1 = new byte[BUFFER_SIZE];
                int len;
                while ((len = in.read(buf1)) > 0) {
                    out.write(buf1, 0, len);
                }
            }
        } catch (IOException e) {
            throw new IOException(e);
        } finally {
            IOUtils.close(out);
        }
    }


    public static void toZip(String srcDir, String outFileName) {
        FileOutputStream out = null;
        File file = new File(outFileName);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            out = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            log.error("文件不存在", e);
            //throw new BusinessException(String.format("文件%s不存在", outFileName));
        }
        toZip(srcDir, out);
    }

    public static void toZip(String srcDir, FileOutputStream out) throws RuntimeException {
        File sourceFile = null;
        try (ZipOutputStream zos = new ZipOutputStream(out)) {
            sourceFile = new File(srcDir);
            compress(sourceFile, zos, sourceFile.getName());
        } catch (Exception e) {
            log.error("zip error from", e);
            //throw new BusinessException("zip error from ZipUtils");
        }
    }

    private static void compress(File sourceFile, ZipOutputStream zos, String name) {
        byte[] buf = new byte[BUFFER_SIZE];
        if (sourceFile.isFile()) {
            try (FileInputStream in = new FileInputStream(sourceFile)) {
                zos.putNextEntry(new ZipEntry(name));
                int len;
                while ((len = in.read(buf)) != -1) {
                    zos.write(buf, 0, len);
                }
                zos.closeEntry();
            } catch (IOException e) {
                log.error("文件压缩出错", e);
                //throw new BusinessException("文件压缩出错");
            }
        } else {
            File[] listFiles = sourceFile.listFiles();
            for (File file : listFiles) {
                compress(file, zos, file.getName());
            }
        }
    }


    /**
     * 功能:压缩多个文件成一个zip文件
     * @param srcfile：源文件列表
     * @param zipfile：压缩后的文件
     * @author Itwalder
     */
    public static void zipFiles(File[] srcfile,File zipfile){
        byte[] buf=new byte[1024];
        try {
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipfile));
            for(int i=0;i < srcfile.length;i++){
                FileInputStream in=new FileInputStream(srcfile[i]);
                out.putNextEntry(new ZipEntry(srcfile[i].getName()));
                int len;
                while( (len=in.read(buf)) > 0){
                    out.write(buf,0,len);
                }
                out.closeEntry();
                in.close();
            }
            out.close();
            log.info("压缩完成.");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("文件压缩出错", e);
            //throw new BusinessException("zip error from ZipUtils");
        }
    }
    /**
     * 功能:压缩多个文件成一个zip文件
     * @param FileInputStreams：源文件列表
     * @param fileNames 源文件名列表,名字个数要和FileInputStreams匹配
     * @param zipfile：压缩后的文件
     * @author Itwalder
     */
    public static void zipFiles2(FileInputStream[] FileInputStreams,String[] fileNames, File zipfile){
        byte[] buf=new byte[1024];
        try {
            //ZipOutputStream类：完成文件或文件夹的压缩
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipfile));
            for(int i=0;i < FileInputStreams.length;i++){
                FileInputStream in = FileInputStreams[i];
                out.putNextEntry(new ZipEntry(fileNames[i]));
                int len;
                while( (len=in.read(buf)) > 0){
                    out.write(buf,0,len);
                }
                out.closeEntry();
                in.close();
            }
            out.close();
            log.info("压缩完成.");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("文件压缩出错", e);
            //throw new BusinessException("zip error from ZipUtils");
        }
    }
    /**
     * 功能:解压缩
     * @param zipfile：需要解压缩的文件
     * @param descDir：解压后的目标目录
     * @author Itwalder
     */
    public static void unZipFiles(File zipfile, String descDir) {
        try {
            ZipFile zf = new ZipFile(zipfile);
            for (Enumeration entries = zf.entries(); entries.hasMoreElements(); ) {
                ZipEntry entry = (ZipEntry) entries.nextElement();
                String zipEntryName = entry.getName();
                InputStream in = zf.getInputStream(entry);
                OutputStream out = new FileOutputStream(descDir + zipEntryName);
                byte[] buf1 = new byte[1024];
                int len;
                while ((len = in.read(buf1)) > 0) {
                    out.write(buf1, 0, len);
                }
                in.close();
                out.close();
                log.info("解压缩完成.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("文件解压缩出错", e);
            //throw new BusinessException("unzip error from ZipUtils");
        }
    }
}
