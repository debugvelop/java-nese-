package Constructs;

public class Rectangle extends TwoD{
    private double RecLenght;
    private double RecWidth;

    public Rectangle(){
    }

    public double getLength(){
        return RecLenght;
    }

    public double getWidth(){
        return RecWidth;
    }

    public double getArea(double RecLenght,double RecWidth){
        this.RecLenght=RecLenght;
        this.RecWidth=RecWidth;
        double Area=RecLenght*RecWidth;
        return Area;
    }

    public String toString(){
        return "Rectangle length= "+getLength()+"/n"+"Rectangle width = "+getWidth()+"/n";
    }
}