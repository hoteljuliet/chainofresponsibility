package org.hoteljuliet.common.core;

import org.hoteljuliet.common.exception.CoRException;
import org.hoteljuliet.common.exception.CoRExceptionType;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Context {

    private Map<String, Object> context;

    /**
     *
     */
    public Context() {
        context = new ConcurrentHashMap<>();
    }

    /**
     *
     * @param key
     * @param value
     */
    public void put(String key, Object value) {
        context.put(key, value);
    }

    /**
     *
     * @param key
     * @param classType
     * @param <T>
     * @return
     * @throws CoRException
     */
    public <T> T get(String key, Class<T> classType) throws CoRException {
        return get(key, classType, true);
    }

    /**
     *
     * @param key
     * @return
     */
    public Boolean contains(String key) {
        return context.containsKey(key);
    }

    /**
     *
     * @param keys
     * @return
     */
    public Boolean containsAll(List<String> keys) {
        Boolean retVal = true;

        for (String key : keys) {
            if (!context.containsKey(key)) {
                retVal = false;
                break;
            }
        }
        return retVal;
    }

    /**
     *
     * @param key
     * @param classType
     * @param required
     * @param <T>
     * @return
     * @throws CoRException
     */
    public <T> T get(String key, Class<T> classType, Boolean required) throws CoRException {
        T value = null;

        if (key != null) {
            if (context.containsKey(key)) {
                Object object = context.get(key);

                if (classType.isInstance(object)) {
                    value = classType.cast(object);
                }
            }
            else {
                if (required) {
                    String message = String.format("No value found for key %s", key);
                    throw new CoRException(message, CoRExceptionType.CONTEXT_VALUE_NOT_FOUND);
                }
            }
        }
        return value;
    }
}
