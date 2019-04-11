package lec10observer.weatherorama.ver1;

import javax.swing.*;
import java.awt.*;

public class HumidityAverageDisplay implements Observer {
	private double prevHumid;
	private double datapoints=1;

    private JFrame frame;
    private JTextArea area;

    public HumidityAverageDisplay() {

        frame = new JFrame();
        frame.setSize(200, 200);
        frame.setTitle("Average Humidity");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        area = new JTextArea(150, 150);
        frame.add(area);
        area.setBackground(Color.BLUE);
        area.setText("Average Humidity:\n");

    }
    
	@Override
	public void update(double temp, double humid, double pressure) {
		// TODO Auto-generated method stub
		double avg;
		if(prevHumid == 0) avg = humid;
		else avg = (prevHumid+humid)/(datapoints);
		prevHumid += humid;
		datapoints++;
		
		area.setBackground(Color.BLUE);
		area.setText("Average Humid:\n");
		area.append("Humid = " + avg);
	}

}
