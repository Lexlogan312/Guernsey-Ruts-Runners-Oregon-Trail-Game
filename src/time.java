import java.util.Date;
import java.time.*;
import java.lang.*;

public abstract class time {
    String month;
    String day;
    String year;
    String hour;
    String minute;

    public time(String month, String day, String year, String hour, String minute) {
        this.month = month;
        this.day = day;
        this.year = year;
        this.hour = hour;
        this.minute = minute;
    }

    public time(String month, String day){
        this.month = month;
        this.day = day;
    }

    public double returnTime(){
        return Double.parseDouble(year) + Double.parseDouble(hour) + Double.parseDouble(minute);
    }

    public void setTime(int day, int month){
        this.day = Integer.toString(day);
        this.month = Integer.toString(month);
    }

    public int getMonth(){
        return Integer.parseInt(month);
    }

    public int getDay(){
        return Integer.parseInt(day);
    }

    public int getHour(){
        return Integer.parseInt(hour);
    }

    public int getMinute(){
        return Integer.parseInt(minute);
    }

    public int getYear(){
        return Integer.parseInt(year);
    }
}
