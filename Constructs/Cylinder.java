package Constructs;

public class Cylinder extends Circles{
    private double height=7;

    public Cylinder(){
    }

    public void CylinderCh(double height){
        this.height=height;
    }

    public void CylinderChr(double height,double radius){
        this.height=height;
        this.setRadius(radius);
    }

    public void CylinderChrc(double height,double radius,String color){
        this.height=height;
        this.setRadius(radius);
        this.setColor(color);
    }

    public double getHeight(){
        return height;
    }

    public void setHeight(double height){
        this.height=height;
    }

    public double getVolumeDef(){
        double volume=getAreaDef()*height;
        return volume;
    }

    public double getVolume(double radius){
        double volume=getArea(radius)*height;
        return volume;
    }
}