package com.jadekler.app;

/**
 * Hello world!
 *
 */
public class CubicCounter {
    int count;

    public static void main(String[] args) {
        CubicCounter cc = new CubicCounter();

        for (int i = 1; i <= 10; i++) {
            System.out.println(i+"x"+i+" "+cc.countPermutations(i,i));
            System.out.println(i+"x"+i+" "+cc.calcPermutations(i,i));
        }
    }

    /**
     * Using the derived formula:
     * if (n=1), 2
     * else 2^(2(n-1))+2(n-1)
     * Perhaps there is a combinatorial way to represent this? Must research more
     */
    public int calcPermutations(int n, int k) {
        // We subtract 1 for the combinatorial identity and 1 for the exponent (e.g. 2^2 == 2<<1)
        if (n == 1) {
            return 2;
        } else {
            return this.exp2(2*(n-1))+2*(n-1);
        }
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
}