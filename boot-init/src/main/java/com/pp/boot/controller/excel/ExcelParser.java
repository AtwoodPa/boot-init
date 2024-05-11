package com.pp.boot.controller.excel;

import com.adwm.admin.domain.SdkInstalledBundle;
import com.adwm.admin.repository.mapper.mssp.SdkInstalledBundleMapper;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 解析 Excel 文件，并保存到数据库
 * @author supan
 */
@Component
public class ExcelParser {

    @Autowired
    private SdkInstalledBundleMapper sdkInstalledBundleMapper;

    public void parseAndUpdateFlagExcel(String filePath) {
        try (InputStream inputStream = new FileInputStream(filePath)) {
            List<ExcelData> dataList = new ArrayList<>();
            Set<String> existingAndroidBundles = new HashSet<>();

            // 获取已存在的 android_bundle 列表
            List<String> existingBundles = sdkInstalledBundleMapper.getAllAndroidBundles();
            // 保留id>134的记录
            existingAndroidBundles.addAll(existingBundles);

            AnalysisEventListener<ExcelData> listener = new AnalysisEventListener<ExcelData>() {
                @Override
                public void invoke(ExcelData data, AnalysisContext context) {
                    if (data != null) {
                        String packageName = data.getPackageName();
                        boolean existsInDatabase = existingAndroidBundles.contains(packageName);
                        int flag = existsInDatabase ? 0 : 1;

                        if (existsInDatabase) {
                            // 数据库中已存在相应 android_bundle，更新 flag = 0
                            sdkInstalledBundleMapper.updateFlagForAndroidBundle(packageName, 0);
                        }
//                        else {
//                            // 数据库中不存在相应 android_bundle，新增数据
//                            dataList.add(data);
//                        }
                    }
                }

                @Override
                public void doAfterAllAnalysed(AnalysisContext context) {
                    // 批量插入新增的数据到数据库
                    batchInsertData(dataList);
                }
            };

            // 使用 EasyExcel 解析 Excel 文件
            EasyExcel.read(inputStream, ExcelData.class, listener).sheet().doRead();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void parseAndSaveExcel(String filePath) {
        try (InputStream inputStream = new FileInputStream(filePath)) {
            List<ExcelData> dataList = new ArrayList<>();
            Set<String> existingAndroidBundles = new HashSet<>();

            // 获取已存在的 android_bundle 列表
            List<String> existingBundles = sdkInstalledBundleMapper.getAllAndroidBundles();
            existingAndroidBundles.addAll(existingBundles);
            AnalysisEventListener<ExcelData> listener = new AnalysisEventListener<ExcelData>() {
                @Override
                public void invoke(ExcelData data, AnalysisContext context) {
                    if (data != null) {
                        // 检查是否已存在相同 android_bundle
                        if (!existingAndroidBundles.contains(data.getPackageName())) {
                            dataList.add(data);
                            existingAndroidBundles.add(data.getPackageName()); // 添加到已存在列表中，避免重复检查
                        }
                    }
                }

                @Override
                public void doAfterAllAnalysed(AnalysisContext context) {
                    // 批量保存有效数据到数据库
                    batchInsertData(dataList);
                    // 更新数据库中已存在但不在 Excel 中的 android_bundle 的 flag = 1
                    updateFlagForNonExcelData(existingAndroidBundles);
                }
            };

            // 使用 EasyExcel 解析 Excel 文件
            EasyExcel.read(inputStream, ExcelData.class, listener).sheet().doRead();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void batchInsertData(List<ExcelData> dataList) {
        List<SdkInstalledBundle> bundleList = new ArrayList<>();
        for (ExcelData data : dataList) {
            SdkInstalledBundle bundle = new SdkInstalledBundle();
            bundle.setAndroidBundle(data.getPackageName());
            bundle.setBundleName(data.getAppName());
            bundleList.add(bundle);
        }

        // 批量插入数据
        if (!bundleList.isEmpty()) {
            sdkInstalledBundleMapper.batchInsert(bundleList);
        }
    }

    private void updateFlagForNonExcelData(Set<String> existingAndroidBundles) {
        // 获取所有数据库中的 android_bundle
        List<String> allBundlesInDatabase = sdkInstalledBundleMapper.getAllAndroidBundles();

        // 输出日志查看获取的数据库 android_bundle 列表
        System.out.println("All Bundles in Database: " + allBundlesInDatabase);
        // 对于数据库中存在但不在 Excel 中的 android_bundle，更新 flag = 1
        for (String bundle : allBundlesInDatabase) {
            if (!existingAndroidBundles.contains(bundle)) {
                sdkInstalledBundleMapper.updateFlagForAndroidBundle(bundle, 1);
                System.out.println("Updated flag for bundle: " + bundle);
            }
        }
    }
}