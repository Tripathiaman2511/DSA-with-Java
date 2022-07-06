package CHP3_LinkedList.CircularLinkedList;



public class CircularLinkedList {
   CircularLinkedListNode head;
    private int length;


    public CircularLinkedList(){
        head=new CircularLinkedListNode(Integer.MIN_VALUE);
        head.setNextPointer(head);
        length=0;
    }

    public void getHead(){
        if (head.getNextPointer() == head) {
            System.out.println("List is Empty");
            return;
        }
        System.out.println("Head-> "+head.getNextPointer().getData());

    }
    public String toString(){
        String result="[";
        if(head.getNextPointer()==head) return result+"]";
        result+=head.getNextPointer().getData();
        CircularLinkedListNode temp=head.getNextPointer().getNextPointer();
        while(temp!=head){
            result=result+","+temp.getData();
            temp=temp.getNextPointer();
        }
        return result+"]";
    }

    public int getLength() {
        return length;
    }

    //Insert Operation
    public synchronized void insertAtStart(int value){
        CircularLinkedListNode data1=new CircularLinkedListNode(value);
        data1.setNextPointer(data1);

        if(head.getNextPointer()==head){
            data1.setNextPointer(head);
            head.setNextPointer(data1);
            length++;
            return;
        }
        data1.setNextPointer(head.getNextPointer());
        head.setNextPointer(data1);
        length++;

    }
    public synchronized void insertAtEnd(int value){
        CircularLinkedListNode data=new CircularLinkedListNode(value);
        data.setNextPointer(data);
        if(head.getNextPointer()==head){
            data.setNextPointer(head);
            head.setNextPointer(data);
            length++;
            return;
        }
        CircularLinkedListNode temp=head.getNextPointer(),prevNode,currentNode;
        for(prevNode=temp.getNextPointer();(currentNode=prevNode.getNextPointer())!=head;prevNode=currentNode);
        data.setNextPointer(currentNode);
        prevNode.setNextPointer(data);
        length++;



    }
    public synchronized void insertAtPosition(int value,int position) {
        int actualPosition=position+1;
        CircularLinkedListNode data = new CircularLinkedListNode(value);
        data.setNextPointer(data);

        if (actualPosition<= 0) {
            System.out.println("Please provide appropriate position");
            return;
        }
        if(actualPosition>length){
            System.out.println("length: "+length+"\nActual Position: "+actualPosition+"\nData: "+data.getData());
            System.out.println("Inserting "+data.getData()+" at the end of the list");
            System.out.println();
            actualPosition=length+1;
        }

        CircularLinkedListNode temp=head;
        for(int i=1;i<actualPosition;i++){
            temp=temp.getNextPointer();
        }
        if(temp.getNextPointer()==head){
            temp.setNextPointer(data);
            data.setNextPointer(head);
            length++;
            return;
        }
        data.setNextPointer(temp.getNextPointer());
        temp.setNextPointer(data);
        length++;

    }

    //Delete Operation
    public synchronized void deleteFromStart(){
        if(length==0){
            System.out.println("List is Empty");
        return;
        }

        CircularLinkedListNode prevNode=head.getNextPointer();

            head.setNextPointer(prevNode.getNextPointer());
            System.out.println("Deleted Node From Start: "+prevNode.getData());
            prevNode=head;
            length--;
    }
    public synchronized void deletFromEnd(){
        if(length==0){
            System.out.println("List is empty");
            return;
        }
        CircularLinkedListNode prevNode=head,currentNode=prevNode.getNextPointer();
        while(currentNode.getNextPointer()!=head){
            prevNode=currentNode;
            currentNode=currentNode.getNextPointer();
        }

        prevNode.setNextPointer(currentNode.getNextPointer());
        System.out.println("Deleted Node From End: "+currentNode.getData());
        currentNode=head;
        length--;






    }
    public synchronized void deltedAtPosition(int position){
        //fix position
        int actualPosition=position+1;
        if(actualPosition<=0){
            System.out.println("Provide proper position");
            return;
        }
        if(length==0){
            System.out.println("List is Empty");
            return;
        }
        if (actualPosition >length) {
            System.out.println("Position is greater than (length-1): "+position+">"+(length-1));
            return;
        }
        CircularLinkedListNode temp=head;
        for(int i=1;i<actualPosition;i++){
            temp=temp.getNextPointer();
        }
        CircularLinkedListNode temp2=temp.getNextPointer();
        temp.setNextPointer(temp2.getNextPointer());
        System.out.println("Deleted Node from position "+position+" : "+temp2.getData());
        temp2=null;
        length--;

    }
    public synchronized void removeMatchedData(int value){
        if(length==0){
            System.out.println("List is Empty");
            return;
        }
        CircularLinkedListNode prevNode=head,currenNode;
        while((currenNode=prevNode.getNextPointer())!=head){
            if(currenNode.getData()==value){
                prevNode.setNextPointer(currenNode.getNextPointer());
                System.out.println("Deleted Node: "+currenNode.getData());
                currenNode=null;
                length--;
                return;
            }
            prevNode=currenNode;
        }
        System.out.println("No match found!");
    }

    public synchronized void deleteList(){
        head.setNextPointer(head);
        length=0;

    }

    public static void main(String[] args) {
        CircularLinkedList myList=new CircularLinkedList();
        myList.insertAtStart(1);
        myList.insertAtStart(2);
        myList.insertAtEnd(3);
        myList.insertAtPosition(4,5);
        myList.insertAtPosition(5,4);
        myList.insertAtPosition(11,4);
        myList.insertAtPosition(22,5);
        myList.insertAtEnd(66);
        myList.insertAtStart(100);
        myList.insertAtPosition(11,0);
        myList.deleteFromStart();
        myList.deletFromEnd();
        myList.deltedAtPosition(2);
        myList.deltedAtPosition(0);
        myList.deltedAtPosition(6);
        myList.deltedAtPosition(5);
        myList.removeMatchedData(4);
        myList.removeMatchedData(4);
        myList.deleteList();
        myList.getHead();
        System.out.println("Length: "+myList.getLength());
      System.out.println("List: "+ myList);
    }

}
