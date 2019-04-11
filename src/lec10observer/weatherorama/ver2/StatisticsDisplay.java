package lec10observer.weatherorama.ver2;

import javax.swing.*;
import java.awt.*;

public class StatisticsDisplay implements Observer {

    private double prevTemp;
    private double prevWaveH;
    private double prevPM10;

    private JFrame frame;
    private JTextArea weatherArea, oceanArea, pollutionArea;

    public StatisticsDisplay() {

        frame = new JFrame();
        frame.setSize(200, 400);
        frame.setTitle("Average Condition");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        weatherArea = new JTextArea(200, 200);
        weatherArea.setBackground(Color.ORANGE);
        weatherArea.setText("Current Weather:\n\n");

        oceanArea = new JTextArea(200, 200);
        oceanArea.setBackground(Color.GREEN);
        oceanArea.setText("Current Ocean:\n\n");
        
        pollutionArea = new JTextArea(200, 200);
        pollutionArea.setBackground(Color.DARK_GRAY);
        pollutionArea.setText("Current Pollution:\n\n");

        frame.setLayout(new GridLayout(3, 1));
        frame.add(weatherArea);
        frame.add(oceanArea);
        frame.add(pollutionArea);
    }

    @Override
    public void update(Subject data) {
        if (data instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) data;

            if (prevTemp == 0)
                prevTemp = weatherData.getTemperature();
            double avg = (prevTemp + weatherData.getTemperature()) / 2;
            prevTemp = avg;

            weatherArea.setBackground(Color.ORANGE);
            weatherArea.setText("Average Condition [Weather]:\n");
            weatherArea.append("Temperature = " + avg);
        }
        
        if(data instanceof OceanData) {
        	OceanData oceanData = (OceanData) data;
            if(prevWaveH == 0) prevWaveH = oceanData.getWaveHeight();
            double wavg = (prevWaveH + oceanData.getWaveHeight()) / 2;
            prevWaveH = wavg;
            
            oceanArea.setBackground(Color.GREEN);
            oceanArea.setText("Average Condition [Ocean]:\n");
            oceanArea.append("Wave Height = " + wavg);
        }
        
        if(data instanceof PollutionData) {
        	PollutionData pollutionData = (PollutionData) data;
            if(prevPM10 == 0) prevPM10 = pollutionData.getPm10();
            double p10avg = (prevPM10 + pollutionData.getPm10()) / 2;
            prevPM10 = p10avg;
            
            pollutionArea.setBackground(Color.DARK_GRAY);
            pollutionArea.setText("Average Condition [Pollution]:\n");
            pollutionArea.append("PM 10 = " + p10avg);
        }
    }
}
