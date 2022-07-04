package CHP2_RecursionAndBacktracking;

public class Factorial {
    public long factorial(long number){
        if(number<=1) return 1;
        return number*factorial(number-1);

    }

    public static void main(String[] args) {
        Factorial fibo=new Factorial();
        for(int counter=0;counter<=10;counter++){
            System.out.println(counter+"="+fibo.factorial(counter));
        }
    }
}
