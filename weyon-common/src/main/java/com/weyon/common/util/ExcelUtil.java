package com.weyon.common.util;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * @author liuxu
 * @description easy poi excel 工具类
 * @date 2019-06-18
 **/
public class ExcelUtil {

    /**
     * 导出excel
     * @param list list数据
     * @param title 标题
     * @param sheetName sheet名称
     * @param pojoClass class属性
     * @param fileName 文件名
     * @param isCreateHeader 是否创建头部
     * @param response 响应流
     */
    public static void exportExcel(List<?> list, String title, String sheetName, Class<?> pojoClass, String fileName, boolean isCreateHeader, HttpServletResponse response){
        ExportParams exportParams = new ExportParams(title, sheetName);
        exportParams.setCreateHeadRows(isCreateHeader);
        defaultExport(list, pojoClass, fileName, response, exportParams);

    }
    public static void exportExcel(List<?> list, String title, String sheetName, Class<?> pojoClass,String fileName, HttpServletResponse response){
        defaultExport(list, pojoClass, fileName, response, new ExportParams(title, sheetName));
    }
    public static void exportExcel(List<Map<String, Object>> list, String fileName, HttpServletResponse response){
        defaultExport(list, fileName, response);
    }

    private static void defaultExport(List<?> list, Class<?> pojoClass, String fileName, HttpServletResponse response, ExportParams exportParams) {
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams,pojoClass,list);
        if (workbook != null) {
            downLoadExcel(fileName, response, workbook);
        }
    }

    public static void downLoadExcel(String fileName, HttpServletResponse response, Workbook workbook) {
        try {
            resFormat(response, fileName);
            workbook.write(response.getOutputStream());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * 下载excel模板文件
     * @param  is 文件流
     * @param fileName 文件名称
     */
    public static void downloadExcel(InputStream is, String fileName, HttpServletResponse response) {
        try {
            resFormat(response, fileName);
            // 循环取出流中的数据
            byte[] b = new byte[1024];
            int len;
            while ((len = is.read(b)) > 0){
                response.getOutputStream().write(b, 0, len);
            }
            is.close();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * 设置输出的格式
     * @param response
     * @param fileName
     * @throws Exception
     */
    private static void resFormat(HttpServletResponse response, String fileName) throws Exception {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-Type", "application/vnd.ms-excel");
        response.addHeader("Content-Disposition",
                "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
    }

    /**
     * 临时保存excel到本地
     * @param workbook
     * @param filePath
     * @param fileName
     * @throws Exception
     */
    public static void uploadLocalExcel(Workbook workbook, String filePath, String fileName) throws Exception {
        OutputStream stream;
        File file = new File(filePath);
        if(!file.exists()){
            file.mkdirs();
        }
        File errorFile = new File(file, fileName);
        stream = new FileOutputStream(errorFile);
        workbook.write(stream);
        if(stream != null){
            stream.close();
        }
    }

    private static void defaultExport(List<Map<String, Object>> list, String fileName, HttpServletResponse response) {
        Workbook workbook = ExcelExportUtil.exportExcel(list, ExcelType.HSSF);
        if (workbook != null) {
            downLoadExcel(fileName, response, workbook);
        }
    }

    public static <T> List<T> importExcel(String filePath, Integer titleRows, Integer headerRows, Class<T> pojoClass) {
        if (StringUtils.isBlank(filePath)){
            return null;
        }
        ImportParams params = defaultImportParams(titleRows, headerRows);
        List<T> list;
        try {
            list = ExcelImportUtil.importExcel(new File(filePath), pojoClass, params);
        }catch (NoSuchElementException e){
            throw new RuntimeException("模板不能为空");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        return list;
    }

    public static <T> List<T> importExcel(InputStream in, Integer titleRows, Integer headerRows, Class<T> pojoClass) {
        if (in == null){
            return null;
        }
        ImportParams params = defaultImportParams(titleRows, headerRows);
        List<T> list;
        try {
            list = ExcelImportUtil.importExcel(in, pojoClass, params);
        }catch (NoSuchElementException e){
            throw new RuntimeException("excel文件不能为空");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return list;
    }

    public static <T> ExcelImportResult<T> importExcelMore(InputStream in, Integer titleRows, Integer headerRows, Class<T> pojoClass) {
        if (in == null){
            return null;
        }
        ImportParams params = defaultImportParams(titleRows, headerRows);
        ExcelImportResult<T> result;
        try {
            result = ExcelImportUtil.importExcelMore(in, pojoClass, params);
        }catch (NoSuchElementException e){
            throw new RuntimeException("excel文件不能为空");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return result;
    }

    private static ImportParams defaultImportParams(Integer titleRows, Integer headerRows) {
        ImportParams params = new ImportParams();
        params.setTitleRows(titleRows);
        params.setHeadRows(headerRows);
        params.setNeedVerify(true);
        return params;
    }
}
