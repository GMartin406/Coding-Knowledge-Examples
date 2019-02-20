/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turtle;

/**Greg Martin
 * 12/2/18
 * 
 */
import javax.swing.*;
import java.awt.*;


public class Turtle2 {

    private static JFrame jframe;
    private static JPanel panel; 
    private static Graphics graphics;
    private int difference; 
    public static int width= 500;
    public static int height= 500;
    private double x, y;
    private double angle; 
    private boolean penDown= true;
    private Color turtleColor= Color.black;
    
    public Turtle2() {
        this(width/2, height/2, 0);
    }
      
    public Turtle2(double x, double y, double ang) {
        if (jframe == null) {
            jframe= new JFrame("Turtle");
            panel= new JPanel();
            panel.setPreferredSize(new Dimension(width, height));
            panel.setBackground(Color.white);
            jframe.getContentPane().add(panel, BorderLayout.CENTER);
            jframe.pack();
            jframe.setVisible(true);
            graphics= panel.getGraphics();
            difference= jframe.getHeight() - panel.getHeight();
            speed(100);
            clear();
            speed(100);
        }
        this.x= x;
        this.y= y;
        angle= ang;
    }

    private static int rand(){
        return (int)(Math.random()*256.0);
    }
    
    public static Color randColor() {
        return new Color(rand(), rand(), rand());
    }

    public void setPanelSize() {
        width= jframe.getWidth();
        height= jframe.getHeight()-difference;
        Dimension d= new Dimension(width, height);
        panel.setPreferredSize(d);
        graphics= panel.getGraphics();
        jframe.pack();
        clear();
        speed(100);
    }
    
    public double getX() {
        return x;   
    }

    public double getY() {
        return y;   
    }

    public double getAngle() {
        return angle;   
    }

    public int getWidth() {
        return width;   
    }

    public int getHeight() {
        return height;   
    }

    public void setAngle(double ang) {
        angle= mod(ang, 360);
    }

    public void left(double ang) {
        angle= mod (angle + ang, 360);
    }
    
    public void right(double ang){
        angle = mod(angle-ang,360);
    }
    
    public void penUp() {
        penDown= false;   
    }
    
    public void penDown() {
        penDown= true;   
    }
    
    public void setColor(Color c) {
        turtleColor= c;
    }
    public void setColor(int r, int g, int b){
        Color color = new Color(r,g,b);
        turtleColor = color;
    }

    public Color getColor() {
        return turtleColor;
    }

    public void goTo(double x, double y, double ang) {
        Color save= graphics.getColor();
        graphics.setColor(turtleColor);
        if(penDown == true){
            graphics.drawLine((int)Math.round(this.x), (int)Math.round(this.y),
                          (int)Math.round(x), (int)Math.round(y));
        }
        this.x= x;
        this.y= y;
        angle= ang;
        graphics.setColor(save);
    }
    
    public void forward(double d) {
        double rAngle= (angle * Math.PI) / 180;
        double newX= x + Math.cos(rAngle) * d;
        double newY= y - Math.sin(rAngle) * d;
        if (penDown) {
            Color save= graphics.getColor();
            graphics.setColor(turtleColor);
            //graphics.setStroke(new BasicStroke(10));
            graphics.drawLine((int)Math.round(x), (int)Math.round(y),
                          (int)Math.round(newX), (int)Math.round(newY));
            graphics.setColor(save);
        }
        x= newX;
        y= newY;
    }
    
    private double mod(double x, double y) {
        double ans= x % y;
        if (ans < 0) 
            ans= ans + y;
        return ans;
    }
    
    public void clear() {
        Color c= graphics.getColor();
        graphics.setColor(Color.white);
        graphics.fillRect(0, 0, width, height);
        graphics.setColor(c);
    }
    
    public void speed(int msec) {
        try { Thread.currentThread().sleep(msec); }
        catch (InterruptedException e) { }
    }   
    
    public void home(){
        penUp();
        x = width/2;
        y = height/2;
        angle = 0;
        penDown();
    }
    
    public static void main(String[] args){
        Turtle2 turtle = new Turtle2();
        turtle.setColor(255,255,0);
        int sides = 8;
        int length =55;
        for(int i=0;i<sides;i++){
            turtle.forward(length);
            turtle.left(360/sides);
        }
        Turtle2 turt = new Turtle2();
        turt.setColor(0,0,255);
        turt.home();
        turt.penUp();
        
        turt.goTo(turt.x - 30, turt.y+25, turt.angle+0);
        turt.penDown();
        turt.forward(125);
    }
}
