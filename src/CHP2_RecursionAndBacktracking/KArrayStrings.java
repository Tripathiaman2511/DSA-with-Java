package CHP2_RecursionAndBacktracking;

import java.util.Arrays;

public class KArrayStrings {
    int []A;
    public KArrayStrings(int n){
        this.A=new int[n];
    }
    public void KStrings(int n,int k){
        if(n<=0){
            System.out.println(Arrays.toString(A));
        }
        else{
            for(int j=0;j<k;j++){
                A[n-1]=j;
                KStrings(n-1,k);
            }
        }
    }

    public static void main(String[] args) {
        int n=4;
        KArrayStrings KS=new KArrayStrings(n);
        KS.KStrings(n,3);
    }
}
