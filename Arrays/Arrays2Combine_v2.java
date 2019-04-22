import java.util.*;
import java.io.*;

public class Arrays2Combine_v2{
    private static String[] Array1;
    private static String[] Array2;
    private static String[] Array3;
    private static ArrayList<String> Array4=new ArrayList<String>();
    public static void main(String[] args){
        System.out.print("Jumlah elemen Array pertama: ");
        Scanner LengthArray1=new Scanner(System.in);
        int length1=LengthArray1.nextInt();
        System.out.print("Elemen Array pertama (Gunakan spasi): ");
        Scanner InArray1=new Scanner(System.in);
        String input1=InArray1.nextLine();
        System.out.print("Jumlah elemen Array kedua  : ");
        Scanner LengthArray2=new Scanner(System.in);
        int length2=LengthArray2.nextInt();
        System.out.print("Elemen Array kedua (Gunakan spasi)  : ");
        Scanner InArray2=new Scanner(System.in);
        String input2=InArray2.nextLine();
        System.out.println();
        Array1=new String[length1];
        Array2=new String[length2];
        Array3=new String[Array1.length+Array2.length];
        inputStrings(input1,Array1);
        inputStrings(input2,Array2);
        sortStrings(Array1);
        sortStrings(Array2);
        System.out.print("Array pertama: ");
        showStrings(Array1);
        System.out.print("Array kedua  : ");
        showStrings(Array2);
        combineArrays(Array1,Array2,Array3);
        sortStrings(Array3);
        System.out.print("Gabungan Array: ");
        showStrings(Array3);
    }

    private static void inputStrings(String input,String[] array){
        String[] temp=input.split(" ");
        int counter=0;
        for(String str: temp){
            array[counter++]=str;
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