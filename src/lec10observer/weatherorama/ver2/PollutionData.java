package lec10observer.weatherorama.ver2;

public class PollutionData extends Subject {
	private double pm10;
	private double pm2_5;
	
	public double getPm10() {
		return pm10;
	}
	
	public double getPm2_5() {
		return pm2_5;
	}
	
	public void setPm10(double pm10) {
		this.pm10 = pm10;
		notifyObservers();
	}
	
	public void setPm2_5(double pm2_5) {
		this.pm2_5 = pm2_5;
		notifyObservers();
	}
}
