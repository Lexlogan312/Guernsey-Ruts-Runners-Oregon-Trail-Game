package termProject;

/**
 * Time Class of the Perils Along the Platte Game
 * Manages game time, date tracking, and temporal events.
 * Handles date calculations, time display, and temporal progression through the journey.
 *
 * @author : Alex Randall, Chase McCluskey, Painter Drury, and Domenic Pilla
 * @version : 1.0
 * @date : 03/25/2025
 * @file : time.java
 */
import java.lang.*;
import java.time.*;

public class time {
    String month;
    String day;
    String year;
    String hour;
    String minute;

    /**
     * Constructor that initializes a time object with all time components.
     * 
     * @param month The month value as a string
     * @param day The day value as a string
     * @param year The year value as a string
     * @param hour The hour value as a string
     * @param minute The minute value as a string
     */
    public time(String month, String day, String year, String hour, String minute) {
        this.month = month;
        this.day = day;
        this.year = year;
        this.hour = hour;
        this.minute = minute;
    }

    /**
     * Constructor that initializes a time object with only month specified.
     * 
     * @param month The month value as a string
     */
    public time(String month){
        this.month = month;
    }

    /**
     * Default constructor for time object.
     * Creates an empty time object that can be populated later.
     */
    public time(){

    }
    
    /**
     * Calculates a numeric representation of the current time.
     * 
     * @return A double value representing the time based on year, hour, and minute
     */
    public double returnTime(){
        return Double.parseDouble(year) + Double.parseDouble(hour) + Double.parseDouble(minute);
    }

    /**
     * Sets the day and month values of the time object.
     * 
     * @param day The day value as an integer
     * @param month The month value as an integer
     */
    public void setTime(int day, int month){
        this.day = Integer.toString(day);
        this.month = Integer.toString(month);
    }

    /**
     * Gets the month value as an integer.
     * 
     * @return The month value
     */
    public int getMonth(){
        return Integer.parseInt(month);
    }

    /**
     * Gets the day value as an integer.
     * 
     * @return The day value
     */
    public int getDay(){
        return Integer.parseInt(day);
    }

    /**
     * Gets the hour value as an integer.
     * 
     * @return The hour value
     */
    public int getHour(){
        return Integer.parseInt(hour);
    }

    /**
     * Gets the minute value as an integer.
     * 
     * @return The minute value
     */
    public int getMinute(){
        return Integer.parseInt(minute);
    }

    /**
     * Gets the year value as an integer.
     * 
     * @return The year value
     */
    public int getYear(){
        return Integer.parseInt(year);
    }

    /**
     * Calculates the arrival date based on start month and days traveled.
     * Uses the LocalDate class to handle proper month transitions and leap years.
     * 
     * @param startMonth The month the journey began (1-12)
     * @param daysTraveled The number of days spent traveling
     * @return A string representing the arrival date in "Month Day" format
     */
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
