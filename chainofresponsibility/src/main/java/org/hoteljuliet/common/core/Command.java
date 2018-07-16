package java.org.hoteljuliet.common.core;

public interface Command {
    /**
     *
     * @param context
     * @return
     * @throws RuntimeException
     */
    boolean execute(Context context) throws RuntimeException;

    /**
     *
     * @param context
     * @throws RuntimeException
     */
    void postProcess(Context context) throws RuntimeException;
}
