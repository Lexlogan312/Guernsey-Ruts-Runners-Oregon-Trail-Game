public class weather extends time{
    double temperature;
    double humidity;
    double windSpeed;
    boolean precipitation;
    double precipitationChance;
    double precipitationAmount;

    public weather(String month, String day) {
        super(month,day);
    }

    public void setWeather() {
        switch(this.getMonth()){
            case 3: if(setWeatherStrength() > 5){
                precipitation = true;
                setTemperature(50);
            }
            else{
                setWeatherStrength();
                setWindSpeed();
            }
            case 4:
            case 5:
            case 6:
            case 7:
        }
    }

    public void getWeather() {

    }

    public void setTemperature(int temperature) {
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

    public double setWindSpeed() {
        return windSpeed = Math.random() * 20 + 1;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public double getWeatherLength(){
        return Math.random() * 100 + 1;
    }

    public int setWeatherStrength(){
        return Integer.parseInt(String.valueOf(Math.random() * 10 + 1));
    }
}
