package learning_1.week_23;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Test {

    public static void main(String[] args) {
        /*Calendar currentTime = Calendar.getInstance();

        Date date = strToDateLong("2022-07-08 00:00:00");
        XMLGregorianCalendar calendar = convertToXMLGregorianCalendar(date);
        Calendar instance = Calendar.getInstance();
        instance.setTime(calendar.toGregorianCalendar().getTime());
        System.out.println(currentTime.compareTo(instance));*/
        test();
    }

    private static void test() {
        Calendar currentTime = Calendar.getInstance();

        Date date1 = strToDateLong("2022-07-08 00:00:00");
        XMLGregorianCalendar xmlDate1 = convertToXMLGregorianCalendar(date1);

        Calendar startDate = Calendar.getInstance();
        startDate.setTime(xmlDate1.toGregorianCalendar().getTime());

        Date date2 = strToDateLong("2022-07-15 00:00:00");
        XMLGregorianCalendar xmlDate2 = convertToXMLGregorianCalendar(date1);

        Calendar endDate = Calendar.getInstance();
        startDate.setTime(xmlDate2.toGregorianCalendar().getTime());

        if (currentTime.compareTo(startDate) < 0) {
            System.out.println(0);
        } else if (currentTime.compareTo(startDate) >= 0 && currentTime.compareTo(endDate) < 0) {
            System.out.println(1);
        } else if (currentTime.compareTo(endDate) >= 0) {
            System.out.println(3);
        }
    }

    //字符串时间格式转Date格式
    private static Date strToDateLong(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }


    //Date时间格式转XMLGregorianCalendar格式
    private static XMLGregorianCalendar convertToXMLGregorianCalendar(Date date){
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        XMLGregorianCalendar gc = null;
        try {
            gc = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gc;
    }


    //UTC日期转换为ISO日期
    public static Date DateToXML(XMLGregorianCalendar gc){
        GregorianCalendar ca = gc.toGregorianCalendar();
        return ca.getTime();
    }
}
