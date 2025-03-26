/**
 * Weather Class of the Perils Along the Platte Game
 * Manages weather conditions and their impact on gameplay.
 * Handles temperature, precipitation, wind, and seasonal changes.
 *
 * @author : Alex Randall, Chase McCluskey, Painter Drury, and Domenic Pilla
 * @version : 1.0
 * @date : 03/25/2025
 * @file : weather.java
 */
public class weather extends time{
    double temperature;
    double humidity;
    double windSpeed;
    boolean precipitation;
    double precipitationAmount;
    int weatherStrength;

    /**
     * Constructor for creating a weather object with a specified month.
     * Initializes weather conditions based on the month.
     * 
     * @param month The starting month as a string
     */
    public weather(String month) {
        super(month);
        weatherStrength = setWeatherStrength();
    }

    /**
     * Updates weather conditions based on the day count and month.
     * Changes conditions when moving to a new month.
     * 
     * @param days The number of days elapsed
     * @param month The current month
     */
    public void updateWeather(int days, String month) {
        int monthNumber = Integer.parseInt(month);
        if(days % 31 == 0) monthNumber++;
        switch(monthNumber){
            case 3: findWeatherPossibilityProbability(); setTemperature(temperature+10); setHumidity(); break;
            case 4: findWeatherPossibilityProbability(); setTemperature(temperature+15); setHumidity(); break;
            case 5: findWeatherPossibilityProbability(); setTemperature(temperature+20); setHumidity(); break;
            case 6: findWeatherPossibilityProbability(); setTemperature(temperature+25); setHumidity(); break;
            case 7: findWeatherPossibilityProbability(); setTemperature(temperature+35); setHumidity(); break;
        }
        setTime(days, monthNumber);
    }

    /**
     * Updates weather conditions based on the current month.
     * Simpler version that doesn't track day count.
     */
    public void updateWeather(){
        switch(this.getMonth()){
            case 3: findWeatherPossibilityProbability(); setTemperature(temperature+10); setHumidity(); break;
            case 4: findWeatherPossibilityProbability(); setTemperature(temperature+15); setHumidity(); break;
            case 5: findWeatherPossibilityProbability(); setTemperature(temperature+20); setHumidity(); break;
            case 6: findWeatherPossibilityProbability(); setTemperature(temperature+25); setHumidity(); break;
            case 7: findWeatherPossibilityProbability(); setTemperature(temperature+35); setHumidity(); break;
        }
    }

    /**
     * Displays current weather conditions and returns the weather strength.
     * Outputs temperature, humidity, wind speed, and precipitation if present.
     * 
     * @return The current weather strength value
     */
    public int getWeather() {
        System.out.println("The temperature is: " + temperature + " degrees Fahrenheit");
        System.out.println("The humidity is: " + humidity + "%");
        System.out.println("The wind speed is: " + windSpeed + " mph");
        if(precipitation) System.out.println("The precipitation is: " + precipitationAmount + " inches");
        return weatherStrength;
    }

    /**
     * Sets the temperature value.
     * 
     * @param temperature The temperature in degrees Fahrenheit
     */
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    /**
     * Gets the current temperature.
     * 
     * @return The temperature in degrees Fahrenheit
     */
    public double getTemperature() {
        return temperature;
    }

    /**
     * Sets a random humidity value between 1 and 50.
     * 
     * @return The newly set humidity percentage
     */
    public double setHumidity() {
        return humidity = Math.random()*50 + 1;
    }

    /**
     * Gets the current humidity.
     * 
     * @return The humidity percentage
     */
    public double getHumidity() {
        return humidity;
    }

    /**
     * Sets a random normal wind speed between 1 and 20 mph.
     */
    public void setWindSpeed() {
        windSpeed = Math.random() * 20 + 1; //mph
    }

    /**
     * Sets a random heavy wind speed between 10 and 30 mph.
     */
    public void setHeavyWindSpeed(){
        windSpeed = Math.random() * 20 + 10;
    }

    /**
     * Gets the current wind speed.
     * 
     * @return The wind speed in mph
     */
    public double getWindSpeed() {
        return windSpeed;
    }

    /**
     * Calculates a random weather event duration.
     * 
     * @return The weather duration value
     */
    public double getWeatherLength(){
        return Math.random() * 100 + 1;
    }

    /**
     * Sets a random weather strength value between 1 and 10.
     * Higher values indicate more severe weather.
     * 
     * @return The newly set weather strength
     */
    public int setWeatherStrength(){
        return weatherStrength = Integer.parseInt(String.valueOf(Math.random() * 10 + 1));
    }

    /**
     * Calculates the chance of precipitation occurring.
     * 
     * @return A value between 1 and 10 representing precipitation chance
     */
    public double getPrecipitationChance(){
        return Math.random() * 10 + 1;
    }

    /**
     * Calculates the amount of precipitation based on chance.
     * Higher chance values result in more precipitation.
     * 
     * @return The amount of precipitation in inches
     */
    public double getPrecipitationAmount(){
        switch((int)getPrecipitationChance()){
            case 0: return Math.random() + 1;
            case 1: return Math.random() + 3;
            case 2:return Math.random() + 5;
            case 3:return Math.random() * 3 + 1;
            case 4:return Math.random() * 3 + 3;
            case 5:return Math.random() * 3 + 5;
            case 6:return Math.random() * 3 + 7;
            case 7:return Math.random() * 5 + 1;
            case 8:return Math.random() * 5 + 3;
            case 9:return Math.random() * 5 + 5;
            case 10:return Math.random() * 5 + 7;
            default: return 0;
        }
    }

    /**
     * Determines the weather conditions based on random chance and weather strength.
     * Sets appropriate temperature, wind, and precipitation values.
     */
    public void findWeatherPossibilityProbability(){
        int weatherPossibility = Integer.parseInt(String.valueOf(Math.random()*10+1));
        switch(weatherPossibility){
            case 1:
                if(weatherStrength > 10){
                    setHeavyWindSpeed();
                    getPrecipitationAmount();
                    precipitation = true;
                    setTemperature(30);
                }
                else{
                    setWindSpeed();
                    setTemperature(50);
                    precipitation = false;
                }
                break;
            case 2:
                if(weatherStrength > 9){
                    setHeavyWindSpeed();
                    getPrecipitationAmount();
                    precipitation = true;
                    setTemperature(30);
                }
                else{
                    setWindSpeed();
                    setTemperature(50);
                    precipitation = false;
                }
                break;
            case 3:
                if(weatherStrength > 8){
                    setHeavyWindSpeed();
                    getPrecipitationAmount();
                    precipitation = true;
                    setTemperature(30);
                }
                else{
                    setWindSpeed();
                    setTemperature(50);
                    precipitation = false;
                }
                break;
            case 4:
                if(weatherStrength > 7){
                    setHeavyWindSpeed();
                    getPrecipitationAmount();
                    precipitation = true;
                    setTemperature(30);
                }
                else{
                    setWindSpeed();
                    setTemperature(50);
                    precipitation = false;
                }
                break;
            case 5:
                if(weatherStrength > 6){
                    setHeavyWindSpeed();
                    getPrecipitationAmount();
                    precipitation = true;
                    setTemperature(30);
                }
                else{
                    setWindSpeed();
                    setTemperature(50);
                    precipitation = false;
                }
                break;
            case 6:
                if(weatherStrength > 5){
                    setHeavyWindSpeed();
                    getPrecipitationAmount();
                    precipitation = true;
                    setTemperature(30);
                }
                else{
                    setWindSpeed();
                    setTemperature(50);
                    precipitation = false;
                }
                break;
            case 7:
                if(weatherStrength > 4){
                    setHeavyWindSpeed();
                    getPrecipitationAmount();
                    precipitation = true;
                    setTemperature(30);
                }
                else{
                    setWindSpeed();
                    setTemperature(50);
                    precipitation = false;
                }
                break;
            case 8:
                if(weatherStrength > 3){
                    setHeavyWindSpeed();
                    getPrecipitationAmount();
                    precipitation = true;
                    setTemperature(30);
                }
                else{
                    setWindSpeed();
                    setTemperature(50);
                    precipitation = false;
                }
                break;
            case 9:
                if(weatherStrength > 2){
                    setHeavyWindSpeed();
                    getPrecipitationAmount();
                    precipitation = true;
                    setTemperature(30);
                }
                else{
                    setWindSpeed();
                    setTemperature(50);
                    precipitation = false;
                }
                break;
            case 10:
                if(weatherStrength > 1){
                    setHeavyWindSpeed();
                    getPrecipitationAmount();
                    precipitation = true;
                    setTemperature(30);
                }
                else{
                    setWindSpeed();
                    setTemperature(50);
                    precipitation = false;
                }
                break;
        }
    }
}
