package CHP1_complexity;

public class Fibo {
    public static void main(String[] args) {
        System.out.println(formula(50));
    }
    static int formula(int n){
        return (int)((Math.pow((1+Math.sqrt(5))/2,n)-Math.pow((1-Math.sqrt(5))/2,n))/Math.sqrt(5));

    }
    static int fibo (int n){
        if(n<2) return n;
        return fibo(n-1)+fibo(n-2);
    }
}
