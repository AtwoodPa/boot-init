package com.pp.boot.controller.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * app绑定映射 Excel 数据
 * @author supan
 */
@Data
public class ExcelData {

    @ExcelProperty(index = 0)
    private String packageName; // 对应 Excel 的 package_name 列

    @ExcelProperty(index = 1)
    private String appName; // 对应 Excel 的 app_name 列
}