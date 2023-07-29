package learning_1.week_20;

import java.math.BigDecimal;

public class NumberTest {
    public static void main(String[] args) {
        System.out.println(get(new Double(2345.6)));
        System.out.println(get(new Double(34567.2)));
        System.out.println(String.format("1341_%s", "aa", "bb"));
    }

    public  static String get(Double heat) {
        if (heat != null){
            BigDecimal heatValue = new BigDecimal(heat);
            if (heatValue.scale() >= -20 && heatValue.scale()<=20){
                if (heatValue.compareTo(new BigDecimal(9999)) >0){
                    String hotValue = heatValue.divide(new BigDecimal(10000)).setScale(1, BigDecimal.ROUND_HALF_UP)+"w";
                    return hotValue.replace(".0","");
                }else {
                    return String.valueOf(heatValue.setScale(0,BigDecimal.ROUND_HALF_UP));
                }
            }
        }
        return "";
    }
}
