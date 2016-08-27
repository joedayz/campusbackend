package pe.joedayz.api.util;

import java.math.BigDecimal;

import pe.joedayz.api.rest.GenericRestException;

public class BigDecimalUtils {

    public static String bigDecimalValidFormat(BigDecimal bigDecimal, int decimals, int numbers,String format){

        String error = null;

        if(isNegative(bigDecimal)){
            error ="Not Negative.";
        }

        if(integerDigitsTotal(bigDecimal)>numbers){
            error ="Max digit "+numbers+".";
        }

        if(integerDigitsNumber(bigDecimal)>numbers-decimals){
            if(format!=null) {
                error = format;
            }else{
                error = "Max digits 9999999999.99 .";
            }
        }

        if(getNumberOfDecimalPlace(bigDecimal)>decimals){
            error ="Max decimals "+decimals+".";
        }

        return  error;
    }


    public static String bigDecimalValid(BigDecimal bigDecimal, int decimals, int numbers){

        String error = null;

        if(isNegative(bigDecimal)){
            error ="Not Negative";
        }

        if(integerDigitsTotal(bigDecimal)>numbers){
            error ="Max digit "+numbers;
        }

        if(integerDigitsNumber(bigDecimal)>numbers-decimals){
            error ="Max digits 9999999999.99 " ;
        }

        if(getNumberOfDecimalPlace(bigDecimal)>decimals){
            error ="Max decimals "+decimals;
        }

        return  error;
    }

    static boolean isNegative(BigDecimal b)
    {
        return   b.signum() == -1;
    }

    static int integerDigitsTotal(BigDecimal n) {
        return n.signum() == 0 ? 1 : n.precision();
    }

    static int integerDigitsNumber(BigDecimal n) {
        return n.signum() == 0 ? 1 : n.precision() - n.scale();
    }


    static int getNumberOfDecimalPlace(BigDecimal bigDecimal) {
        String string = bigDecimal.stripTrailingZeros().toPlainString();
        int index = string.indexOf(".");
        return index < 0 ? 0 : string.length() - index - 1;
    }


    public static void validateBigDecimal(BigDecimal bigDecimal, int decimals, int numbers, String format) {

        if(bigDecimal!=null){sendMgsFormatBigDecimal(BigDecimalUtils.bigDecimalValidFormat(bigDecimal,decimals,numbers,format));}

    }

    public static String validateBigDecimalMsgError(BigDecimal bigDecimal, int decimals, int numbers,String format) {

        if(bigDecimal!=null){
            String msg=BigDecimalUtils.bigDecimalValidFormat(bigDecimal,decimals,numbers,format);
            return  msg==null?"":msg;
        }
        return "";
    }

    private static void sendMgsFormatBigDecimal(String msg){
        if(msg!=null) {
            throw new GenericRestException("ERROR", msg);
        }
    }


}



