package numbers;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

public class BigDecimalStuff {
    public static void main(String[] args) {
        System.out.println(new BigDecimal(".3145683").add(new BigDecimal("5.321")));
        System.out.println(new BigDecimal(".3145683").subtract(new BigDecimal("5.321")));
        MathContext mc = new MathContext(5, RoundingMode.HALF_UP);
        System.out.println(new BigDecimal(".3145683").divide(new BigDecimal("5.321"), mc));  // division with rounding method
        System.out.println(new BigDecimal(".3145683").sqrt(mc));
        System.out.println(new BigDecimal("7").max(new BigDecimal("13")));
        System.out.println(new BigDecimal("7").min(new BigDecimal("13")));
        System.out.println(new BigDecimal("-7").abs());
        System.out.println(new BigDecimal("13").remainder(new BigDecimal("8")));


        BigInteger myInt = new BigInteger("123456789350");
        System.out.println(myInt);
    }
}
