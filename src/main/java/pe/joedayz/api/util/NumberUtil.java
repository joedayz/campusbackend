package pe.joedayz.api.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * Created by awusr on 06/05/2016.
 */
public class NumberUtil {

    public final static int DECIMAL_SCALE = 4;

    // copy from NumberUtil that is in the frontEnd
    private static DecimalFormat moneyFormat = new DecimalFormat("$#,##0.00;$-#,##0.00");
    private static DecimalFormat percentageFormat = new DecimalFormat("#.00%");

    public static BigDecimal divide(Long param1, Long param2) {
        if (param1 == null || param2 == null || param2 == 0) {
            return null;
        }
        BigDecimal valor1 = param1 == null ? BigDecimal.ZERO : BigDecimal.valueOf(param1);
        BigDecimal valor2 = param2 == null ? BigDecimal.ZERO : BigDecimal.valueOf(param2);

        return valor1.divide(valor2, DECIMAL_SCALE, RoundingMode.HALF_UP);

    }

    public static BigDecimal divide(Integer param1, Integer param2) {
        if (param1 == null || param2 == null || param2 == 0) {
            return null;
        }
        BigDecimal valor1 = param1 == null ? BigDecimal.ZERO : BigDecimal.valueOf(param1);
        BigDecimal valor2 = param2 == null ? BigDecimal.ZERO : BigDecimal.valueOf(param2);

        return valor1.divide(valor2, DECIMAL_SCALE, RoundingMode.HALF_UP);

    }

    public static BigDecimal divide(BigDecimal param1, BigDecimal param2) {
        if (param1 == null || param2 == null || BigDecimal.ZERO.compareTo(param2) == 0) {
            return null;
        }
        BigDecimal valor1 = param1 == null ? BigDecimal.ZERO : param1;
        BigDecimal valor2 = param2 == null ? BigDecimal.ZERO : param2;

        return valor1.divide(valor2, DECIMAL_SCALE, RoundingMode.HALF_UP);

    }

    public static BigDecimal multiply(BigDecimal amount1, BigDecimal amount2) {
        if (amount1==null   ) throw new DevelopmentException("amount1 is null");
        if (amount2==null   ) throw new DevelopmentException("amount2 is null");
        return amount1.multiply(amount2);
    }

    public static BigDecimal sum(BigDecimal... amounts) {
        return sumIntern(amounts, false);
    }

    public static BigDecimal sumSafe(BigDecimal... amounts) {
        return sumIntern(amounts, true);
    }

    private static BigDecimal sumIntern(BigDecimal[] amounts, boolean ignoreNulls) {
        BigDecimal total = BigDecimal.ZERO;
        for (int i = 0; i < amounts.length; i++) {
            BigDecimal amount = amounts[i];
            if (ignoreNulls && amount == null) continue;
            total = total.add(amount);
        }
        return total;
    }

    public static BigDecimal subs(BigDecimal amount1, BigDecimal amount2) {
        return amount1.subtract(amount2);
    }

    public static String formatMoney( BigDecimal value ) {
        if(value==null){
            return "";
        }
        moneyFormat.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.US));

        String output = moneyFormat.format(value);
        return output;
    }

    public static String formatPercentage( BigDecimal value ) {
        if(value==null){
            return "";
        }
        percentageFormat.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.US));
        String output = percentageFormat.format(value);
        return output;
    }

    public static boolean isInteger(BigDecimal value ) {
        if(value==null){
            return true;
        }

        return Math.round(value.doubleValue())==value.doubleValue();
    }

    public static BigDecimal nvl(BigDecimal value ) {
        if(value==null){
            return BigDecimal.ZERO;
        }

        return value;
    }

    public static BigDecimal zeroIfNull(BigDecimal decimal) {
        return decimal == null ? BigDecimal.ZERO : decimal;
    }

    public static BigDecimal transformPercentage(BigDecimal value) {

        return (value != null ? value.multiply(new BigDecimal(100)) : null);
    }

    public static BigDecimal percentage(BigDecimal subTotalValue, BigDecimal totalValue) {
        if (totalValue == null || totalValue.equals(BigDecimal.ZERO)) return null;
        if (subTotalValue == null) return null;
        if (totalValue.equals(BigDecimal.ZERO)) return BigDecimal.ZERO;
        return divide(subTotalValue, totalValue).multiply(new BigDecimal(100));
    }

    public static BigDecimal divideRoundUp(long value1, long value2) {
        BigDecimal dec1= new BigDecimal(value1);
        BigDecimal dec2= new BigDecimal(value2);
        BigDecimal result = dec1.divide(dec2);
        return result.setScale(0, BigDecimal.ROUND_UP);
    }
}
