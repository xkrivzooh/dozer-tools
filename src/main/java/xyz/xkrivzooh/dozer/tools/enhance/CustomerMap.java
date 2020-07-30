package xyz.xkrivzooh.dozer.tools.enhance;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface CustomerMap extends Reader<String, Map<String, Object>> {

    @Override
    Object get(String key);

    void put(String key, Object value);

    /**
     * 之所以搞这个putToList是现在的方式，在CustomConverter的existingDestinationFieldValue参数中拿不对当前的值，
     * 所以变相实现
     */
    void putToList(String key, List<Object> newItems);

    /**
     * 之所以搞这个putToSet是现在的方式，在CustomConverter的existingDestinationFieldValue参数中拿不对当前的值，
     * 所以变相实现
     */
    void putToSet(String key, Set<Object> newItems);
}
