import java.util.*;
import java.io.*;
import java.security.SecureRandom;

public class Arrays2Combine{
    private static String[] Array1;
    private static String[] Array2;
    private static String[] Array3;
    private static ArrayList<String> Array4=new ArrayList<String>();
    public static void main(String[] args){
        Array1=new String[8];//{"a","b","c","d","e","f","g","h"};
        Array2=new String[14];//{"a","c","e","g","i","j","k","l","m","n","o","p","q","r"};
        Array3=new String[Array1.length+Array2.length];
        inputStrings(1,Array1);
        inputStrings(1,Array2);
        showStrings(Array1);
        showStrings(Array2);
        sortStrings(Array1);
        sortStrings(Array2);
        combineArrays(Array1,Array2,Array3);
        sortStrings(Array3);
        showStrings(Array3);
    }

    private static String generateStrings(int length){
        String listRandom="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuffer RandomStr=new StringBuffer(length);
        SecureRandom randomer=new SecureRandom();
        for(int x=0;x<length;x++){
            RandomStr.append(listRandom.charAt(randomer.nextInt(listRandom.length())));
        }
        return RandomStr.toString();
    }

    private static boolean checkDuplicate(String[] array,int index,String str){
        boolean duplicate=false;
        while(index>0){
            if(array[index-1]==str){
                duplicate=true;
            }
            index--;
        }
        return duplicate;
    }

    private static void inputStrings(int length,String[] array){
        for(int x=0;x<array.length;x++){
            String freshStr=generateStrings(length);
            if(!checkDuplicate(array,x,freshStr)){
                array[x]=freshStr;
            }
            else{
                array[x]=generateStrings(length);
            }
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