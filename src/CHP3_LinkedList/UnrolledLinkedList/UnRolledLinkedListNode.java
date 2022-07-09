package CHP3_LinkedList.UnrolledLinkedList;

public class UnRolledLinkedListNode {
    UnRolledLinkedListNode next;
    int numElement=0;
    int[] InsideList;

    //For head Node
    UnRolledLinkedListNode(){
      InsideList=null;
      this.next=null;
    }

    //For all Nodes after Head Node
    UnRolledLinkedListNode(int nodeCapacity){
        InsideList=new int[nodeCapacity];
    }

    //Set NextPointer
    public void setNext(UnRolledLinkedListNode next) {
        this.next = next;
    }

    //Get NextPointer
    public UnRolledLinkedListNode getNextPointer() {
        return next;
    }

    //Get List of elements
    public int[] getInsideList() {
        int [] currentlist=new int[numElement];
        for(int i=0;i<numElement;i++){
            currentlist[i]=InsideList[i];
        }
        return currentlist;
    }

    //Get Number of elements inside a node
    public int getNumElement() {
        return numElement;
    }

    //Set Value inside a Node
    public void setInsideList(int value) {
        for(int i=numElement;i>0;i--){
            InsideList[i]=InsideList[i-1];
        }
        InsideList[0]=value;
        numElement++;
    }

    //Get the Last Element
    public int getLastElement(){
        return  InsideList[numElement-1];
    }

    //Remove last Element
    public void removeLastElement(){
        InsideList[numElement-1]=0;
        numElement-=1;
    }

    //Get Particular index
    private int getIndex(int value){
        int index;
        for(int i=0;i<numElement;i++){
            if(InsideList[i]==value){
                index=i;
                System.out.println("Deleted Node: "+InsideList[i]);
                return index;
            }
        }
        return -1;
    }

    //Remove matched Value if any
    public boolean removeMatched(int value){
        int index=getIndex(value);
        if(index==-1) return false;
        for(int i=index;i<numElement-1;i++){
            InsideList[i]=InsideList[i+1];
        }
        removeLastElement();
        return true;
    }

}
