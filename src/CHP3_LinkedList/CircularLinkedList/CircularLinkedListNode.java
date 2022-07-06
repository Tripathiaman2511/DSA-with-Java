package CHP3_LinkedList.CircularLinkedList;

public class CircularLinkedListNode {
    private int data;
    private CircularLinkedListNode nextPointer;

    public CircularLinkedListNode(int data){
        this.data=data;
    }

    public CircularLinkedListNode(int data,CircularLinkedListNode nextPointer){
        this.data=data;
        this.nextPointer=nextPointer;
    }
    public void setNextPointer(CircularLinkedListNode where){
        this.nextPointer=where;
    }

    public int getData(){
        return this.data;
    }

    public CircularLinkedListNode getNextPointer(){
        return this.nextPointer;
    }


}
