package pe.joedayz.api.util;

import java.text.DecimalFormat;

/**
 */
public class TimeChronometer {
    final String name;
    long startDate;
    long stopDate;

    public TimeChronometer() {
        this("");
    }

    public TimeChronometer(String name) {
        this.name = name;
        start();
    }

    public TimeChronometer start() {
        startDate = System.currentTimeMillis();
        return this;
    }

    public TimeChronometer stop() {
        stopDate = System.currentTimeMillis();
        return this;
    }

    public long elapsedMilis(long endDate) {
        return endDate - startDate;
    }

    public long elapsedMilisUntilNow() {
        return elapsedMilis(System.currentTimeMillis());
    }
    public long elapsedMilisUntilLastStop() {
        return elapsedMilis(stopDate);
    }

    public String untilNowAndRestart(String process) {
        if (process == null) process = "";
        long elapsedInMilis = elapsedMilisUntilNow();
        start();
        return name + " " + process + " took " + toStr(elapsedInMilis);
    }

    public String untilNowAndRestart() {
        long elapsedInMilis = elapsedMilisUntilNow();
        start();
        return name + " " + toStr(elapsedInMilis);
    }

    public String untilNowAndContinue(String process) {
        if (process == null) process = "";
        long elapsedInMilis = elapsedMilisUntilNow();
        return name + " " + process + " took " + toStr(elapsedInMilis);
    }

    public String untilLastSavedStop(String process) {
        if (process == null) process = "";
        long elapsedInMilis = elapsedMilis(stopDate);
        return name + " " + process + " took " + toStr(elapsedInMilis);
    }


    public static String toStr(long elapsedInMilis) {
        if (elapsedInMilis < 1000)
            return elapsedInMilis + "milis";
        DecimalFormat decimalFormat = new DecimalFormat("#.0");
        double segs = elapsedInMilis / 1000.0;
        if (segs < 60) return decimalFormat.format(segs) + "segs";
        double mins = segs / 60.0;
        if (mins < 60) return decimalFormat.format(mins) + "mins";
        double hours = mins / 60.0;
        return decimalFormat.format(hours) + "hours";
    }
}
