import java.util.*;
import java.util.concurrent.TimeUnit;
import java.security.*;

public class GraphTask{
    public static void main(String[] args) throws NoSuchAlgorithmException,NoSuchProviderException{
        Graph foo;
        SecureRandom randomEdge=SecureRandom.getInstance("SHA1PRNG","SUN");
        long start,end;
        Scanner input1=new Scanner(System.in);
        int vertex=input1.nextInt();
        Scanner input2=new Scanner(System.in);
        int edge=input2.nextInt();
        foo=new Graph(vertex);
        for(int length=0;length<edge;length++){
            int row=randomEdge.nextInt(99999999)%vertex;
            int col=randomEdge.nextInt(99999999)%vertex;
            if(row==col){
                row=randomEdge.nextInt(99999999)%vertex;
                col=randomEdge.nextInt(99999999)%vertex;
            }
            foo.addEdge(row,col);
        }
        start=System.nanoTime();
        foo.floydWarshall();
        end=System.nanoTime();
        System.out.println("Floyd-Warshall: "+TimeUnit.NANOSECONDS.toMillis(end-start)+" ms");
        start=System.nanoTime();
        foo.dijkstra();
        end=System.nanoTime();
        System.out.println("Dijkstra      : "+TimeUnit.NANOSECONDS.toMillis(end-start)+" ms");
        input1.close();
        input2.close();
    }
}

class Graph extends GraphTest{
    private int[][] adjGraph;
    private SecureRandom randomer=new SecureRandom();
    private int length;

    public Graph(int length){
        this.length=length;
        adjGraph=new int[length][length];
        for(int row=0;row<length;row++){
            for(int col=0;col<length;col++){
                if(row!=col){
                    adjGraph[row][col]=1000000;
                }
            }
        }
    }

    public void checkArray(){
        for(int row=0;row<length;row++){
            for(int col=0;col<length;col++){
                System.out.print(adjGraph[row][col]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void addEdge(int row,int col){
        int range=randomer.nextInt(20);
        if(range==0){
            range=randomer.nextInt(20);
        }
        adjGraph[row][col]=range;
        adjGraph[col][row]=range;
    }

    public void floydWarshall(){
        int[][] temp=adjGraph;
        int result=0;
        for(int row=0;row<temp.length;row++){
            for(int col=0;col<temp.length;col++){
                temp[row][col]=adjGraph[row][col];
            }
        }
        for(int row=0;row<length;row++){
            for(int col=0;col<length;col++){
                for(int end=0;end<length;end++){
                    if(temp[row][col]+temp[col][end]<temp[row][end]){
                        temp[row][end]=temp[row][col]+temp[col][end];
                    }
                }
            }
        }
    }

    public void dijkstra(){
    }
}