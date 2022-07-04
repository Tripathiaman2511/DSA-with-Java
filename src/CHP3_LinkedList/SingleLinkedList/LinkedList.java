package CHP3_LinkedList.SingleLinkedList;
//Type Declaration of LinkedList
class ListNode{
     int data;
     ListNode next;
    public ListNode(int data){
        this.data=data;

    }
    public void setData(int data){
        this.data=data;
    }

    public int getData(){
        return this.data;

    }

    public void setNext(ListNode next){
        this.next=next;
    }

    public ListNode getNext(){
        return this.next;
    }
}

public class LinkedList {
    ListNode head;
    private int length;


    //Default Constructor
    public LinkedList(){
        this.length=0;this.head=null;
    }

    //Return first node/head in the list
    public synchronized int getHead(){
        return head.data;
    }

    //to return string representation of this collection
    public String toSting(){
        String result="[";
        if(head==null) return result+"]";
        result+=head.data;
        ListNode temp=head.next;
        while(temp!=null){
            result=result+","+temp.data;
            temp=temp.next;
        }
        return result+"]";
    }

    //return length of the string
    public int getLength(){
        return length;
    }

    //to find position of the data
    public int getPosition(int data){
        ListNode temp=head;
        int position=0;
        while(temp!=null){
            if(temp.data==data){
                return position;
            }
            position++;
            temp=temp.next;

        }
        //return some large value
        return Integer.MIN_VALUE;

    }

    //Insert a node at the beginning of the list
    public synchronized void insertAtStart(ListNode node){
        if(head==null){
            head=node;
            length++;
            return;
        }
        node.next=head;
        head=node;
        length++;
    }

    //Insert a node at the end of the list
    public synchronized void insertAtEnd(ListNode node){
        if(head==null){
            head=node;
        }
        else{
            ListNode lastNodeNextPointer,NewNodeNextPointer;
            for(lastNodeNextPointer=head;(NewNodeNextPointer=lastNodeNextPointer.next)!=null;lastNodeNextPointer=NewNodeNextPointer);
            lastNodeNextPointer.next=node;

        }
        length++;
    }

    //add a new value to the  list at a given position.
    public synchronized void insertAtGivenPosition(int data,int position){
        //fix the position if position is less than zero or greater then length
        if(position<0) position=0;
        if(position>=length) position=length;

        //if the list is empty, make it be the only element
        if(head==null){
            head=new ListNode(data);

        }

        //if adding at front of the list
        if(position==0){
            ListNode temp=new ListNode(data);
            temp.next=head;
            head=temp;
        }
        //else find the correct position and add at that position
        else{
            ListNode temp=head;
            for(int i=1;i<position;i++){
                temp=temp.next;
            }
            ListNode newNode=new ListNode(data);
            newNode.next=temp.next;
            temp.next=newNode;
        }
        length++;
    }

    //Delete Node from the Beginning
    public synchronized void deleteFromStart(){
        if(head==null) {
            System.out.println("no data found");
            return;
        }
        ListNode temp=head;
        head=temp.next;
        temp.next=null;
        length--;
        System.out.println("Deleted Node: "+temp.data);


    }

    //delete node from the end
    public synchronized void deleteFromEnd(){
        if(head==null) {
            System.out.println("List is empty");
            return;
        }

       ListNode currentNode=head,prevNode=null,next=head.next;
       if(next==null){
           head=null;
           length--;
           System.out.println("Deleted Node: "+currentNode.data);
           return;
       }
       while((next=currentNode.next)!=null){
           prevNode=currentNode;
           currentNode=next;

       }
       prevNode.next=null;
       length--;
        System.out.println("Deleted Node: "+currentNode.data);

    }

    //remove a node at a given position
    public synchronized void deleteFromGivenPosition(int position){
        //fix the position
        if(position>length || position<0){
            System.out.println("Please provide appropriate position");
            return;
        }

        //if list is empty
        if(head==null) {
            System.out.println("List is empty");
            return;
        }

        //if position at head
        if(position==0) {

            ListNode temp=head;
            //check if next node is empty or not
            if(temp.next!=null){
                head=temp.next;
                temp.next=null;
                length--;
                System.out.println("Deleted Node: "+temp.data);
                return;
            }

            head=null;
            length--;
            System.out.println("Deleted Node: "+temp.data);

        }
        else{
            ListNode temp=head;
            for(int i=1;i<position;i++){
                temp=temp.next;
            }
            ListNode temp2=temp.next;
            temp.next=temp2.next;
            temp2.next=null;
            length--;
            System.out.println("Deleted Node: "+temp2.data);

        }

    }

    //to remove matched node
    public synchronized void removeMatched(ListNode node){
        if(head==null) {
            System.out.println("List is empty");
            return;
        }
        if(node.data==head.data){
            ListNode temp=head;
            head=head.next;
            length--;
            System.out.println("Deleted Node: "+temp.data);
            return;
        }
        ListNode prevNode=head,currNode;
        while ((currNode=prevNode.next)!=null){
            if(node.data==currNode.data){
                prevNode.next=currNode.next;
                length--;
                System.out.println("Deleted Node: "+currNode.data);
                return;
            }
            prevNode=currNode;
        }
        //if no match found return null
        System.out.println("No match found");
    }



    //to delete everything from the list
    public void clearList(){
        if(head==null) {
            System.out.println("List is Empty Already");
            return;
        }
        head=null;
        length=0;
        System.out.println("List Deleted");
        System.out.println(toSting());
    }

    public static void main(String[] args) {
        LinkedList mylist=new LinkedList();
        //Insert Statements
        mylist.insertAtStart(new ListNode(1));
        mylist.insertAtStart(new ListNode(2));
        mylist.insertAtStart(new ListNode(3));
        mylist.insertAtStart(new ListNode(4));
        mylist.insertAtStart(new ListNode(5));
        mylist.insertAtEnd(new ListNode(2));
        mylist.insertAtEnd(new ListNode(3));
        mylist.insertAtGivenPosition(12,3);
        mylist.insertAtGivenPosition(12,3);
        System.out.println(mylist.toSting());

        mylist.deleteFromStart();
        mylist.deleteFromStart();
        mylist.deleteFromStart();
        mylist.deleteFromEnd();
        mylist.deleteFromGivenPosition(3);
        mylist.deleteFromGivenPosition(6);
        mylist.deleteFromGivenPosition(0);
        mylist.deleteFromGivenPosition(-1);
        mylist.removeMatched(new ListNode(12));
        mylist.removeMatched(new ListNode(0));
        //Delete Statement
        System.out.println("Head-> "+mylist.getHead());
        System.out.println(mylist.toSting());
        System.out.println("Length= "+mylist.getLength());
        mylist.clearList();


    }
}

