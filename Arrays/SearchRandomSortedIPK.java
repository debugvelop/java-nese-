import java.util.*;

public class SearchRandomSortedIPK{
    public static void main(String[] args){
        System.out.print("Hasilkan IPK sebanyak: ");
        Scanner Input1= new Scanner(System.in);
        int myInput= Input1.nextInt();
        double[] GPA= new double[myInput];
        for(int a=0;a<GPA.length;a++){
            GPA[a]= Math.round((Math.random()*3+1)*100)/100.00;
        }
        for(int a=0;a<GPA.length;a++){
            System.out.print(GPA[a]+" ");
        }
        System.out.println();
        Scanner Input2= new Scanner(System.in);
        double searchInput=0;
        boolean checkInput=false;
        while(!checkInput){
            try {
                System.out.print("Cari IPK             : ");
                searchInput= Input2.nextDouble();
                checkInput=true;
            } catch (InputMismatchException e) {
                System.out.println("Input salah!");
                Input2.next();
            }
        }
        Arrays.sort(GPA);
        BinarySearch(searchInput,GPA);
        Input1.close();
        Input2.close();
    }

    public static void BinarySearch(double searchInput,double GPA[]){
        boolean found=false;
        int i=0,j=GPA.length,k=0,result=1;
        double query=searchInput;
        while(!found&&i<=j){
            k=(i+j)/2;
            if(GPA[k]<query){
                i=k+1;
            }
            else if(GPA[k]==query){
                int up=k-1,down=k+1;
                while(!found){
                    if(GPA[up]==GPA[k]){
                        result++;
                    }
                    else if(GPA[down]==GPA[k]){
                        result++;
                    }
                    else{
                        found=true;
                    }
                    up--;
                    down++;
                }
            }
            else{
                j=k-1;
            }
        }
        if(found==false){
            System.out.println("IPK tidak ditemukan");
        }
        else{
            System.out.println("IPK " + query +" ditemukan sebanyak "+ result +" kali");
        }
    }
}