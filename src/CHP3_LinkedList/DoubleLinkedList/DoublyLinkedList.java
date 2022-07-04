package CHP3_LinkedList.DoubleLinkedList;



public class DoublyLinkedList {
    DoubleLinkedListNode head;
    DoubleLinkedListNode tail;
    private int length;

    public DoublyLinkedList(){
        this.head=new DoubleLinkedListNode(Integer.MIN_VALUE,null,null);
        this.tail=new DoubleLinkedListNode(Integer.MAX_VALUE,head,null);
        head.setNextPointer(tail);
        this.length=0;
    }

    //position
    public int getPosition(int data){
        DoubleLinkedListNode temp=head;
        int position=0;
        while (temp!=null){
            if(temp.getData()==data){
                return position;
            }
            position++;
            temp=temp.getNextPointer();
        }
        return Integer.MIN_VALUE;
    }

    // traverse the list
    public String toSting(){
        String result="[";
        if(head.getNextPointer()==tail){
            return result+"]";
        }
        result+=head.getNextPointer().getData();
        DoubleLinkedListNode temp=head.getNextPointer().getNextPointer();
        while(temp!=tail){
            result=result+","+temp.getData();
            temp=temp.getNextPointer();
        }
        return result+"]";
    }

    //get head
    public synchronized void getHead(){
        if(head.getNextPointer()!=tail){
            System.out.println(head.getNextPointer().getData());
            return ;
        }
        System.out.println("Empty list");
    }

    //get tail
    public synchronized void getTail(){
    if(tail.getPreviousPointer()!=head){

        System.out.println(tail.getPreviousPointer().getData());
        return;
    }
        System.out.println("Empty List");
    }


    //Insert Operation
    // 1 Insert at the start
    public synchronized void insertAtStart(int value){
        if(length==0){
            DoubleLinkedListNode data=new DoubleLinkedListNode(value,head,tail);
            head.setNextPointer(data);
            tail.setPreviousPointer(data);
            length++;
            return;
        }
        DoubleLinkedListNode data=new DoubleLinkedListNode(value,head,head.getNextPointer());
        head.getNextPointer().setPreviousPointer(data);
        head.setNextPointer(data);

        length++;
    }

    //2 Insert at the end
    public synchronized void insertAtTheEnd(int value){
        if(length==0){
            DoubleLinkedListNode data=new DoubleLinkedListNode(value,head,tail);
            head.setNextPointer(data);
            tail.setPreviousPointer(data);
            length++;
            return;

        }
        DoubleLinkedListNode data=new DoubleLinkedListNode(value,tail.getPreviousPointer(),tail);
        tail.getPreviousPointer().setNextPointer(data);
        tail.setPreviousPointer(data);
        length++;

    }

    //3 Insert at the given position
    public synchronized void insertAtPosition(int value,int position){
        if(position+1<0){
            System.out.println("provide appropriate position");
            return;
        }
        if(position+1>length){
            position=length;

        }
        if(length==0){
            DoubleLinkedListNode data=new DoubleLinkedListNode(value,head,tail);
            head.setNextPointer(data);
            tail.setPreviousPointer(data);
            length++;
            return;
        }

        DoubleLinkedListNode prevNode=head;
        for(int i=1;i<position+1;i++){
            prevNode=prevNode.getNextPointer();
        }
        if(prevNode.getNextPointer()==tail){
            DoubleLinkedListNode data=new DoubleLinkedListNode(value,prevNode,tail);
            prevNode.setNextPointer(data);
            tail.setPreviousPointer(data);
            length++;
            return;
        }

        DoubleLinkedListNode data=new DoubleLinkedListNode(value,prevNode,prevNode.getNextPointer());
        prevNode.getNextPointer().setPreviousPointer(data);
        prevNode.setNextPointer(data);
        length++;

    }

    //Delete Operation
    // 1 Delete from start
    public synchronized void deleteFromStart(){
        if(length==0){
            System.out.println("List is Empty");
            return;
        }
        if (length>=2){
            DoubleLinkedListNode temp=head.getNextPointer();
            head.getNextPointer().getNextPointer().setPreviousPointer(head);
            head.setNextPointer(head.getNextPointer().getNextPointer());
            System.out.println("Deleted Node: "+temp.getData());
            temp=null;
            length--;
            return;

        }
        DoubleLinkedListNode temp=head.getNextPointer();

        head.setNextPointer(tail);
        tail.setPreviousPointer(head);
        System.out.println("Deleted Node: "+temp.getData());
        temp=null;
        length--;
    }

    //2 Delete from end
    public synchronized void deleteFromEnd(){
        if(length==0){
            System.out.println("List is Empty");
            return;
        }
        if(length>=2){
           DoubleLinkedListNode temp=tail.getPreviousPointer();
            tail.getPreviousPointer().getPreviousPointer().setNextPointer(tail);
            tail.setPreviousPointer(tail.getPreviousPointer().getPreviousPointer());
            System.out.println("Deleted Node: "+temp.getData());
            temp=null;
            length--;
            return;
        }
        DoubleLinkedListNode temp=tail.getPreviousPointer();
        tail.setPreviousPointer(head);
        head.setNextPointer(tail);
        System.out.println("Deleted Node: "+temp.getData());
        temp=null;
        length--;
    }

    //3 Delete from given location
    public synchronized void deleteFromGivenPosition(int position){

        if(length==0){
            System.out.println("List is empty");
            return;
        }
        if(position+1>length || position+1<0){
            System.out.println("Please provide appropriate position");
            return;
        }
        DoubleLinkedListNode temp=head;
        for(int i=1;i<position+1;i++){
            temp=temp.getNextPointer();
        }

        DoubleLinkedListNode temp2=temp.getNextPointer();
        temp.setNextPointer(temp2.getNextPointer());
        temp2.getNextPointer().setPreviousPointer(temp);
        System.out.println("Deleted Node: "+temp2.getData());
        temp2=null;
        length--;
    }

    //4 Delete my matching the data
    public synchronized void deleteMatchedData(int value){
        if(length==0){
            System.out.println("List is empty");
            return;
        }
        DoubleLinkedListNode prevNode=head,currentNode;
        while ((currentNode=prevNode.getNextPointer())!=tail){
            if(currentNode.getNextPointer()!=tail){
                if(currentNode.getData()==value){

                    prevNode.setNextPointer(currentNode.getNextPointer());
                    currentNode.getNextPointer().setPreviousPointer(currentNode.getPreviousPointer());
                    System.out.println("Deleted Node: "+currentNode.getData());
                    currentNode=null;
                    length--;
                    return;
                }

            }
            if(currentNode.getData()==value){
                prevNode.setNextPointer(tail);
                tail.setPreviousPointer(prevNode);
                System.out.println("Deleted Node: "+currentNode.getData());
                currentNode=null;
                length--;
                return;

            }
            prevNode=currentNode;
        }
        System.out.println("Not Found!");

    }

    //5 delete entire list
    public synchronized void deleteList(){
        head.setNextPointer(tail);
        tail.setPreviousPointer(head);
        length=0;
        System.out.println("Deleted Your list!");

    }

    public static void main(String[] args) {
        DoublyLinkedList myList=new DoublyLinkedList();
       myList.insertAtStart(4);
       myList.insertAtStart(3);
       myList.insertAtStart(2);
        myList.insertAtStart(1);
        myList.insertAtTheEnd(5);
        myList.insertAtTheEnd(6);
        myList.insertAtTheEnd(7);
        myList.insertAtTheEnd(8);
       myList.insertAtPosition(00,2);
        myList.insertAtPosition(00,9);
        myList.insertAtPosition(00,0);


        //Delete
       myList.deleteFromStart();
       myList.deleteFromStart();
        myList.deleteFromEnd();
        myList.deleteFromGivenPosition(0);
        myList.deleteFromGivenPosition(1);
        myList.deleteFromGivenPosition(5);
      myList.deleteMatchedData(5);
      myList.deleteMatchedData(8);
      myList.deleteMatchedData(0);
        myList.deleteMatchedData(7);
        //myList.deleteMatchedData(4);
        //myList.deleteMatchedData(6);
        myList.deleteList();
        System.out.println(myList.length);
        System.out.println(myList.toSting());
        myList.getHead();
        myList.getTail();
    }
}
