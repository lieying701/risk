package com.chinalife.risksurvey.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.usermodel.XSSFDataValidationConstraint;
import org.apache.poi.xssf.usermodel.XSSFDataValidationHelper;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 包名称： com.chinalife.risksurvey.utils <br/>
 * 类名称：POIExcelUtils<br/>
 * 类描述：Excel多级下拉框操作工具类<br/>
 * 
 * @version <br/>
 */
public abstract class POIExcelUtils {

    /**
     * 隐藏sheet页名称
     */
    private static String excelHideSheetName = "";

    /**
     * 创建多级加拉联动
     * 
     * @param wb
     *            XSSFWorkbook
     * @param firstList
     *            父级的下拉数据
     * @param data
     *            子级的对应下拉数据
     * @param fatherName
     *            父级的字段名称
     * @param levlCont
     *            多少级下拉
     */
    public static void createLevelLinkage(XSSFWorkbook wb, List<String> firstList, Map<String, List<String>> data,
            String fatherName, int levlCont) {
        excelHideSheetName = fatherName + "下拉数据";
        // 创建隐藏的Sheet页
        creatExcelHidePage(wb, firstList, data, fatherName);

        // 数据验证
        setDataValidation(wb, fatherName, levlCont);

    }

    /**
     * 设置模板文件的横向表头单元格的样式
     * 
     * @param workbook
     *            Workbook
     * @param firstList
     *            List<String>
     * @param data
     *            Map<String, List<String>>
     * @param fatherName
     *            String
     */
    public static void creatExcelHidePage(Workbook workbook, List<String> firstList, Map<String, List<String>> data,
            String fatherName) {
        Sheet hideInfoSheet = workbook.createSheet(excelHideSheetName);// 隐藏一些信息
        int i = 0;
        // 第一行设置港口代码(父级)信息
        Row firstRow = hideInfoSheet.createRow(i++);
        String[] firstArray = firstList.toArray(new String[] {});
        creatRow(firstRow, fatherName, firstArray);
        // 设置港口代码(父级)信息的名称管理
        creatExcelNameList(workbook, hideInfoSheet, fatherName, i, firstArray.length);
        // 以下行设置港口中文名称(子级)列表
        if (null != data && !data.isEmpty()) {
            List<String> fatherList = new ArrayList<>(data.keySet());
            for (String key : fatherList) {
                Row row = hideInfoSheet.createRow(i++);
                String[] son = data.get(key).toArray(new String[] {});
                creatRow(row, key, son);
                // 名称管理
                creatExcelNameList(workbook, hideInfoSheet, key, i, son.length);
            }
        }
        // 设置隐藏页标志
        workbook.setSheetHidden(workbook.getSheetIndex(hideInfoSheet.getSheetName()), true);
    }

    /**
     * 添加名称管理器
     * 
     * @param workbook
     *            Workbook
     * @param hideSheet
     *            Sheet
     * @param nameCode
     *            nameCode
     * @param order
     *            order
     * @param size
     *            size
     */
    private static void creatExcelNameList(Workbook workbook, Sheet hideSheet, String nameCode, int order, int size) {
        String range = creatExcelNameList(order, size);
        Name name = workbook.createName();
        // key不可重复
        name.setNameName(nameCode);
        String formula = hideSheet.getSheetName() + "!" + range;
        name.setRefersToFormula(formula);
    }

    /**
     * 名称数据行列计算表达式
     * 
     * @param order
     *            order
     * @param size
     *            size
     * @return String
     */
    private static String creatExcelNameList(int order, int size) {
        char start = 'B';
        if (size <= 25) {
            char end = (char) (start + size - 1);
            return "$" + start + "$" + order + ":$" + end + "$" + order;
        } else {
            char endPrefix = 'A';
            char endSuffix = 'A';
            // 26-51之间，包括边界（仅两次字母表计算）
            if ((size - 25) / 26 == 0 || size == 51) {
                // 边界值
                if ((size - 25) % 26 == 0) {
                    endSuffix = (char) ('A' + 25);
                } else {
                    endSuffix = (char) ('A' + (size - 25) % 26 - 1);
                }
            } else {
                // 51以上
                if ((size - 25) % 26 == 0) {
                    endSuffix = (char) ('A' + 25);
                    endPrefix = (char) (endPrefix + (size - 25) / 26 - 1);
                } else {
                    endSuffix = (char) ('A' + (size - 25) % 26 - 1);
                    endPrefix = (char) (endPrefix + (size - 25) / 26);
                }
            }
            return "$" + start + "$" + order + ":$" + endPrefix + endSuffix + "$" + order;
        }
    }

    /**
     * 创建一列数据
     * 
     * @param currentRow
     *            currentRow
     * @param name
     *            name
     * @param textList
     *            textList
     */
    private static void creatRow(Row currentRow, String name, String[] textList) {
        if (textList != null && textList.length > 0) {
            int i = 0;
            Cell cell = currentRow.createCell(i++);
            cell.setCellValue(name);
            for (String cellValue : textList) {
                Cell userNameLableCell = currentRow.createCell(i++);
                userNameLableCell.setCellValue(cellValue);
            }
        }
    }

    /**
     * 添加数据验证选项
     * 
     * @param wb
     *            XSSFWorkbook
     * @param fatherName
     *            fatherName
     * @param levlCont
     *            levlCont
     */
    public static void setDataValidation(XSSFWorkbook wb, String fatherName, int levlCont) {
        int sheetIndex = wb.getNumberOfSheets();
        if (sheetIndex > 0) {
            for (int i = 0; i < sheetIndex; i++) {
                XSSFSheet sheet = wb.getSheetAt(i);
                if (!excelHideSheetName.equals(sheet.getSheetName())) {
                    DataValidation data_validation_list = null;
                    Row row = sheet.getRow(0);
                    int cellIndex = 0;// 父级字段所在位置
                    for (int j = 0; j < row.getLastCellNum(); j++) {
                        Cell cell = row.getCell(j);
                        String cellValue = cell.getStringCellValue();
                        if (fatherName.equals(cellValue)) {
                            cellIndex = j;
                        }
                    }
                    // 省份选项添加验证数据
                    for (int a = 2; a < 1000; a++) {
                        // 添加父级数据
                        data_validation_list = getDataValidationByFormula(sheet, fatherName, a, cellIndex + 1);
                        sheet.addValidationData(data_validation_list);

                        for (int k = 0; k < levlCont - 1; k++) {
                            // 添加子级数据
                            char start = (char) ('A' + cellIndex + k);
                            data_validation_list = getDataValidationByFormula(sheet,
                                    "INDIRECT($" + start + "$" + a + ")", a, cellIndex + k + 2);
                            sheet.addValidationData(data_validation_list);
                        }
                    }
                }
            }
        }
    }

    /**
     * 使用已定义的数据源方式设置一个数据验证
     * 
     * @param sheet
     *            XSSFSheet
     * @param formulaString
     *            formulaString
     * @param naturalRowIndex
     *            naturalRowIndex
     * @param naturalColumnIndex
     *            naturalColumnIndex
     * @return DataValidation
     */
    private static DataValidation getDataValidationByFormula(XSSFSheet sheet, String formulaString, int naturalRowIndex,
            int naturalColumnIndex) {
        // 加载下拉列表内容
        XSSFDataValidationHelper dvHelper = new XSSFDataValidationHelper(sheet);
        XSSFDataValidationConstraint constraint = (XSSFDataValidationConstraint) dvHelper
                .createFormulaListConstraint(formulaString);
        // 设置数据有效性加载在哪个单元格上。
        // 四个参数分别是：起始行、终止行、起始列、终止列
        int firstRow = naturalRowIndex - 1;
        int lastRow = naturalRowIndex - 1;
        int firstCol = naturalColumnIndex - 1;
        int lastCol = naturalColumnIndex - 1;
        CellRangeAddressList regions = new CellRangeAddressList(firstRow, lastRow, firstCol, lastCol);
        // 数据有效性对象
        DataValidation data_validation_list = dvHelper.createValidation(constraint, regions);
        // 设置输入错误提示信息
        data_validation_list.createErrorBox("选择错误提示", "你输入的值未在备选列表中，请下拉选择合适的值！");
        return data_validation_list;
    }
}
