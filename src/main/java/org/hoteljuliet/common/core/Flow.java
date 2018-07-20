package org.hoteljuliet.common.core;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Flow {

    private List<Chain> chains = new ArrayList<>();

    /**
     *
     */
    public Flow() {
        chains = new ArrayList<>();
    }

    /**
     *
     * @param chain
     */
    public void addChain(Chain chain) {
        chains.add(chain);
    }

    /**
     *
     * @param context
     * @return
     * @throws Exception
     */
    boolean execute(Context context) throws RuntimeException {

        boolean processingComplete = false;

        // in forward order, call the execute method
        for (Chain chain : chains) {
            processingComplete = chain.execute(context);

            if (!processingComplete) {
                throw new IllegalStateException("The Chain \"" + chain.getName() + "\" ended but did not completely process the context");
            }
        }

        return processingComplete;
    }
}
