package queueusingstack;
import java.util.Scanner;
public class QueueUsingStack {
    int queueIn[],queueOut[];
    int queueInTop,queueOutTop;
    
    QueueUsingStack(){
        queueIn=new int[10];
        queueOut=new int[10];
        queueInTop=-1;
        queueOutTop=-1;
    }
    
    public void enqueue(int item){
        if(queueOutTop==-1){
            queueIn[++queueInTop]=item;
        }
        else{
            while(queueOutTop>-1){
                queueIn[++queueInTop]=queueOut[queueOutTop--];
            }
            queueIn[++queueInTop]=item;
        }
    }
    
    public int dequeue(){
        int queueElement=0;
        if(queueOutTop!=-1){
            queueElement=queueOut[queueOutTop--];
        }
        else{
            while(queueInTop>-1){
                queueOut[++queueOutTop]=queueIn[queueInTop--];
            }
            queueElement=queueOut[queueOutTop--];
        }
        return queueElement;
    }
    public static void main(String[] args) {
        Scanner kbd=new Scanner(System.in);
        String input="0";
        QueueUsingStack qs=new QueueUsingStack();
        while(!input.equals("Exit")){
            System.out.println("Enter any integer to enqueue, 'D' to dequeue or 'Exit' to exit: ");
            input=kbd.next();
            switch (input) {
                case "Exit":
                    break;
                case "D":
                    if(qs.queueInTop==-1 && qs.queueOutTop==-1){
                        System.out.println("Queue Empty");
                        continue;
                    }
                    System.out.println("Dequeued item = "+qs.dequeue());
                    break;
                default:
                    try{
                        if(qs.queueInTop==9 || qs.queueOutTop==9){
                        System.out.println("Queue Full");
                        continue;
                        }
                        qs.enqueue(Integer.parseInt(input));
                        break;
                    }
                    catch(Exception e){
                        System.out.println("Invalid Choice");
                    }
            }      
        }
    }
    
}
