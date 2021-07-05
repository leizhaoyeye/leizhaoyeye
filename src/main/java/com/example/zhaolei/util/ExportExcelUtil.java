package com.example.zhaolei.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * 导出到excel表工具
 * 2018-10-31
 */
@Slf4j
public class ExportExcelUtil  {


    public ExportExcelUtil() {
        super();
    }

    /**
     *
     * @param request
     * @param response
     * @param columnNames  列名，就是表格每列对应的名字。这是一个二维数组，分别存入列名称和传入的数据集rows对应的字段，要一一对应。
     * @param columnWidth   列宽，对应是每列的宽度，要和columnNames对应，这里传进去的列宽最后会在乘以256，这是excel表格规定的，可以自己看需求调节，默认宽度设置为""。
     * @param rows:传进去的数据，格式为List<Map<String,Object>>。
     * @param excelName 文件名称    String excelName="XXXX统计报表
     */
    public static void exportExcel(HttpServletRequest request, HttpServletResponse response, String[][] columnNames, String[] columnWidth, List<Map<String,Object>> rows, String excelName) {
        try {
            SXSSFWorkbook workbook = createSXSSFWorkbook(columnNames,columnWidth,rows,excelName);
            String fileName = excelName +".xlsx";
            fileName = new String(fileName.getBytes("GBK"), "ISO-8859-1"); // 取消乱码
            response.setContentType("octets/stream");
            response.addHeader("Content-Disposition", "attachment;filename="
                    + fileName);
            OutputStream out = response.getOutputStream();
            workbook.write(out);
            out.close();
            log.info( "成功导出Excel，excel名为："+excelName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static SXSSFWorkbook createSXSSFWorkbook(String[][] columnNames, String[] columnWidth, List<Map<String,Object>> rows,String excelName){
        SXSSFWorkbook workbook = new SXSSFWorkbook(); // 创建工作薄，相当于一个文件

        Sheet sheet = workbook.createSheet(); // 创建一个表
        //sheet.setDefaultColumnWidth((short) 3); // 设置默认列宽
        //sheet.setColumnWidth(0, 18 * 256); // 设置单位列列宽

        sheet.setMargin(XSSFSheet.TopMargin, 0.64); // 页边距（上）
        sheet.setMargin(XSSFSheet.BottomMargin, 0.64); // 页边距（下）
        sheet.setMargin(XSSFSheet.LeftMargin, 0.64); // 页边距（左）
        sheet.setMargin(XSSFSheet.RightMargin, 0.64); // 页边距（右）

        PrintSetup ps = sheet.getPrintSetup();
        ps.setPaperSize(PrintSetup.A4_PAPERSIZE); // 设置纸张大小
        ps.setLandscape(true); // 打印方向，true：横向，false：纵向(默认)

        // 标题样式
        CellStyle titleStyle = workbook.createCellStyle();
        // 标题字体
        Font titleFont = workbook.createFont();
        titleFont.setFontHeightInPoints((short) 12); // 字体大小
        titleFont.setFontName("宋体");
        titleStyle.setFont(titleFont);

        // 填报单位的样式
        CellStyle titleStyle_2 = workbook.createCellStyle();
        // 标题字体
        Font titleFont_2 = workbook.createFont();
        titleFont_2.setFontHeightInPoints((short) 11);
        titleFont_2.setFontName("宋体");
        titleStyle_2.setFont(titleFont_2);

        // 填报单位的样式
        CellStyle titleStyle_u = workbook.createCellStyle();
        // 标题字体
        Font titleFont_u = workbook.createFont();
        titleFont_u.setUnderline(XSSFFont.U_SINGLE);
        titleFont_u.setFontHeightInPoints((short) 11);
        titleFont_u.setFontName("宋体");
        titleStyle_u.setFont(titleFont_u);

        // 表头样式
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setWrapText(true); // 设置多行显示
        //这两句话是表示将表头单元格格式设置为文本型，在后面只要调用-----.setDataFormat(format.getFormat("@"))的方法就可以将数据设置为文本型。
        DataFormat format = workbook.createDataFormat();
        headerStyle.setDataFormat(format.getFormat("@"));
        // 表头字体
        Font headerFont = workbook.createFont();
        headerFont.setFontHeightInPoints((short) 9);
        headerFont.setFontName("宋体");
        headerStyle.setFont(headerFont);

        // 数据样式
        CellStyle dataStyle = workbook.createCellStyle();
        // 数据字体
        Font dataFont = workbook.createFont();
        dataFont.setFontHeightInPoints((short) 9);
        dataFont.setFontName("宋体");
        dataStyle.setFont(dataFont);

        // 尾部样式
        CellStyle footStyle = workbook.createCellStyle();
        // 尾部字体
        Font footFont = workbook.createFont();
        footFont.setFontHeightInPoints((short) 11);
        footFont.setFontName("宋体");
        footStyle.setFont(footFont);

        CellStyle commonStyle = workbook.createCellStyle();


        // 表格标题行
        Row row0 = sheet.createRow(0);
        row0.setHeight((short)(3 * 256));
        Cell cell0_0 = row0.createCell(0); // 创建单元格，参数说明的是第几个单元格
        cell0_0.setCellStyle(titleStyle);
        cell0_0.setCellValue(excelName); // 设置单元格 和里面的内容

        if(columnWidth.length>0){
            Integer clWidth;
            for(int i =0;i<columnWidth.length;i++){
                if(columnWidth[i]!=null &&!"".equals(columnWidth[i])){
                    clWidth = Integer.valueOf(columnWidth[i]);
                    sheet.setColumnWidth(i, clWidth*256);
                }
            }
        }



        Row row = null;
        Cell cell = null;
        for(int i = 1 ; i<=columnNames.length ; i++){
            row = sheet.createRow(i);
            row.setHeight((short)(2 * 256));
            for(int j = 0 ;j < columnNames[i-1].length;j++){
                cell = row.createCell(j);
                cell.setCellValue(columnNames[i-1][j]);
                cell.setCellStyle(headerStyle);

            }
        }

        sheet.getRow(columnNames.length).setZeroHeight(true);
        // 合并单元格
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, columnNames[0].length-1)); // 合并大标题行
        String[] names = columnNames[columnNames.length-1];

        // 数据填充,标题占一行，columnNames占columnNames.length行，之后才到数据行
        Object obj = null;

        for (int i = 0; i < rows.size(); i++) {
            Row dataRow = sheet.createRow(columnNames.length+1+ i);
            Map<String,Object> project = rows.get(i);
            for (int j = 0; j <names.length; j++) {
                Cell dataCell = dataRow.createCell(j);
                dataCell.setCellStyle(dataStyle);
                obj = project.get(names[j]);
                dataCell.setCellValue(obj==null?"":obj.toString());
            }
        }

        return workbook;
    }
}
