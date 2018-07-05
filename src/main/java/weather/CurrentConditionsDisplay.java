package weather;

public class CurrentConditionsDisplay implements Observer, Displayment {

    private float temperature;
    private float humidity;
    private Subject subject;

    public CurrentConditionsDisplay(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature + " F degrees and " + humidity + "% humidity");
    }

    @Override
    public void update() {
        if (this.subject instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) this.subject;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
        }
        this.display();
    }
}
