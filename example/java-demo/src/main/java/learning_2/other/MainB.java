package learning_2.other;

import java.math.BigDecimal;

public class MainB {
    public static void main(String[] args) {
        float a = 1.0F;
        float b = 0.9F;
        float c = 0.8F;

        float rs1 = a - b;
        float rs2 = b - c;

        System.out.println(rs1 == rs2);

        BigDecimal bd1 = new BigDecimal(1.0);
        BigDecimal bd2 = new BigDecimal(0.9);
        BigDecimal bd3 = new BigDecimal(0.8);

        BigDecimal bdRs1 = bd1.subtract(bd2);
        BigDecimal bdRs2 = bd2.subtract(bd3);

        System.out.println(bdRs1.compareTo(bdRs2) == 0);
    }
}
