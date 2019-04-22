import java.util.*;
import java.security.*;

public class Arrays2Combine_v1{
    private static String[] Array1;
    private static String[] Array2;
    private static String[] Array3;
    private static ArrayList<String> Array4=new ArrayList<String>();
    public static void main(String[] args){
        boolean done=false;
        while(!done){
            System.out.print("Jumlah elemen Array pertama: ");
            Scanner input1= new Scanner(System.in);
            int length=input1.nextInt();
            System.out.print("Jumlah karakter String     : ");
            Scanner input2= new Scanner(System.in);
            int strlength=input2.nextInt();
            if(Math.pow(26,strlength)>=length){
                Array1=new String[length];
                inputStrings(strlength,Array1);
                sortStrings(Array1);
                input1.close();
                input2.close();
                done=true;
            }
            else{
                System.out.println("Jumlah karakter String kurang!");
                System.out.println();
            }
        }
        done=false;
        while(!done){
            System.out.print("Jumlah elemen Array kedua  : ");
            Scanner input1= new Scanner(System.in);
            int length=input1.nextInt();
            System.out.print("Jumlah karakter String     : ");
            Scanner input2= new Scanner(System.in);
            int strlength=input2.nextInt();
            if(Math.pow(26,strlength)>=length){
                Array2=new String[length];
                inputStrings(strlength,Array2);
                sortStrings(Array2);
                input1.close();
                input2.close();
                done=true;
            }
            else{
                System.out.println("Jumlah karakter String kurang!");
                System.out.println();
            }
        }
        Array3=new String[Array1.length+Array2.length];
        showStrings(Array1);
        showStrings(Array2);
        combineArrays(Array1,Array2,Array3);
        sortStrings(Array3);
        showStrings(Array3);
    }

    private static String generateStrings(int length){
        String listRandom="abcdefghijklmnopqrstuvwxyz";
        StringBuffer RandomStr=new StringBuffer(length);
        SecureRandom randomer=new SecureRandom();
        for(int counter=0;counter<length;counter++){
            RandomStr.append(listRandom.charAt(randomer.nextInt(listRandom.length())));
        }
        return RandomStr.toString();
    }

    private static boolean checkDuplicate(String[] array,int index,String str){
        boolean duplicate=false;
        while(index>0){
            if(str.equals(array[--index])){
                duplicate=true;
            }
        }
        return duplicate;
    }

    private static void inputStrings(int length,String[] array){
        for(int counter=0;counter<array.length;counter++){
            String freshStr;
            do{
                freshStr=generateStrings(length);
            }while(checkDuplicate(array,counter,freshStr));
            array[counter]=freshStr;
        }
    }

    private static void showStrings(String[] array){
        for(String str: array){
            if(str!=null){
                System.out.print(str+" ");
            }
        }
        System.out.println();
    }

    private static void sortStrings(String[] array){
        int counter=0;
        if(array[array.length-1]==null){
            for(String str: array){
                if(str!=null){
                    Array4.add(str);
                }
            }
            Collections.sort(Array4);
            for(String str: Array4){
                Array3[counter++]=str;
            }
        }
        else{
            Arrays.sort(array);
        }
    }

    private static void combineArrays(String[] arrayA,String[] arrayB,String[] arrayC){
        int counter=0;
        for(String strA: arrayA){
            for(String strB: arrayB){
                if(strA.equals(strB)){
                    arrayC[counter++]=strA;
                }
            }
        }
        if(arrayC[0]!=null){
            int limit=counter-1;
            for(String strA: arrayA){
                int x=0;
                boolean same=false;
                while(x<=limit && !same){
                    if(strA.equals(arrayC[x++])){
                        same=true;
                        break;
                    }
                }
                if(!same){
                    arrayC[counter++]=strA;
                }
            }
            for(String strB: arrayB){
                int x=0;
                boolean same=false;
                while(x<=limit && !same){
                    if(strB.equals(arrayC[x++])){
                        same=true;
                        break;
                    }
                }
                if(!same){
                    arrayC[counter++]=strB;
                }
            }
        }
        else{
            counter=0;
            for(String strA: arrayA){
                arrayC[counter++]=strA;
            }
            for(String strB: arrayB){
                arrayC[counter++]=strB;
            }
        }
    }
}