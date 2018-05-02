package finalProject;

import java.awt.Color;
import java.awt.Graphics;

public class Bar {
	private String label;
	private double value;
	public static final int HEIGHT = 30;

	/**
	 * @param aLabel
	 * @param size
	 */
	public Bar(String aLabel, double size) {
		label = aLabel;
		value = size;
	}

	public void draw(Graphics g, int y, double scale) {
		final int GAP = 0;
		g.drawRect(0, y, 800, HEIGHT);
	///	g.fillRect(0, y, 800, HEIGHT);
		g.drawString(label, 200, y-7 + HEIGHT );

	
	}
}
