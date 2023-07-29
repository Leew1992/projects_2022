package learning_1.week_4;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;

public class GeneralTest {
    public static void main(String[] args) {
        /*Integer i = 4;
        Integer j = 4;

        System.out.println(i == j); // java将 -128~127 初始化的常量池中，两个对象指向相同的常量
        System.out.println(i.toString());
        System.out.println(j.getClass());

        Integer a = 128;
        Integer b = 128;

        System.out.println(a == b);
        System.out.println(a.getClass());
        System.out.println(b.getClass());*/

        // System.out.println(false & false);

        /*Product a = new Product();
        Product b = new Product();

        System.out.println(a);
        System.out.println(b.getId());

        change(b);

        System.out.println(b.getId());*/

        String a = "a";
        String b = "b";
        String s1 = "ab"; // 常量池
        String s2 = a + b;
        System.out.println(s1 == s2);
        System.out.println(s1 == s2.intern()); // s2.intern() 取常量池中的引用

        Calendar cal = Calendar.getInstance();
        System.out.println(cal.get(Calendar.YEAR));
        System.out.println(cal.get(Calendar.MONTH));
        System.out.println(cal.get(Calendar.DATE));

        System.out.println(cal.getTimeInMillis());
        System.out.println(System.currentTimeMillis());
        System.out.println(Clock.systemDefaultZone().millis());

        // 获取某月的最的一天
        cal.add(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        String first = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
        System.out.println(first);

        // 获取当月的最后一天
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        String last = new SimpleDateFormat("yyyy-MM-dd").format(ca.getTime());
        System.out.println(last);

        // java8
        LocalDate today = LocalDate.now();

        // 本月的第一天
        LocalDate firstDay = LocalDate.of(today.getYear(), today.getMonth(), 1);

        // 本月的最后一天
        LocalDate lastDay = today.with(TemporalAdjusters.lastDayOfMonth());

        System.out.println("本月的第一天" + firstDay);
        System.out.println("本月的最后一天" + lastDay);

        // 打印昨天当前时刻
        LocalDateTime ldt = LocalDateTime.now();
        LocalDateTime yes = ldt.minusDays(1);
        System.out.println(yes);

        // Instant的使用
        // current timestamp
        Instant timestamp = Instant.now();
        System.out.println("current timestamp: " + timestamp);

        // Instant from timestamp
        Instant specificTime = Instant.ofEpochMilli(timestamp.toEpochMilli());
        System.out.println(specificTime);


    }

    public static void change(Product p) {
        p.setId("p");
    }
}

/**
 * 改变引用本身
 * 改成引用对象
 */