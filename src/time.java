import java.lang.*;
import java.time.*;

public class time {
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

    public time(String month){
        this.month = month;
    }

    public time(){

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

    public String calculateArrivalDate(int startMonth, int daysTraveled) {
        // Assume travel starts at the beginning of the specified month in a standard year
        LocalDate startDate = LocalDate.of(1848, startMonth, 1); // Using 1848 as a placeholder year
        LocalDate arrivalDate = startDate.plusDays(daysTraveled);

        // Extract the month and day of arrival
        Month arrivalMonth = arrivalDate.getMonth();
        int arrivalDay = arrivalDate.getDayOfMonth();

        return arrivalMonth + " " + arrivalDay;
    }
}
