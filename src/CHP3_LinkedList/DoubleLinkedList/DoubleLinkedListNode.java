package CHP3_LinkedList.DoubleLinkedList;
//Type Declaration of DoublyLinkedList
public class DoubleLinkedListNode {
    private int data;
    private DoubleLinkedListNode previousPointer;
    private DoubleLinkedListNode nextPointer;

    //constructor
    public DoubleLinkedListNode(int data){
        this.data=data;
        previousPointer=null;
        nextPointer=null;
    }

    public DoubleLinkedListNode(int data,DoubleLinkedListNode previousPointer,DoubleLinkedListNode nextPointer){
        this.data=data;
        this.previousPointer=previousPointer;
        this.nextPointer=nextPointer;
    }

    public int getData(){
        return this.data;
    }
    public DoubleLinkedListNode getPreviousPointer(){
        return previousPointer;
    }

    public DoubleLinkedListNode getNextPointer(){
        return nextPointer;
    }

    public void setData(int data){
        this.data=data;
    }
    public void setPreviousPointer(DoubleLinkedListNode where){
        this.previousPointer=where;
    }

    public void setNextPointer(DoubleLinkedListNode where){
        this.nextPointer=where;
    }
}
