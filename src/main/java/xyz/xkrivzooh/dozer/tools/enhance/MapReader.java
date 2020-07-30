package xyz.xkrivzooh.dozer.tools.enhance;

import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;
import java.util.Objects;


public class MapReader<K> implements Reader<K, Map<K, Object>> {

    private final Map<K, Object> target;

    protected MapReader(Map<K, Object> target) {
        this.target = target == null ? Maps.newHashMap() : target;
    }

    public static <K> MapReader<K> from(Map<K, Object> map) {
        return new MapReader<>(map);
    }

    @Override
    public Map<K, Object> acquireInnerMap() {
        return target;
    }

    @Override
    public Object get(K key) {
        return target.get(key);
    }

    @Override
    public String getString(K name) {
        return getString(name, null, false);
    }

    @Override
    public String getString(K name, String defValue) {
        return getString(name, defValue, false);
    }

    @Override
    public String getString(K name, String defValue, boolean checkContains) {
        Object v = target.get(name);
        if (v == null) {
            return checkContains && target.containsKey(name) ? null : defValue;
        }
        return (String) v;
    }

    @Override
    public Integer getInteger(K name) {
        return getInteger(name, null, false);
    }

    @Override
    public Integer getInteger(K name, Integer defValue) {
        return getInteger(name, defValue, false);
    }

    @Override
    public Integer getInteger(K name, Integer defValue, boolean checkContainsKey) {
        Object v = target.get(name);
        if (v == null) {
            return checkContainsKey && target.containsKey(name) ? null : defValue;
        }
        try {
            return Integer.parseInt(String.valueOf(v));
        } catch (NumberFormatException e) {
            return defValue;
        }
    }

    @Override
    public Long getLong(K name) {
        return getLong(name, null, false);
    }

    @Override
    public Long getLong(K name, Long defValue) {
        return getLong(name, defValue, false);
    }

    @Override
    public Long getLong(K name, Long defValue, boolean checkContainsKey) {
        Object v = target.get(name);
        if (v == null) {
            return checkContainsKey && target.containsKey(name) ? null : defValue;
        }
        try {
            return Long.parseLong(String.valueOf(v));
        } catch (NumberFormatException e) {
            return defValue;
        }
    }

    @Override
    public Float getFloat(K name) {
        return getFloat(name, null, false);
    }

    @Override
    public Float getFloat(K name, Float defValue) {
        return getFloat(name, defValue, false);
    }

    @Override
    public Float getFloat(K name, Float defValue, boolean checkContainsKey) {
        Object v = target.get(name);
        if (v == null) {
            return checkContainsKey && target.containsKey(name) ? null : defValue;
        }
        try {
            return Float.parseFloat(String.valueOf(v));
        } catch (NumberFormatException e) {
            return defValue;
        }
    }

    @Override
    public Double getDouble(K name) {
        return getDouble(name, null, false);
    }

    @Override
    public Double getDouble(K name, Double defValue) {
        return getDouble(name, defValue, false);
    }

    @Override
    public Double getDouble(K name, Double defValue, boolean checkContainsKey) {
        Object v = target.get(name);
        if (v == null) {
            return checkContainsKey && target.containsKey(name) ? null : defValue;
        }
        try {
            return Double.parseDouble(String.valueOf(v));
        } catch (NumberFormatException e) {
            return defValue;
        }
    }

    @Override
    public Boolean getBoolean(K name) {
        return getBoolean(name, null, false);
    }

    @Override
    public Boolean getBoolean(K name, Boolean defValue) {
        return getBoolean(name, defValue, false);
    }

    @Override
    public Boolean getBoolean(K name, Boolean defValue, boolean checkContainsKey) {
        Object v = target.get(name);
        if (v == null) {
            return checkContainsKey && target.containsKey(name) ? null : defValue;
        }
        try {
            return Boolean.parseBoolean(String.valueOf(v));
        } catch (NumberFormatException e) {
            return defValue;
        }
    }

    @Override
    public Byte getByte(K name) {
        return getByte(name, null, false);
    }

    @Override
    public Byte getByte(K name, Byte defValue) {
        return getByte(name, defValue, false);
    }

    @Override
    public Byte getByte(K name, Byte defValue, boolean checkContainsKey) {
        Object v = target.get(name);
        if (v == null) {
            return checkContainsKey && target.containsKey(name) ? null : defValue;
        }
        try {
            return Byte.parseByte(String.valueOf(v));
        } catch (NumberFormatException e) {
            return defValue;
        }
    }

    @Override
    public Short getShort(K name) {
        return getShort(name, null, false);
    }

    @Override
    public Short getShort(K name, Short defValue) {
        return getShort(name, defValue, false);
    }

    @Override
    public Short getShort(K name, Short defValue, boolean checkContainsKey) {
        Object v = target.get(name);
        if (v == null) {
            return checkContainsKey && target.containsKey(name) ? null : defValue;
        }
        try {
            return Short.parseShort(String.valueOf(v));
        } catch (NumberFormatException e) {
            return defValue;
        }
    }

    @Override
    public Character getCharacter(K name) {
        return getCharacter(name, null, false);
    }

    @Override
    public Character getCharacter(K name, Character defValue) {
        return getCharacter(name, defValue, false);
    }

    @Override
    public Character getCharacter(K name, Character defValue, boolean checkContainsKey) {
        Object v = target.get(name);
        if (v == null) {
            return checkContainsKey && target.containsKey(name) ? null : defValue;
        }
        return ((String) v).charAt(0);
    }

    @Override
    public <E extends Enum<E>> E getEnum(K name, Class<E> clazz) {
        return getEnum(name, null, false, clazz);
    }

    @Override
    public <E extends Enum<E>> E getEnum(K name, E defValue, Class<E> clazz) {
        return getEnum(name, defValue, false, clazz);
    }

    @Override
    public <E extends Enum<E>> E getEnum(K name, E defValue, boolean checkContainsKey, Class<E> clazz) {
        Object v = target.get(name);
        if (v == null) {
            return checkContainsKey && target.containsKey(name) ? null : defValue;
        }
        E[] codeEnums = clazz.getEnumConstants();
        for (E codeEnum : codeEnums) {
            if (codeEnum.name().equals(v)) {
                return codeEnum;
            }
        }
        return defValue;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends List<?>> T getList(K name) {
        final Object v = target.get(name);
        if (v == null) {
            return null;
        }
        return (T) v;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapReader<?> mapReader = (MapReader<?>) o;
        return Objects.equals(target, mapReader.target);
    }

    @Override
    public int hashCode() {
        return Objects.hash(target);
    }

    @Override
    public String toString() {
        return target.toString();
    }
}
