package com.pp.boot.controller.excel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * EasyExcel 解析器接口
 * @author supanpan
 * @create 2024/05/09 16:06
 */
@Controller
public class ExcelParserTestController {
    @Autowired
    private ExcelParser excelParser;

    @GetMapping("/parseAndSaveExcel")
    public String handleFileUpload() {
        String filePath = "D:\\Document\\SDK相关\\SDK新增撞库已安装APP列表0510.xlsx";

        // 调用 ExcelParser 解析并保存 Excel 数据
        excelParser.parseAndSaveExcel(filePath);

        // 解析保存成功后的逻辑
        return "redirect:/success"; // 重定向到成功页面
    }

    @GetMapping("/updateExcel")
    public String handleUpdateFlagFileUpload() {
        String filePath = "D:\\Document\\SDK相关\\SDK新增撞库已安装APP列表0510.xlsx";

        // 调用 ExcelParser 解析并保存 Excel 数据
        excelParser.parseAndUpdateFlagExcel(filePath);

        // 解析保存成功后的逻辑
        return "redirect:/success"; // 重定向到成功页面
    }
}
