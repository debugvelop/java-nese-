package Constructs;

public class Circles{
    private double radius=7;
    private String color="Black";

    public Circles(){
    }

    public void CircleRad(){
        System.out.println(radius);
    }

    public void CircleColor(){
        System.out.println(color);
    }

    public double getRadius(){
        return radius;
    }

    public void setRadius(double radius){
        this.radius=radius;
    }

    public String getColor(){
        return color;
    }

    public void setColor(String color){
        this.color=color;
    }
    
    public double getAreaDef(){
        double Area=radius*radius*(22/7);
        return Area;
    }
    
    public double getArea(double radius){
        this.radius=radius;
        double Area=radius*radius*(22/7);
        return Area;
    }
}