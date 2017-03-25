package pe.joedayz.api.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil {
    public static String fmtDt(Date date) {
		if (date == null)
			return "";
        return new SimpleDateFormat("mm/dd/yyyy").format(date);
    }

	public static Date parse(SimpleDateFormat sdf,String date) {
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

    public static Date truncDay(Date date) {
		if (date == null)
			return null;
        Calendar cal = buildCal(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    private static Calendar buildCal(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

	public static String getPeriod(Date date) {

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		String format = sdf.format(date);
		String month = format.substring(0, 2);
		String day = format.substring(3, 5);
		String year = format.substring(6, 10);
		return year + month + day;
	}

	public static Date toDate(String period) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		String year = period.substring(0, 4);
		String month = period.substring(4, 6);
		String day = period.substring(6, 8);
		Date format = sdf.parse(month + "/" + day + "/" + year);
		System.out.println(month + "/" + day + "/" + year);
		return format;
	}


	public static Date getCalculateDaysDate(Date dateCal, int days){

		Calendar calendar = Calendar.getInstance();

		calendar.setTime(dateCal);

		calendar.add(Calendar.DAY_OF_YEAR, days);

		return calendar.getTime();

	}


	public static Date getCleanTimeDate(Date dateCal){

		Calendar calendar = Calendar.getInstance();

		calendar.setTime(dateCal);

		calendar.set(Calendar.HOUR_OF_DAY, 0);

		return calendar.getTime();

	}



}
