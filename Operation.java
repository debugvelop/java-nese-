class Operation{
    public static void main(String[] args){
        float GPA=2,y=3,z=5;
        float Div1;
        double Div2;
        float preplus,postplus;
        /* To get detailed result of division, start with float, long, or double variable. Remember the
        level of variable size (char,int,long,float,double), convert from small size to big size in the only possible */
        Div1=y/GPA;
        Div2=z/y;
        preplus=GPA++;
        postplus=++z;
        float postpre=preplus+1;
        System.out.println(Div1);
        System.out.println(Div2);
        System.out.println(preplus);
        System.out.println(postplus);
        System.out.println(postpre);
    }
}