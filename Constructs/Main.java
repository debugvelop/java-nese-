package Constructs;

public class Main{
    public static void main(String[] args){
        System.out.println("A circle construct");
        Circles C= new Circles();
        C.CircleRad();
        C.CircleColor();
        C.setRadius(70.0);
        C.setColor("Gray");
        C.CircleRad();
        C.CircleColor();
        System.out.println(C.getAreaDef());
        System.out.println(C.getArea(60.0));

        Cylinder S= new Cylinder();
        System.out.println(S.getVolumeDef());
        S.setHeight(27.5);
        System.out.println(S.getVolumeDef());
        System.out.println(S.getVolume(42.7));
    }
}