public class weather extends time{
    double temperature;
    double humidity;
    double windSpeed;
    boolean precipitation;
    double precipitationAmount;
    int weatherStrength;

    public weather(String month) {
        super(month);
        weatherStrength = setWeatherStrength();
    }

    //Add more switch statements in this switch statement to create more weather scenarios
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

    public void updateWeather(){
        switch(this.getMonth()){
            case 3: findWeatherPossibilityProbability(); setTemperature(temperature+10); setHumidity(); break;
            case 4: findWeatherPossibilityProbability(); setTemperature(temperature+15); setHumidity(); break;
            case 5: findWeatherPossibilityProbability(); setTemperature(temperature+20); setHumidity(); break;
            case 6: findWeatherPossibilityProbability(); setTemperature(temperature+25); setHumidity(); break;
            case 7: findWeatherPossibilityProbability(); setTemperature(temperature+35); setHumidity(); break;
        }
    }

    public int getWeather() {
        System.out.println("The temperature is: " + temperature + " degrees Fahrenheit");
        System.out.println("The humidity is: " + humidity + "%");
        System.out.println("The wind speed is: " + windSpeed + " mph");
        if(precipitation) System.out.println("The precipitation is: " + precipitationAmount + " inches");
        return weatherStrength;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getTemperature() {
        return temperature;
    }

    public double setHumidity() {
        return humidity = Math.random()*50 + 1;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setWindSpeed() {
        windSpeed = Math.random() * 20 + 1; //mph
    }

    public void setHeavyWindSpeed(){
        windSpeed = Math.random() * 20 + 10;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public double getWeatherLength(){
        return Math.random() * 100 + 1;
    }

    public int setWeatherStrength(){
        return weatherStrength = Integer.parseInt(String.valueOf(Math.random() * 10 + 1));
    }

    public double getPrecipitationChance(){
        return Math.random() * 10 + 1;
    }

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
