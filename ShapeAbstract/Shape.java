package ShapeAbstract; //Mendeklarasikan "package" yang memuat berkas

abstract class Shape{
    protected String color;
    protected Boolean filled;

    public static void main(String[] args){       //Mendeklarasikan kelas "main" yang memuat perintah
        Shape s1 = new Circle(5.5, "RED", false); //Membuat objek Circle dari kelas Shape (Upcast)
        System.out.println(s1);                    
        System.out.println(s1.getArea());         //Memanggil fungsi kelas Shape (Override)
        System.out.println(s1.getPerimeter());     
        System.out.println(s1.getColor());
        System.out.println(s1.isFilled());
        System.out.println(s1.getRadius());       //Error karena tidak dilakukan cast pada objek s1
                                                  //sehingga fungsi tidak dapat dipanggil via kelas Shape
        
        Circle c1 = (Circle)s1;                   //Membuat objek Circle dari kelas Circle (Downcast)
        System.out.println(c1);
        System.out.println(c1.getArea());
        System.out.println(c1.getPerimeter());
        System.out.println(c1.getColor());
        System.out.println(c1.isFilled());
        System.out.println(c1.getRadius());
        
        Shape s2 = new Shape();                   //Error karena membuat objek Shape di mana Shape adalah kelas abstract
        
        Shape s3 = new Rectangle(1.0, 2.0, "RED", false);
        System.out.println(s3);
        System.out.println(s3.getArea());
        System.out.println(s3.getPerimeter());
        System.out.println(s3.getColor());
        System.out.println(s3.getLength());        //Error karena tidak dilakukan cast pada objek s3
                                                   //sehingga fungsi tidak dapat dipanggil via kelas Shape
        
        Rectangle r1 = (Rectangle)s3;              //Membuat objek Rectangle dari kelas Rectangle (Downcast)
        System.out.println(r1);
        System.out.println(r1.getArea());
        System.out.println(r1.getColor());
        System.out.println(r1.getLength());
        
        Shape s4 = new Square(6.6);                //Membuat objek Square dari kelas Shape (Upcast)
        System.out.println(s4);
        System.out.println(s4.getArea());
        System.out.println(s4.getColor());
        System.out.println(s4.getSide());          //Error karena tidak dilakukan cast pada objek s4
                                                   //sehingga fungsi tidak dapat dipanggil via kelas Shape
        
        Rectangle r2 = (Rectangle)s4;              //Membuat objek Rectangle dari kelas Rectangle (Downcast)
        System.out.println(r2);
        System.out.println(r2.getArea());
        System.out.println(r2.getColor());
        System.out.println(r2.getSide());          //Error karena tidak dilakukan cast pada objek
        System.out.println(r2.getLength());        //sehingga fungsi tidak dapat dipanggil via kelas Rectangle
        
        
        Square sq1 = (Square)r2;                   //Membuat objek Square dari kelas Square (Downcast)
        System.out.println(sq1);
        System.out.println(sq1.getArea());
        System.out.println(sq1.getColor());
        System.out.println(sq1.getSide());
        System.out.println(sq1.getLength());
    }

    public Shape(){                                //Constructor
    }

    public Shape(String color,Boolean filled){     //Constructor dengan fitur menyimpan atribut objek
        this.color = color;
        this.filled = filled;
    }

    public String getColor(){                      //Menunjukan atribut color dari objek Shape
        return color;
    }

    public void setColor(String color){            //Mengubah atribut color dari objek Shape
        this.color=color;
    }

    public Boolean isFilled(){
        return filled;
    }

    public void setFilled(Boolean filled){
        this.filled=filled;
    }

    abstract double getArea();                    //Fungsi abstract kelas Shape yang akan di-override fungsi identik pada kelas lain

    abstract double getPerimeter();

    public abstract String toString();
}

class Rectangle extends Shape{                   //Kelas Rectangle melakukan ekstensi kelas Shape sehingga
    protected double width;                      //bisa dilakukan Casting dan Override dari kelas Shape
    protected double length;

    public Rectangle(){
    }

    public Rectangle(double width,double length){
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width,double length,String color,Boolean filled){
        this.width = width;
        this.length = length;
    }

    public double getWidth(){
        return width;
    }

    public void setWidth(double width){
        this.width=width;
    }

    public double getLength(){
        return length;
    }

    public void setLength(double length){
        this.length=length;
    }

    public double getArea(){
        return width*length;
    }

    public double getPerimeter(){
        return (2*width)+(2*length);
    }

    public String toString(){                 //Menunjukan atribut dari objek Rectangle
        return "Rectangle width= "+getWidth()+" length= "+getLength()+" area= "+getArea()+" perimeter= "+getPerimeter();
    }
}

class Circle extends Shape{                   //Kelas Circle melakukan ekstensi kelas Shape sehingga
    protected double radius;                  //bisa dilakukan Casting dan Override dari kelas Shape

    public Circle(){
    }

    public Circle(double radius,String color,boolean filled){
        this.radius = radius;
    }

    public double getRadius(){
        return radius;
    }

    public void setRadius(double radius){
        this.radius=radius;
    }

    public double getArea(){
        return (radius*radius)*(22/7);
    }

    public double getPerimeter(){
        return (radius*2)*(22/7);
    }

    public String toString(){                 //Menunjukan atribut dari objek Circle
        return "Circle radius= "+getRadius()+" area= "+getArea()+" perimeter= "+getPerimeter();
    }
}

class Square extends Rectangle{              //Kelas Square melakukan ekstensi kelas Rectangle sehingga
    protected double side;                   //bisa dilakukan Casting dan Override dari kelas Shape

    public Square(){
    }

    public Square(double side){
        this.side = side;
    }

    public Square(double side,String color,Boolean filled){
        this.side = side;
    }

    public double getSide(){
        return side;
    }

    public void setSide(double side){
        this.side=side;
    }

    public void setWidth(double width){
        this.width=width;
    }

    public void setLength(double length){
        this.length=length;
    }

    public String toString(){                //Menunjukan atribut dari objek Square
        return "Square side= "+getSide();
    }
}