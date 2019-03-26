import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution{
    static int itr,plus;
    static int equalStacks(int[] h1, int[] h2, int[] h3) {
        int x=0,y=0,z=0,a,b,c,as,bs,cs,ad=0,bd=0,cd=0,check;
        a=sum(h1);
        b=sum(h2);
        c=sum(h3);
        as=a;
        bs=b;
        cs=c;
        do{
            check=Math.min(a,b);
            check=Math.min(c,check);
            if(a>check){
                ad+=h1[x++];
                a=as-ad;
            }
            if(b>check){
                bd+=h2[y++];
                b=bs-bd;
            }
            if(c>check){
                cd+=h3[z++];
                c=cs-cd;
            }
        }while(a!=b||b!=c);
        return a;
    }

    static int sum(int[] stack){
        itr=stack.length-1;
        plus=0;
        while(itr>=0){
            plus+=stack[itr--];
        }
        return plus;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] n1N2N3 = scanner.nextLine().split(" ");

        int n1 = Integer.parseInt(n1N2N3[0].trim());

        int n2 = Integer.parseInt(n1N2N3[1].trim());

        int n3 = Integer.parseInt(n1N2N3[2].trim());

        int[] h1 = new int[n1];

        String[] h1Items = scanner.nextLine().split(" ");

        for (int h1Itr = 0; h1Itr < n1; h1Itr++) {
            int h1Item = Integer.parseInt(h1Items[h1Itr].trim());
            h1[h1Itr] = h1Item;
        }

        int[] h2 = new int[n2];

        String[] h2Items = scanner.nextLine().split(" ");

        for (int h2Itr = 0; h2Itr < n2; h2Itr++) {
            int h2Item = Integer.parseInt(h2Items[h2Itr].trim());
            h2[h2Itr] = h2Item;
        }

        int[] h3 = new int[n3];

        String[] h3Items = scanner.nextLine().split(" ");

        for (int h3Itr = 0; h3Itr < n3; h3Itr++) {
            int h3Item = Integer.parseInt(h3Items[h3Itr].trim());
            h3[h3Itr] = h3Item;
        }

        int result = equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}