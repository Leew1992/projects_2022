package learning_3.week_3.jdk8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.*;
import java.util.Date;
import java.util.Set;

/**
 * 新的日期API
 *
 * LocalDate 仅日期
 * LocalTime 仅时间
 * LocalDateTime 日期 + 时间
 *
 * 优点：
 * 1、线程安全
 * java.util.Date 和 SimpleDateFormat 都不是线程安全的，
 * 而LocalDate, LocalTime 和最基本的 String 一样，是不变类型的，不但线程安全，还不能修改。（都是 final 类）
 *
 * 2、日期显示（比如：月份）
 * java.util.Date 月份从0开始，我们一般会+1使用，很不方便。（now.getMonth()）
 * java.time.LocalDate 月份和星期都改成了 enum。 （now.getMonth().get(ChronoField.MONTH_OF_YEAR)）
 *
 * 3、修改API友好（比如：时间推前或推后几天）
 * java.util.date 修改时间，比较不方便。（更倾向于显示，修改日期通过 Calendar 来完成）
 * java.time.LocalDate 修改时间更加方便。（now.plusDays(3)）
 */
public class LocalDateTimeTest {

    /**
     * java.time – 包含值对象的基础包（时间值对象）
     * java.time.chrono – 提供对不同的日历系统的访问（日期单维度处理）
     * java.time.format – 格式化和解析时间和日期（格式化日期）
     * java.time.temporal – 包括底层框架和扩展特性（修改日期）
     * java.time.zone – 包含时区支持的类（分时区显示）
     *
     * 链接：
     * https://www.jianshu.com/p/19bd58b30660
     *
     * temporal:
     * 抽象的时间概念，也是一个框架级接口（用来读写时间）
     */
    public static void main(String[] args) {
        testInstant();
    }

    private static void testLocalDateTime() {
        // 获取当前日期 + 时间
        LocalDateTime now = LocalDateTime.now();
        // 获取年
        System.out.println(now.getMonth().get(ChronoField.MONTH_OF_YEAR));

        // 自定义日期 + 时间
        LocalDateTime dateTime = LocalDateTime.of(2022, 9, 26, 22, 00, 2);
        System.out.println(dateTime);

        // 加时间
        LocalDateTime afterOneYear = now.plusYears(1);
        System.out.println(afterOneYear);

        // 减时间
        LocalDateTime returnNow = afterOneYear.minusYears(1);
        System.out.println(returnNow);

        // 格式化
        // （自定义）
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = now.format(dateTimeFormatter);
        String format1 = dateTimeFormatter.format(now);
        System.out.println(format1);

        // （使用API提供的格式）
        DateTimeFormatter isoDateTime = DateTimeFormatter.ISO_DATE;
        System.out.println(now.format(isoDateTime));

        // 选择时区
        // （初始化）
        LocalDateTime now1 = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(now1);

        // （修改时区）
        ZonedDateTime zonedDateTime = now.atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println(zonedDateTime.toLocalDateTime());

        // （遍历时区）
        Set<String> set = ZoneId.getAvailableZoneIds();
        long count = set.stream().count();
        System.out.println("zone count: " + count);

        // 默认UTC时间，+8转成北京时间
        long l = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        System.out.println(l);
    }


    private static void testInstant() {
        // 获取当前时间（UTC+8）
        // UTC 世界统一时间
        Instant now = Instant.now();
        System.out.println(now);

        // 获取 +8 时区的时间
        System.out.println(LocalDateTime.now().toInstant(ZoneOffset.of("+8")));

        // 前进 8 小时
        System.out.println(Instant.now().atOffset(ZoneOffset.ofHours(8)).toInstant());

        // 取两个时间之间的差值
        Duration.between(Instant.now(), Instant.now()).getSeconds();
    }

    /**
     * API使用：
     *
     * 初始化：
     * of(2018,8,8) 设置具体日期
     * parse("2018-08-08") 解析成日期对象
     *
     *
     * 修改时间：
     * plusDays(1) 增加 n 天数
     * minusDays(1) 减少 n 天数
     * withDayOfYear(1) 获取一年中的第 n 天
     * with(t -> {}) 处理时间
     */
    private static void testLocalDate() {
        /*LocalDate theDate = LocalDate.of(2018, 12, 12);
        // 按年/月/日 的时间段
        Period between = Period.between(theDate, LocalDate.now());
        System.out.println(between.getMonths());
        // 计算间隔天数
        long between1 = ChronoUnit.DAYS.between(theDate, LocalDate.now());
        System.out.println(between1);*/

        LocalDate now = LocalDate.now();
        System.out.println(now);

        // 获取一年中第一天 的 同一个时间
        LocalDate firstDayOfYear = now.withDayOfYear(1);
        System.out.println(firstDayOfYear);

        // 获取一个月中的第一天
        LocalDate firstDayOfMonth = now.withDayOfMonth(1);
        // 当月第一天
        LocalDate with1 = now.with(TemporalAdjusters.firstDayOfMonth());
        // 当月最后一天
        LocalDate with2 = now.with(TemporalAdjusters.lastDayOfMonth());
        // 当月的第一个周三
        LocalDate with3 = LocalDate.parse("2018-10-01")
                .with(TemporalAdjusters.firstInMonth(DayOfWeek.WEDNESDAY));
        System.out.println(firstDayOfMonth);

        // 获取下一个工作日
        LocalDate with = now.with(t -> {
            LocalDateTime nextWorkDay = (LocalDateTime) t;
            DayOfWeek dayOfWeek = nextWorkDay.getDayOfWeek();
            // 星期五、延 3 天
            if (DayOfWeek.FRIDAY.equals(dayOfWeek)) {
                return nextWorkDay.plusDays(3);
            }
            // 星期六、延 2 天
            if (DayOfWeek.SATURDAY.equals(dayOfWeek)) {
                return nextWorkDay.plusDays(2);
            }
            return nextWorkDay.plusDays(1);
        });
        System.out.println(with);
    }

    private static void testLocalTime() {
        // 16:25:46.448(纳秒值)
        LocalTime now = LocalTime.now();

        // 16:28:48 不带纳秒值
        LocalTime localTime = LocalTime.now().withNano(0);
        System.out.println(localTime);

        // 写死小时，固定 3
        LocalTime localTime1 = LocalTime.now().withHour(3);
        System.out.println(localTime1);
    }
}
