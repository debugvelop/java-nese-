import java.util.*;
import java.security.*;

public class GraphTask{
    public static void main(String[] args){
        Graph foo;
        SecureRandom randomEdge=new SecureRandom();
        Scanner input1=new Scanner(System.in);
        int vertex=input1.nextInt();
        Scanner input2=new Scanner(System.in);
        int edge=input2.nextInt();
        foo=new Graph(vertex);
        for(int counter=0;counter<edge;counter++){
            foo.addEdge(randomEdge.nextInt(vertex-1),randomEdge.nextInt(vertex-1));
        }
        foo.floydWarshall();
        //foo.checkArray();
        input1.close();
        input2.close();
    }
}

class Graph extends GraphTest{
    private int[][] adjGraph;
    private SecureRandom randomer=new SecureRandom();
    private int counter=0;
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
        int[][] temp=new int[length][length];
        int result=0;
        for(int row=0;row<temp.length;row++){
            for(int col=0;col<temp.length;col++){
                temp[row][col]=adjGraph[row][col];
            }
        }
        for(int row=0;row<counter;row++){
            for(int col=0;col<counter;col++){
                for(int end=0;end<counter;end++){
                    if(temp[row][col]+temp[col][end]<temp[row][end]){
                        temp[row][end]=temp[row][col]+temp[col][end];
                    }
                }
            }
        }
        for(int row=0;row<counter;row++){
            for(int col=0;col<counter;col++){
                System.out.print(temp[row][col]+" ");
            }
            System.out.println();
        }
    }

    public void dijkstra(){
    }
}