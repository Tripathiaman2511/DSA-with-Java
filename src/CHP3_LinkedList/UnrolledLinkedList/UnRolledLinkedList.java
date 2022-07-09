package CHP3_LinkedList.UnrolledLinkedList;


import java.util.Arrays;

public class UnRolledLinkedList {

    private int nodeCapacity;
    private int length;
    UnRolledLinkedListNode head;

    UnRolledLinkedList(int nodeCapacity){
        head=new UnRolledLinkedListNode();
        this.nodeCapacity=nodeCapacity;
        length=0;
    }
    public synchronized void shiftOperation(UnRolledLinkedListNode currentNode,UnRolledLinkedListNode nextNode){

        if(nextNode==null){
            UnRolledLinkedListNode newNextNode=new UnRolledLinkedListNode(nodeCapacity);
            newNextNode.setNext(null);
            currentNode.setNext(newNextNode);
            newNextNode.setInsideList(currentNode.getLastElement());
            currentNode.removeLastElement();
            length++;
            return;
        }
        if(nextNode.getNumElement()>=nodeCapacity){
            shiftOperation(nextNode,nextNode.getNextPointer());
        }
        nextNode.setInsideList(currentNode.getLastElement());
        currentNode.removeLastElement();

    }

    public synchronized boolean isListEmpty(int value){
        UnRolledLinkedListNode newNode;
        if(length==0){
            newNode=new UnRolledLinkedListNode(nodeCapacity);
            newNode.setNext(null);
            head.setNext(newNode);
            newNode.setInsideList(value);
            length++;
            return true;
        }
        return false;
    }

    public synchronized void insertAtBeginning(int value){
        UnRolledLinkedListNode newNode;
        if(isListEmpty(value)) return;
        newNode=head.getNextPointer();
        if(newNode.getNumElement()>=nodeCapacity){
            shiftOperation(newNode,newNode.getNextPointer());
            newNode.setInsideList(value);
            return;
        }
        newNode.setInsideList(value);
    }

    public synchronized void insertAEnd(int value){
       if(isListEmpty(value)) return;
        UnRolledLinkedListNode prevNode=head,currentNode;
        while ((currentNode=prevNode.getNextPointer())!=null){
            prevNode=currentNode;
        }
        if(prevNode.getNumElement()>=nodeCapacity){
            UnRolledLinkedListNode newNode=new UnRolledLinkedListNode(nodeCapacity);
            prevNode.setNext(newNode);
            newNode.setNext(null);
            newNode.setInsideList(value);
            length++;
            return;
        }
        prevNode.setInsideList(value);
    }

    public synchronized void insertAtIndex(int value,int index){
        int actualPosition=index+1;
        if(isListEmpty(value)) return;
        UnRolledLinkedListNode prevNode=head,currentNode=prevNode.getNextPointer();
        for(int i=1;i<actualPosition;i++){
            prevNode=prevNode.getNextPointer();
            currentNode=prevNode.getNextPointer();
        }
        if(currentNode.getNumElement()>=nodeCapacity){
            shiftOperation(currentNode,currentNode.getNextPointer());
            currentNode.setInsideList(value);
            return;
        }
        currentNode.setInsideList(value);


    }

    public synchronized void deleteFromStart(){
        UnRolledLinkedListNode newNode;
        if(length==0){
            System.out.println("List isEmpty");
            return;
        }
        newNode=head.getNextPointer();
        if(newNode.getNumElement()==1){
            newNode.removeLastElement();
            head.setNext(newNode.getNextPointer());
            newNode.setNext(null);
            length--;
            return;
        }
        newNode.removeLastElement();
    }

    public synchronized void deleteFromEnd(){
        if(length==0){
            System.out.println("List is Empty");
            return;
        }
        UnRolledLinkedListNode prevNode=head,currentNode=prevNode.getNextPointer();
        while (currentNode.getNextPointer()!=null){
            prevNode=currentNode;
            currentNode=currentNode.getNextPointer();
        }
        if(currentNode.getNumElement()==1){
            currentNode.removeLastElement();
            prevNode.setNext(currentNode.getNextPointer());
            currentNode.setNext(null);
            length--;
            return;
        }
        currentNode.removeLastElement();
    }

    public synchronized void deleteFromIndex(int index){
        int actualPosition=index+1;
        if(length==0){
            System.out.println("List is Empty");
            return;
        }
        if(actualPosition<0|| actualPosition>length+1){
            System.out.println("Please Provide proper index");
            return;
        }
        UnRolledLinkedListNode prevNode=head,currentNode=prevNode.getNextPointer();
        for(int i=1;i<actualPosition;i++){
            prevNode=prevNode.getNextPointer();
            currentNode=prevNode.getNextPointer();
        }
        if(currentNode.getNumElement()==1){
            currentNode.removeLastElement();
            prevNode.setNext(currentNode.getNextPointer());
            currentNode.setNext(null);
            length--;
            return;
        }
        currentNode.removeLastElement();
    }

    public synchronized void removematchedElement(int value,int index){
        int actualPosition=index+1;
        if(length==0){
            System.out.println("List is Empty");
            return;
        }
        UnRolledLinkedListNode prevNode=head,currentNode=prevNode.getNextPointer();
        for(int i=1;i<actualPosition;i++){
            prevNode=prevNode.getNextPointer();
            currentNode=prevNode.getNextPointer();
        }
        if(currentNode.getNumElement()==1){
            if(currentNode.removeMatched(value)){
                prevNode.setNext(currentNode.getNextPointer());
                currentNode.setNext(null);
                length--;
                return;
            }
            System.out.println("No Match Found");
            return;
        }
        if(currentNode.removeMatched(value)) return;
        System.out.println("No Match Found");



    }

    public String toString(){
        String result="Head->";
        if(head.getNextPointer()==null) return result+"NULL";
        result+=Arrays.toString(head.getNextPointer().getInsideList());
        UnRolledLinkedListNode temp=head.getNextPointer().getNextPointer();
        while(temp!=null){
            result=result+"->"+ Arrays.toString(temp.getInsideList());
            temp=temp.getNextPointer();
        }
        return result+"->NULL";
    }

    //get number of elements from each node
    public String getNumElements(){
        int [] result=new int[length];
        UnRolledLinkedListNode prevNode=head,currentNode=prevNode.getNextPointer();
        for(int i=0;i<length;i++){
            result[i]=currentNode.getNumElement();
            currentNode=currentNode.getNextPointer();
        }
    return Arrays.toString(result);
    }

    //get length of th list
    public int getLength() {
        return length;
    }

    public static void main(String[] args) {
    UnRolledLinkedList myList=new UnRolledLinkedList(5);
    myList.insertAtBeginning(1);
        myList.insertAtBeginning(2);
        myList.insertAtBeginning(3);
        myList.insertAtBeginning(14);
        myList.insertAtBeginning(15);
       myList.insertAEnd(22);
       myList.insertAEnd(32);
       myList.insertAEnd(88);
       myList.insertAtIndex(33,1);
       myList.deleteFromStart();
       myList.deleteFromEnd();
        myList.deleteFromIndex(1);
        myList.removematchedElement(3,0);

        System.out.println(myList);
        System.out.println(myList.getLength());
        System.out.println(myList.getNumElements());

    }



}
