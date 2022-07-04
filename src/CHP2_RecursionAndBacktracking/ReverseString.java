package CHP2_RecursionAndBacktracking;

public class ReverseString {
    public char[] recursiveCall(char[] s,int start,int end){

        if(start>=end)
            return s;
        else{
            char temp=s[start];
            s[start]=s[end];
            s[end]=temp;
            return recursiveCall(s,start+1,end-1);
        }

    }
    public void reverseString(char[] s){


        System.out.println(recursiveCall(s,0,s.length-1));







    }

    public static void main(String[] args) {
        char[] s={'H','a','n','n','a','h'};


        ReverseString rs=new ReverseString();
        rs.reverseString(s);

    }
}
