public class Kuewe{
    public static void main(String[] args){
        QueueInit myqueue=new QueueInit(10);
        for(int x=0;x<10;x++){
            int y=(x+1)*(x+1);
            myqueue.enqueue(y);
        }
        for(int x=0;x<10;x++){
            System.out.print(myqueue.dequeue()+" ");
        }
    }
}