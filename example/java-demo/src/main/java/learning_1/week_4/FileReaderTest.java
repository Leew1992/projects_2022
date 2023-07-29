package learning_1.week_4;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileReaderTest {

    public static void main(String[] args) {
        writeFileByBuffer();
    }

    private static void writeFileNoBuffer() {

    }

    private static void writeFileByBuffer() {
        Map<String, Object> data = getFromFile("d:/one.txt");
        writeToFile("d:/two.txt", data);
    }

    // 读取本的地映射文件
    public static Map<String, Object> getFromFile(String fileName) {
        File file = new File(fileName);
        FileInputStream fis;
        InputStreamReader isr;
        BufferedReader br;
        try {
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            char[] cbuf = new char[fis.available()];
            int length = br.read(cbuf);

            Map<String, Object> result = new HashMap<>();
            result.put("length", length);
            result.put("content", cbuf);
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    // 写内容到文件
    public static void writeToFile(String fileName, Map<String, Object> data) {
        try {
            File file = new File(fileName);
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file), "utf-8");
            BufferedWriter writer = new BufferedWriter(osw);
            char[] content = (char[]) data.get("content");
            int length = (int) data.get("length");
            writer.write(content, 0, length);
            writer.flush();
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
