package xyz.xkrivzooh.dozer.tools.enhance;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.util.CollectionUtils;
import xyz.xkrivzooh.dozer.tools.Constants;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static xyz.xkrivzooh.dozer.tools.Constants.POINT;


public class DefaultCustomerMap implements CustomerMap {

    private final Map<String, Object> holder;
    private final MapReader<String> mapReader;

    public DefaultCustomerMap() {
        this.holder = Maps.newHashMap();
        this.mapReader = MapReader.from(this.holder);
    }

    public DefaultCustomerMap(Map<String, Object> holder) {
        Preconditions.checkNotNull(holder);
        this.holder = holder;
        this.mapReader = MapReader.from(this.holder);
    }

    @Override
    public Object get(String key) {
        final List<String> keyParts = getKeyParts(key);
        if (keyParts.size() > 1) {
            return reverseGetValue(keyParts);
        } else {
            return supportedIndexedGet(this.mapReader, key);
        }
    }


    public void put(String key, Object value) {
        Preconditions.checkNotNull(key);
        final List<String> keyParts = getKeyParts(key);
        if (keyParts.size() > 1) {
            putValue(keyParts, value);
        } else {
            holder.put(key, value);
        }
    }

    @Override
    public void putToList(String key, List<Object> newItems) {
        Preconditions.checkNotNull(key);
        final List<String> keyParts = getKeyParts(key);
        if (keyParts.size() > 1) {
            putValuesToList(keyParts, newItems);
        } else {
            final Object existValue = holder.get(key);
            if (existValue == null) {
                holder.put(key, newItems);
            } else {
                List<Object> existValueAsList = (List<Object>) existValue;
                existValueAsList.addAll(newItems);
            }
        }
    }

    @Override
    public void putToSet(String key, Set<Object> newItems) {
        Preconditions.checkNotNull(key);
        final List<String> keyParts = getKeyParts(key);
        if (keyParts.size() > 1) {
            putValuesToSet(keyParts, newItems);
        } else {
            final Object existValue = holder.get(key);
            if (existValue == null) {
                holder.put(key, newItems);
            } else {
                Set<Object> existValueAsList = (Set<Object>) existValue;
                existValueAsList.addAll(newItems);
            }
        }
    }


    @Override
    public Map<String, Object> acquireInnerMap() {
        return holder;
    }

    @Override
    public String getString(String name) {
        final Object o = get(name);
        return (String) o;
    }


    @Override
    public String getString(String name, String defValue) {
        final Object o = get(name);
        if (o == null) {
            return defValue;
        }
        return (String) o;
    }

    @Override
    public String getString(String name, String defValue, boolean checkContains) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Integer getInteger(String name) {
        final Object obj = get(name);
        return (Integer) obj;
    }

    @Override
    public Integer getInteger(String name, Integer defValue) {
        final Object obj = get(name);
        if (obj == null) {
            return defValue;
        }
        return (Integer) obj;
    }

    @Override
    public Integer getInteger(String name, Integer defValue, boolean checkContainsKey) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Long getLong(String name) {
        final Object obj = get(name);
        return (Long) obj;
    }

    @Override
    public Long getLong(String name, Long defValue) {
        final Object obj = get(name);
        if (obj == null) {
            return defValue;
        }
        return (Long) obj;
    }

    @Override
    public Long getLong(String name, Long defValue, boolean checkContainsKey) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Float getFloat(String name) {
        final Object obj = get(name);
        return (Float) obj;
    }

    @Override
    public Float getFloat(String name, Float defValue) {
        final Object obj = get(name);
        if (obj == null) {
            return defValue;
        }
        return (Float) obj;
    }

    @Override
    public Float getFloat(String name, Float defValue, boolean checkContainsKey) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Double getDouble(String name) {
        final Object obj = get(name);
        return (Double) obj;
    }

    @Override
    public Double getDouble(String name, Double defValue) {
        final Object obj = get(name);
        if (obj == null) {
            return defValue;
        }
        return (Double) obj;
    }

    @Override
    public Double getDouble(String name, Double defValue, boolean checkContainsKey) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Boolean getBoolean(String name) {
        final Object obj = get(name);
        return (Boolean) obj;
    }

    @Override
    public Boolean getBoolean(String name, Boolean defValue) {
        final Object obj = get(name);
        if (obj == null) {
            return defValue;
        }
        return (Boolean) obj;
    }

    @Override
    public Boolean getBoolean(String name, Boolean defValue, boolean checkContainsKey) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Byte getByte(String name) {
        final Object obj = get(name);
        return (Byte) obj;
    }

    @Override
    public Byte getByte(String name, Byte defValue) {
        final Object obj = get(name);
        if (obj == null) {
            return defValue;
        }
        return (Byte) obj;
    }

    @Override
    public Byte getByte(String name, Byte defValue, boolean checkContainsKey) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Short getShort(String name) {
        final Object obj = get(name);
        return (Short) obj;
    }

    @Override
    public Short getShort(String name, Short defValue) {
        final Object obj = get(name);
        if (obj == null) {
            return defValue;
        }
        return (Short) obj;
    }

    @Override
    public Short getShort(String name, Short defValue, boolean checkContainsKey) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Character getCharacter(String name) {
        final Object obj = get(name);
        return (Character) obj;
    }

    @Override
    public Character getCharacter(String name, Character defValue) {
        final Object obj = get(name);
        if (obj == null) {
            return defValue;
        }
        return (Character) obj;
    }

    @Override
    public Character getCharacter(String name, Character defValue, boolean checkContainsKey) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <E extends Enum<E>> E getEnum(String name, Class<E> clazz) {
        Object v = get(name);
        E[] codeEnums = clazz.getEnumConstants();
        for (E codeEnum : codeEnums) {
            if (codeEnum.name().equals(v)) {
                return codeEnum;
            }
        }
        return null;
    }

    @Override
    public <E extends Enum<E>> E getEnum(String name, E defValue, Class<E> clazz) {
        Object v = get(name);
        E[] codeEnums = clazz.getEnumConstants();
        for (E codeEnum : codeEnums) {
            if (codeEnum.name().equals(v)) {
                return codeEnum;
            }
        }
        return defValue;
    }

    @Override
    public <E extends Enum<E>> E getEnum(String name, E defValue, boolean checkContainsKey, Class<E> clazz) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T extends List<?>> T getList(String name) {
        final List<String> keyParts = getKeyParts(name);
        if (keyParts.size() > 1) {
            return reverseGetValue(keyParts);
        } else {
            return mapReader.getList(name);
        }
    }


    @SuppressWarnings("unchecked")
    private void putValue(List<String> keyParts, Object value) {
        Preconditions.checkArgument(!CollectionUtils.isEmpty(keyParts));
        Map<String, Object> tempHolder = this.holder;
        for (int i = 0; i < keyParts.size(); i++) {
            final String keyPart = keyParts.get(i);
            if (i < keyParts.size() - 1) {
                tempHolder.putIfAbsent(keyPart, Maps.<String, Object>newHashMap());
                final Object tempValue = tempHolder.get(keyPart);
                try {
                    tempHolder = (Map<String, Object>) tempValue;
                } catch (Exception e) {
                    StringBuilder key = new StringBuilder();
                    for (int j = 0; j <= i; j++) {
                        key.append(keyParts.get(j));
                        if (j != i) {
                            key.append(POINT);
                        }
                    }
                    String error = String.format("字段%s已经存在，但是不是对象类型，现在类型为%s, 无法继续增加嵌套字段:%s 请检查",
                            key.toString(), tempValue.getClass().getCanonicalName(), key.append(POINT).append(keyParts.get(i + 1)).toString());
                    throw new RuntimeException(error);
                }
            } else {
                tempHolder.put(keyPart, value);
            }
        }
    }

    private void putValuesToList(List<String> keyParts, List<Object> newItems) {
        Preconditions.checkArgument(!CollectionUtils.isEmpty(keyParts));

        Map<String, Object> tempHolder = this.holder;
        for (int i = 0; i < keyParts.size(); i++) {
            final String keyPart = keyParts.get(i);
            if (i < keyParts.size() - 1) {
                tempHolder.putIfAbsent(keyPart, Maps.<String, Object>newHashMap());
                final Object tempValue = tempHolder.get(keyPart);
                try {
                    tempHolder = (Map<String, Object>) tempValue;
                } catch (Exception e) {
                    StringBuilder key = new StringBuilder();
                    for (int j = 0; j <= i; j++) {
                        key.append(keyParts.get(j));
                        if (j != i) {
                            key.append(POINT);
                        }
                    }
                    String error = String.format("字段%s已经存在，但是不是对象类型，现在类型为%s, 无法继续增加嵌套字段:%s 请检查",
                            key.toString(), tempValue.getClass().getCanonicalName(), key.append(POINT).append(keyParts.get(i + 1)).toString());
                    throw new RuntimeException(error);
                }
            } else {
                final Object existValue = tempHolder.get(keyPart);
                if (existValue == null) {
                    tempHolder.put(keyPart, newItems);
                } else {
                    List<Object> existValueAsList = (List<Object>) existValue;
                    existValueAsList.addAll(newItems);
                    tempHolder.put(keyPart, existValueAsList);
                }
            }
        }
    }

    private void putValuesToSet(List<String> keyParts, Set<Object> newItems) {
        Preconditions.checkArgument(!CollectionUtils.isEmpty(keyParts));

        Map<String, Object> tempHolder = this.holder;
        for (int i = 0; i < keyParts.size(); i++) {
            final String keyPart = keyParts.get(i);
            if (i < keyParts.size() - 1) {
                tempHolder.putIfAbsent(keyPart, Maps.<String, Object>newHashMap());
                final Object tempValue = tempHolder.get(keyPart);
                try {
                    tempHolder = (Map<String, Object>) tempValue;
                } catch (Exception e) {
                    StringBuilder key = new StringBuilder();
                    for (int j = 0; j <= i; j++) {
                        key.append(keyParts.get(j));
                        if (j != i) {
                            key.append(POINT);
                        }
                    }
                    String error = String.format("字段%s已经存在，但是不是对象类型，现在类型为%s, 无法继续增加嵌套字段:%s 请检查",
                            key.toString(), tempValue.getClass().getCanonicalName(), key.append(POINT).append(keyParts.get(i + 1)).toString());
                    throw new RuntimeException(error);
                }
            } else {
                final Object existValue = tempHolder.get(keyPart);
                if (existValue == null) {
                    tempHolder.put(keyPart, newItems);
                } else {
                    Set<Object> existValueAsList = (Set<Object>) existValue;
                    existValueAsList.addAll(newItems);
                    tempHolder.put(keyPart, existValueAsList);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    private <T> T reverseGetValue(List<String> keyParts) {
        return reverseGetValue0(keyParts, this.holder);
    }

    @SuppressWarnings("unchecked")
    private <T> T reverseGetValue0(List<String> keyParts, Map<String, Object> obj) {
        if (keyParts.size() == 1) {
            return (T) supportedIndexedGet(MapReader.from(obj), keyParts.get(0));
        }

        final String remove = keyParts.remove(0);
        final Map<String, Object> tempMap = (Map<String, Object>) supportedIndexedGet(MapReader.from(obj), remove);
        return reverseGetValue0(keyParts, tempMap);
    }

    private Object supportedIndexedGet(MapReader<String> mapReader, String key) {
        final Pair<String, Integer> indexdPair = getIndexdPair(key);
        final Integer index = indexdPair.getRight();
        if (index == null) {
            return mapReader.get(key);
        }

        final List<?> list = mapReader.getList(indexdPair.getLeft());
        return list.get(index);
    }

    private List<String> getKeyParts(String key) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(key));
        return Lists.newArrayList(Constants.SPLITTER_POINT.splitToList(key));
    }

    private Pair<String, Integer> getIndexdPair(String str) {
        final int startTagIndex = str.indexOf("[");
        if (startTagIndex == -1) {
            return Pair.of(str, null);
        }

        String realKey = str.substring(0, startTagIndex);
        Integer index = Integer.parseInt(str.substring(startTagIndex + 1, str.length() - 1));
        return Pair.of(realKey, index);
    }

}
