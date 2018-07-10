package com.el.lottery;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Danfeng
 * @since 2018/7/3
 */
public class AliasMethod {
    /* The random number generator used to sample from the distribution. */
    private final Random random;

    /* The probability and alias tables. */
    private final int[] alias;
    private final double[] probability;

    /**
     * Constructs a new AliasMethod to sample from a discrete distribution and
     * hand back outcomes based on the probability distribution.
     * <p/>
     * Given as input a list of probabilities corresponding to outcomes 0, 1,
     * ..., n - 1, this constructor creates the probability and alias tables
     * needed to efficiently sample from this distribution.
     *
     * @param probabilities The list of probabilities.
     */
    public AliasMethod(List<Double> probabilities) {
        this(probabilities, new Random());
    }

    /**
     * Constructs a new AliasMethod to sample from a discrete distribution and
     * hand back outcomes based on the probability distribution.
     * <p/>
     * Given as input a list of probabilities corresponding to outcomes 0, 1,
     * ..., n - 1, along with the random number generator that should be used
     * as the underlying generator, this constructor creates the probability
     * and alias tables needed to efficiently sample from this distribution.
     *
     * @param probabilities The list of probabilities.
     * @param random        The random number generator
     */
    public AliasMethod(List<Double> probabilities, Random random) {
        /* Begin by doing basic structural checks on the inputs. */
        if (probabilities == null || random == null)
            throw new NullPointerException();
        if (probabilities.size() == 0)
            throw new IllegalArgumentException("Probability vector must be nonempty.");

        /* Allocate space for the probability and alias tables. */
        probability = new double[probabilities.size()];
        alias = new int[probabilities.size()];

        /* Store the underlying generator. */
        this.random = random;

        /* Compute the average probability and cache it for later use. */
        final double average = 1.0 / probabilities.size();

        /* Make a copy of the probabilities list, since we will be making
         * changes to it.
         */
        probabilities = new ArrayList<>(probabilities);

        /* Create two stacks to act as worklists as we populate the tables. */
        Stack<Integer> small = new Stack<>();
        Stack<Integer> large = new Stack<>();

        /* Populate the stacks with the input probabilities. */
        for (int i = 0; i < probabilities.size(); ++i) {
            /* If the probability is below the average probability, then we add
             * it to the small list; otherwise we add it to the large list.
             */
            if (probabilities.get(i) >= average)
                large.push(i);
            else
                small.push(i);
        }

        /* As a note: in the mathematical specification of the algorithm, we
         * will always exhaust the small list before the big list.  However,
         * due to floating point inaccuracies, this is not necessarily true.
         * Consequently, this inner loop (which tries to pair small and large
         * elements) will have to check that both lists aren't empty.
         */
        while (!small.isEmpty() && !large.isEmpty()) {
            /* Get the index of the small and the large probabilities. */
            int less = small.pop();
            int more = large.pop();

            /* These probabilities have not yet been scaled up to be such that
             * 1/n is given weight 1.0.  We do this here instead.
             */
            probability[less] = probabilities.get(less) * probabilities.size();
            alias[less] = more;

            /* Decrease the probability of the larger one by the appropriate
             * amount.
             */
            probabilities.set(more,
                (probabilities.get(more) + probabilities.get(less)) - average);

            /* If the new probability is less than the average, add it into the
             * small list; otherwise add it to the large list.
             */
            if (probabilities.get(more) >= 1.0 / probabilities.size())
                large.add(more);
            else
                small.add(more);
        }

        /* At this point, everything is in one list, which means that the
         * remaining probabilities should all be 1/n.  Based on this, set them
         * appropriately.  Due to numerical issues, we can't be sure which
         * stack will hold the entries, so we empty both.
         */
        while (!small.isEmpty())
            probability[small.pop()] = 1.0;
        while (!large.isEmpty())
            probability[large.pop()] = 1.0;
    }

    /**
     * Samples a value from the underlying distribution.
     *
     * @return A random value sampled from the underlying distribution.
     */
    public int next() {
        /* Generate a fair die roll to determine which column to inspect. */
        int column = random.nextInt(probability.length);

        /* Generate a biased coin toss to determine which option to pick. */
        boolean coinToss = random.nextDouble() < probability[column];

        /* Based on the outcome, return either the column or its alias. */
       /* Log.i("1234","column="+column);
        Log.i("1234","coinToss="+coinToss);
        Log.i("1234","alias[column]="+coinToss);*/
        return coinToss ? column : alias[column];
    }

    public int[] getAlias() {
        return alias;
    }

    public double[] getProbability() {
        return probability;
    }

    public static void main(String[] args) {
        TreeMap<String, Double> map = new TreeMap<>();

        map.put("1-2", 0.25);
        map.put("2-3", 0.2);
        map.put("3-5", 0.1);
        map.put("5-10", 0.05);
        map.put("0.01-1", 0.4);

        List<Double> list = new ArrayList<>(map.values());
        List<String> gifts = new ArrayList<>(map.keySet());

        AliasMethod method = new AliasMethod(list);
        for (double value : method.getProbability()){
            System.out.println("," + value);
        }

        for (int value : method.getAlias()){
            System.out.println("," + value);
        }

        Map<String, AtomicInteger> resultMap = new HashMap<>();

        for (int i = 0; i < 100000; i++) {
            int index = method.next();
            String key = gifts.get(index);
            if (!resultMap.containsKey(key)) {
                resultMap.put(key, new AtomicInteger());
            }
            resultMap.get(key).incrementAndGet();
        }
        for (String key : resultMap.keySet()) {
            System.out.println(key + "==" + resultMap.get(key));
        }

    }

}
