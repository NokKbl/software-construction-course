package lec10observer.weatherorama.ver1;

import javax.swing.*;
import java.awt.*;

public class ForecastDisplay implements Observer{
	
	private double prevTemp;
	private double datapoints=1;

    private JFrame frame;
    private JTextArea area;

    public ForecastDisplay() {
        frame = new JFrame();
        frame.setSize(200, 200);
        frame.setTitle("Forecast Temperature");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        area = new JTextArea(150, 150);
        frame.add(area);
        area.setBackground(Color.GRAY);
        area.setText("Forecast Temperature:\n");

    }

	@Override
	public void update(double temp, double humid, double pressure) {
		// TODO Auto-generated method stub
		double avg;
		if(prevTemp == 0) avg = temp;
		else avg = (prevTemp+temp)/(datapoints);
		prevTemp += temp;
		datapoints++;
		
		area.setBackground(Color.GRAY);
		area.setText("Forecast Temperature:\n");
		area.append("Temperature [for next period] = " + avg);
	}

}
