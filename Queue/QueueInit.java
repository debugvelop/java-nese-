public class QueueInit extends Kuewe{
    private int[] queue;
    private int length,first=0,last=-1,n=0;

    public QueueInit(int length){
        this.length=length;
        queue=new int[length];
        this.x=0;
        this.y=0;
    }

    public void enqueue(int query){
        queue[x++]=query;
    }

    public int dequeue(){
        return queue[y++];
    }

    public 
}