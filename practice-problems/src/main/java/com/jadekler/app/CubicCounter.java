package com.jadekler.app;

/**
 * This class looks at how many paths there are from 0,0 to n,n in an nxn matrix
 *
 */
public class CubicCounter {
    int count;

    public static void main(String[] args) {
        CubicCounter cc = new CubicCounter();

        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.println(i+"x"+j+": "+cc.countPermutations(i,j));
                System.out.println(i+"x"+j+": "+cc.combinatorialCalc(i,j));
            }
        }
    }

    /**
     * Using combinatorial algorithm C(n+k,k)
     * NOTE: We are simplifying as such: C(n+k,k) = (n+k)!/[k!n!]
     */
    public long combinatorialCalc(int n, int k) {
        return this.factorial(n+k,1)/(this.factorial(k,1)*this.factorial(n,1));
    }

    public int countPermutations(int n, int k) {
        this.count = 0;
        countPermutations(0, 0, n, k);
        return this.count;
    }

    public void countPermutations(int n, int k, int max_n, int max_k) {
        if (n == max_n && k == max_k) {
            this.count += 1;
        }

        if (n < max_n) {
            countPermutations(n+1, k, max_n, max_k);
        }

        if (k < max_k) {
            countPermutations(n, k+1, max_n, max_k);
        }
    }

    /**
     * Raises 2 to the power of n. I know there is a math function for this, but I'm on a plane to SF and forgot where the 
     * math library is (and, frankly, the function name. expr()? exp()? i'll just make my own.. :) )
     * @param  n Power to raise 2 by
     * @return   2^n
     */
    public int exp2(int n) {
        if (n == 0) {
            return 1;
        }

        return 2<<(n-1);
    }

    /**
     * As with exp2, I don't know where the math lib is so I'm just writing my own
     * @param  n      Number to begin factorial at
     * @param  n_stop Number to end factorial at
     * @return        Returns n*n-1*n-2*...*n-n_stop+1. Set n_stop = 1 for n!
     */
    public long factorial(int n, int n_stop) {
        long product = 1;

        while (n >= n_stop) {
            product *= n;
            n--;
        }

        return product;
    }
}