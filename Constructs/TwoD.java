package Constructs;

abstract public class TwoD{
    private String color;

    public void ShapeColor (String color){
        this.color = color;
    }
    public String getColor(){
        return color;
    }

    public static void main(String[] args){
        TwoD A = new Rectangle();
        TwoD B = new Triangle();
        A.ShapeColor("Cyan");
        B.ShapeColor("Orange");
        System.out.println("Shape A color= "+A.getColor());
        System.out.println("Shape B color= "+B.getColor());
        System.out.println(((Rectangle) A).getArea(5.3, 4.5));
        System.out.println(((Triangle) B).getArea(9.1, 2.8));
    }
}