package Constructs;

public class Triangle extends TwoD{
    private double TriBase;
    private double TriHeight;

    public Triangle(){
    }

    public double getBase(){
        return TriBase;
    }

    public double getHeight(){
        return TriHeight;
    }

    public double getArea(double TriBase,double TriHeight){
        this.TriBase=TriBase;
        this.TriHeight=TriHeight;
        double Area=TriBase*TriHeight/2;
        return Area;
    }

    public String toString(){
        return "Triangle base= "+getBase()+"/n"+"Triangle height = "+getHeight();
    }
}