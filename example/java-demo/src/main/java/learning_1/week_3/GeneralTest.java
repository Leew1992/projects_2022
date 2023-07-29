package learning_1.week_3;

import java.sql.*;
import java.util.Hashtable;
import java.util.*;

public class GeneralTest {
    public static void main(String[] args) {
        // hashtable();
        // hashmap();
        // printByte();
        // testJdbc();
        bubbleSort();
    }

    private static void hashtable() {
        Hashtable<String, String> table = new Hashtable<>();
        table.put(null, null);
        table.put(null, "");
        table.put("", null);
        System.out.println(table.size());
    }

    private static void hashmap() {
        HashMap<String, String> map = new HashMap<>();
        map.put(null, null);
        map.put(null, "");
        map.put("", null);
        System.out.println(map.size());
    }

    private static void printByte() {
        String word = "小明";
        System.out.println(Arrays.toString(word.getBytes())); // 字节流（ASCII码值）
        System.out.println(Arrays.toString(word.toCharArray())); // 字节流（单个字）
    }

    // 写一个本地的mysql连接
    private static void testJdbc() {
        Connection conn = null;
        Statement stat = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gsmaterial", "root", "123456");
            stat = conn.createStatement();
            String sql = "select * from mat_label limit 10";
            ResultSet rs = stat.executeQuery(sql);
            /**
             * PreparedStatement pstat = conn.prepareStatement("select * from mat_label where label_id = ?");
             * pstat.setLong(1, 101001);
             * ResultSet rs = pstat.executeQuery();
             */
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 冒泡排序
    private static void bubbleSort() {
        int[] arrays = {4, 1, 2, 3, 5};
        for (int i = 0; i < arrays.length - 1; i ++) {
            for (int j = i + 1; j < arrays.length; j ++) {
                if (arrays[i] < arrays[j]) {
                    int temp = arrays[i];
                    arrays[i] = arrays[j];
                    arrays[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arrays));
    }



}
