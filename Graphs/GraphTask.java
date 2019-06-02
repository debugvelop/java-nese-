import java.util.*;
import java.security.*;

public class GraphTask{
    public static void main(String[] args){
        Graph foo= new Graph(10);
        foo.addVertex("JOG");
        foo.addVertex("SUB");
        foo.addVertex("CGK");
        foo.addVertex("MKS");
        foo.addVertex("DPS");
        foo.addVertex("BTH");
        foo.addVertex("KNO");
        foo.addVertex("PNK");
        foo.addVertex("BPN");
        foo.addVertex("LOP");
        foo.addEdge("JOG","SUB");
        foo.addEdge("JOG","CGK");
        foo.addEdge("SUB","CGK");
        foo.addEdge("SUB","MKS");
        foo.addEdge("CGK","MKS");
        foo.addEdge("CGK","DPS");
        foo.addEdge("DPS","LOP");
        foo.addEdge("LOP","MKS");
        foo.addEdge("MKS","BPN");
        foo.addEdge("BPN","PNK");
        foo.addEdge("SUB","BPN");
        foo.addEdge("CGK","PNK");
        foo.addEdge("BTH","PNK");
        foo.addEdge("KNO","BTH");
        foo.addEdge("KNO","CGK");
        foo.addEdge("BTH","CGK");
        foo.showVertex();
        foo.showEdges();
        foo.floydWarshall();
    }
}

class Graph extends GraphTest{
    private String[] inputVertex;
    private boolean[] visitStatus;
    private int[][] adjGraph;
    private Queue<String> bfs=new LinkedList<String>();
    private Stack<String> dfs=new Stack<String>();
    private SecureRandom randomer=new SecureRandom();
    private int counter=0;
    private int length;

    public Graph(int length){
        this.length=length;
        inputVertex=new String[length];
        visitStatus=new boolean[length];
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

    private int getIndex(String query){
        int index=0;
        while(index<counter){
            if(inputVertex[index]==query){
                break;
            }
            ++index;
        }
        return index;
    }

    private String getNode(int query){
        String node=inputVertex[query];
        return node;
    }

    public void resetVisit(){
        int index=0;
        while(index<counter){
            visitStatus[index]=false;
            ++index;
        }
    }

    private boolean isAllVisited(){
        boolean stats=true;
        int index=0;
        while(index<counter){
            if(!visitStatus[index++]){
                stats=false;
                break;
            }
        }
        return stats;
    }

    public void addVertex(String vertex){
        inputVertex[counter++]=vertex;
    }

    public void addEdge(String node1,String node2){
        int index1=getIndex(node1);
        int index2=getIndex(node2);
        int range=randomer.nextInt(10);
        if(range==0){
            range=randomer.nextInt(10);
        }
        adjGraph[index1][index2]=range;
        adjGraph[index2][index1]=range;
    }

    public void showVertex(){
        for(String e: inputVertex){
            if(e!=null){
                System.out.print(e+" ");
            }
        }
        System.out.println();
    }

    public void showEdges(){
        int[][] temp=new int[length][length];
        for(int row=0;row<counter;row++){
            for(int col=0;col<counter;col++){
                temp[row][col]=adjGraph[row][col];
            }
        }
        for(int row=0;row<counter;row++){
            for(int col=0;col<counter;col++){
                if(temp[row][col]!=1000000 && row!=col){
                    temp[col][row]=1000000;
                    System.out.print(getNode(row)+"-"+getNode(col)+" ");
                }
            }
        }
        System.out.println();
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