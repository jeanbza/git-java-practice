import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jadekler on 1/12/15.
 */
public class CachedFactorizer {
    private BigInteger lastNumber;
    private ArrayList<BigInteger> lastFactors;
    private long cacheHits, hits;

    public static void main(String[] args) {
        CachedFactorizer cachedFactorizer = new CachedFactorizer();

        ArrayList<BigInteger> operateValue = cachedFactorizer.operate(BigInteger.valueOf(11));
        System.out.println(operateValue);
    }

    public ArrayList<BigInteger> operate(BigInteger i) {
        ArrayList<BigInteger> factors = new ArrayList<>();

        synchronized (this) {
            ++hits;

            if (i.equals(lastNumber)) {
                ++cacheHits;
                factors = (ArrayList<BigInteger>)lastFactors.clone();
            }
        }

        if (factors == null) {
            // This should actually be factors.add(factor(i)), but don't want to implement factor
            // for this small demo
            BigInteger someValue = BigInteger.valueOf(17L);
            factors.add(i.multiply(someValue));

            synchronized (this) {
                lastNumber = i;
                lastFactors = (ArrayList<BigInteger>)factors.clone();
            }
        }

        return factors;
    }
}
