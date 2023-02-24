package numbers;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;

public class MoneyCalculationExercise {

//    private static final Locale locale = new Locale("ro", "RO");
//    private static final NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance(locale);
    private static final NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance();
    private static final NumberFormat percentFormatter = NumberFormat.getPercentInstance();

    /**
     * This class create Coumpound Interest Count after this formula:
     * Balance(Y) = P(1+r)^Y + c[ ((1+r)^Y - 1) / r ]
     * @param args
     */

    public static void main(String[] args) throws ParseException {
        DecimalFormat df = new DecimalFormat("$#,###.##;$(#)"); // numbers format # means number, left of ; are positive, right of ; is negative
        DecimalFormat pf = new DecimalFormat("#%");  // take the number and add a procent to it ( multiply by 100)
        BigDecimal balance = MoneyCalculationExercise.calculate("$10,000", "8%", 10, "$1,000");
        System.out.println(df.format(balance.negate())); // .negate is putting a - to a value
        System.out.println(moneyFormatter.format(balance));
        System.out.println(pf.format(.08));
        String myMoney = String.format("$%,(.2f%n", balance);
        System.out.printf("$%,(.2f%n", balance);  // .2 two decimal places
        System.out.println(myMoney);
    }

    private static BigDecimal calculate(String principal, String rate, int period, String contribution) throws ParseException {
        String rateAsPercent = percentFormatter.parse(rate).toString();
        BigDecimal a = BigDecimal.ONE.add(new BigDecimal(rateAsPercent)); // (1 + r)
        BigDecimal b = a.pow(period); // (1+r)^Y
        BigDecimal c = b.subtract(BigDecimal.ONE); // ((1+r)^Y - 1)
        BigDecimal d = c.divide(new BigDecimal(rateAsPercent)); //  ((1+r)^Y - 1) / r
        BigDecimal e = d.multiply(new BigDecimal(moneyFormatter.parse(contribution).toString())); // c[ ((1+r)^Y - 1) / r ]
        BigDecimal f = b.multiply(new BigDecimal(moneyFormatter.parse(principal).toString())); //P(1+r)^Y

        return f.add(e);
    }
}
