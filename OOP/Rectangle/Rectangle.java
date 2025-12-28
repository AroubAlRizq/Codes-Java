
import java.util.*;
public class Rectangle {
    
    private double width; 
    private double height;
    
    
    public Rectangle (){
        this.width = 1.0;
        this.height = 1.0;
    }
     
    public Rectangle (double width, double height){
        this.width =width;
        this.height =height;
    }   
    public void setWidth(double width){
        this.width =width;
    }
    
    public void setHeight (double height){
        this.height=height;
    }
    public double getWidth(){
        return width;
    }
    public double getHeight(){
        return height;
    }
    public double getArea(double width, double height){
        double area =width*height;
        return area;
    }
    public double getPerimeter(double width, double height){
        double perimeter = (width*2)+(height*2);
        return perimeter;
    }
    public String toString(){
        return "Width = "+this.width+ " "
                + "\nHeight = " + this.height + ""
                + "\nArea = " + this.getArea(width, height) + ""
                + "\nPerimeter = " + this.getPerimeter(width, height)+ ""
                + "\n";
    }

  
   
}
