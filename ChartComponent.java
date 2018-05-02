package finalProject;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;

public class ChartComponent extends JComponent {
	private ArrayList<Bar> bars;
	private double maxValue;

	/**
	 * make chart components
	 */
	public ChartComponent() {
		bars = new ArrayList<Bar>();
	    maxValue = 1;
	}

	/**
	 * @param label
	 */
	public void append(String label) {
		bars.add(new Bar(label,100));
		
		repaint();
	}

	/**
	 * remove last one in chart
	 */
	public void removeLast() {
		int n = bars.size();
		if (n == 0) {
			return;
		}
		bars.remove(n - 1);
		repaint();
	}

     /* (non-Javadoc)
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    public void paintComponent(Graphics g) {
	

		int y =0;
		double scale = getWidth() / maxValue;
		for (Bar b : bars) {
			
			b.draw(g, y, scale);
			y = y + Bar.HEIGHT ;
		}
	}
}