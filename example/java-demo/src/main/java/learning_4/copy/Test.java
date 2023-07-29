package learning_4.copy;

import java.sql.*;

public class Test {

    // 通过feign调用接口，传递的是对象的引用，如果修改了对象的属性，会影响到原对象
    public static void main(String[] args) throws CloneNotSupportedException {
        Student student = new Student();
        student.setClassNo(1);
        student.setClassName("class1");
        User user = new User();
        user.setName("zhangsan");
        user.setAge(18);
        student.setUser(user);
        Student student1 = (Student) student.clone();
        student1.getUser().setName("lisi");
        System.out.println(student.getUser().getName());
    }

    // 写一个冒泡排序
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // 写一个选择排序
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    // 写一个JDBC连接方法
    public static void jdbc() throws SQLException {
        // 1.加载驱动
        loadDriver();
        // 2.创建连接
        Connection connection = createConnection();
        // 3.创建语句
        Statement statement = connection.createStatement();
        // 4.执行语句
        ResultSet resultSet = executeStatement(statement);
        // 5.处理结果
        handleResult(resultSet);
        // 6.关闭连接
        closeConnection(connection);
    }

    // 1.加载驱动
    public static void loadDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 2.创建连接
    public static Connection createConnection() {

        return null;
    }

    // 3.创建语句
    public static Statement createStatement(Connection connection) throws SQLException {
        return connection.createStatement();
    }

    // 4.执行语句
    public static ResultSet executeStatement(Statement statement) throws SQLException {
        return statement.executeQuery("select * from user");
    }

    // 5.处理结果
    public static void handleResult(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            System.out.println(name + " " + age);
        }
    }

    // 6.关闭连接
    public static void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }
}
