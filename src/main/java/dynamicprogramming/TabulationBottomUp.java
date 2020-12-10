package dynamicprogramming;

public class TabulationBottomUp {

    public int fibonacci(int n){
        int[] fibo = new int[n+1];
        fibo[0] = 1;
        fibo[1] = 1;
        for(int i=2; i<n+1; i++){
            fibo[i] = fibo[i-1]+fibo[i-2];
            /*
            Here f(4) and f(5) would be ready while f(6) is about to start it's calculations.
            Hence it's bottom up.
             */
        }
        return fibo[n];
    }
}
