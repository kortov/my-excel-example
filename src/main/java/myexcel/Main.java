package myexcel;

import com.github.liaochong.myexcel.core.ExcelBuilder;
import com.github.liaochong.myexcel.core.FreemarkerExcelBuilder;
import com.github.liaochong.myexcel.utils.FileExportUtil;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        Main main = new Main();
        Map<String, Object> dataMap = main.getDataMap();
        try (ExcelBuilder excelBuilder = new FreemarkerExcelBuilder()){
            Workbook workbook = excelBuilder
                    .template("example.ftl")
                    .build(dataMap);
            FileExportUtil.export(workbook, new File("excel.xlsx"));
        }
    }

    private Map<String, Object> getDataMap() {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("sheetName", "freemarker_excel_example");

        List<String> titles = new ArrayList<>();
        titles.add("Category");
        titles.add("Product Name");
        titles.add("Count");
        titles.add("Title");
        dataMap.put("titles", titles);

        List<String> subtitles = new ArrayList<>();
        subtitles.add("subCategory");
        subtitles.add("subProduct Name");
        subtitles.add("subCount");
        dataMap.put("subtitles", subtitles);

        List<Product> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Product product = new Product();
            if (i % 2 == 0) {
                product.setCategory("Кат");
                product.setName("Телефон");
                product.setCount(100);
            } else {
                product.setCategory("КатКат");
                product.setName("ipad");
                product.setCount(999);
            }
            data.add(product);
        }
        dataMap.put("data", data);
        return dataMap;
    }
}
