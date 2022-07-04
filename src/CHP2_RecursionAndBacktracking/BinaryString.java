package CHP2_RecursionAndBacktracking;

import java.util.Arrays;

public class BinaryString {
    int[] A;

    BinaryString(int n){
        this.A=new int[n];

    }
    public void binary(int n){
        if(n<=0) {System.out.println(Arrays.toString(A));}
        else{

            A[n-1]=0;
            binary(n-1);
            A[n-1]=1;
            binary(n-1);
        }

    }

    public static void main(String[] args ) throws java.lang.Exception {
        int n=1;
        BinaryString BS=new BinaryString(n);
        BS.binary(n);
    }
}
