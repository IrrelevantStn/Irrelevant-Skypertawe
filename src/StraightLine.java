import java.awt.Color;
import java.awt.Graphics;

public class StraightLine {
private Color colour = new Color(000000);
private int x1;
private int x2;
private int y1;
private int y2;


	public int getX1() {
	return x1;
}


public void setX1(int x1) {
	this.x1 = x1;
}


public int getX2() {
	return x2;
}


public void setX2(int x2) {
	this.x2 = x2;
}


public int getY1() {
	return y1;
}


public void setY1(int y1) {
	this.y1 = y1;
}


public int getY2() {
	return y2;
}


public void setY2(int y2) {
	this.y2 = y2;
}


	public StraightLine(int x1, int x2, int y1, int y2){
		}
		
		
	public void drawLine(Graphics g) {
		
		g.setColor(colour);
		g.drawLine(x1, y1, x2, y2);
		g.dispose();		
	}			
	g.drawLine(x1, y1, x2, y2)
}