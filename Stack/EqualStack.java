import java.math.*;

public class EqualStack{
    public static void main(String[] args){
        Stacks alpha=new Stacks(5);
        Stacks beta=new Stacks(3);
        Stacks gamma=new Stacks(4);
        int alp,bet,gam,check;
        alpha.push(3);
        alpha.push(2);
        alpha.push(1);
        alpha.push(1);
        alpha.push(1);
        beta.push(4);
        beta.push(3);
        beta.push(2);
        gamma.push(1);
        gamma.push(1);
        gamma.push(4);
        gamma.push(1);
        /*for(int x=0;x<5;x++){
            System.out.print(alpha.pop()+" ");
        }
        System.out.println();
        for(int x=0;x<3;x++){
            System.out.print(beta.pop()+" ");
        }
        System.out.println();
        for(int x=0;x<4;x++){
            System.out.print(gamma.pop()+" ");
        }
        System.out.println();*/
        alp=alpha.sum();
        bet=beta.sum();
        gam=gamma.sum();
        do{
            check=Math.min(alp,bet);
            check=Math.min(gam,check);
            if(alp>check){
                alp=alpha.dec();
            }
            if(bet>check){
                bet=beta.dec();
            }
            if(gam>check){
                gam=gamma.dec();
            }
        }while(alp!=bet||bet!=gam);
        System.out.print(alp+" "+bet+" "+gam);
    }
}

class Stacks extends EqualStack{
    private int[] mystack;
    private int length,itr,plus,dec,store;

    public Stacks(int length){
        this.length=length;
        mystack=new int[length];
        this.itr=0;
        this.plus=0;
        this.dec=0;
        this.store=0;
    }

    public void push(int in){
        mystack[itr++]=in;
    }

    /*public int pop(){
        return mystack[--itr];
    }*/

    public int sum(){
        int x=length;
        while(x>=1){
            plus+=mystack[--itr];
            x--;
        }
        return plus;
    }

    public int dec(){
        store+=mystack[itr++];
        dec=plus-store;
        return dec;
    }
}