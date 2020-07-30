package xyz.xkrivzooh.dozer.tools.enhance;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Assert;
import org.junit.Test;
import xyz.xkrivzooh.dozer.tools.xml.generate.JSON;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultCustomerMapTest {

    @Test
    public void test_primary_type() {
        final DefaultCustomerMap customerMap = new DefaultCustomerMap(Maps.newHashMap());
        customerMap.put("stringKey1", "str");
        customerMap.put("intKey1", 1);

        Assert.assertEquals("str", customerMap.getString("stringKey1"));
        Assert.assertEquals((Integer) 1, customerMap.getInteger("intKey1"));
    }

    @Test
    public void test_customer_map_put() {
        final DefaultCustomerMap defaultCustomerMap = new DefaultCustomerMap();
        defaultCustomerMap.put("key1", 1);
        defaultCustomerMap.put("key2.key22", 1);
        System.out.println(JSON.writeValueAsString(defaultCustomerMap.acquireInnerMap()));
        Assert.assertEquals("java.util.HashMap", defaultCustomerMap.get("key2").getClass().getCanonicalName());
        Assert.assertEquals(1, (int) ((Map<String, Object>) (Map<String, Object>) defaultCustomerMap.get("key2")).get("key22"));

        try {
            defaultCustomerMap.put("key3", 1);
            defaultCustomerMap.put("key3.error", 1);
            Assert.fail("key3应该是个map");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue(e.getMessage().contains("字段key3已经存在，但是不是对象类型，现在类型为java.lang.Integer, 无法继续增加嵌套字段:key3.error 请检查"));
        }

        defaultCustomerMap.put("key4.keyInner4.keyInnerInner4", Lists.newArrayList(1, 2, 3));
        System.out.println(JSON.writeValueAsString(defaultCustomerMap.acquireInnerMap()));

        try {
            defaultCustomerMap.put("key5.keyInner5", 1);
            defaultCustomerMap.put("key5.keyInner5.keyInnerInner5", Lists.newArrayList(1, 2, 3));
            System.out.println(JSON.writeValueAsString(defaultCustomerMap.acquireInnerMap()));
            Assert.fail();
        } catch (Exception e) {
            Assert.assertTrue(e.getMessage().contains("字段key5.keyInner5已经存在，但是不是对象类型，现在类型为java.lang.Integer, 无法继续增加嵌套字段:key5.keyInner5.keyInnerInner5 请检查"));
        }
    }


    @Test
    public void test_put_value_type_is_map() {
        Map<String, String> map = Maps.newHashMap();
        map.put("name", "rollen");

        final DefaultCustomerMap defaultCustomerMap = new DefaultCustomerMap();
        defaultCustomerMap.put("key1", map);
        System.out.println(JSON.writeValueAsString(defaultCustomerMap.acquireInnerMap()));

        System.out.println(defaultCustomerMap.get("key1"));
        System.out.println(defaultCustomerMap.get("key1.name"));
        Assert.assertEquals("rollen", defaultCustomerMap.get("key1.name"));
    }

    @Test
    public void test_indexed_get() {
        Map<String, Object> map = Maps.newHashMap();
        map.put("list", Lists.newArrayList(1, 2, 3));
        final HashMap<Object, Object> value = Maps.newHashMap();
        value.put("list", Lists.newArrayList(1, 2, 3));
        map.put("a", value);
        final DefaultCustomerMap defaultCustomerMap = new DefaultCustomerMap(map);
        Assert.assertEquals("1", defaultCustomerMap.get("list[0]").toString());
        Assert.assertEquals("2", defaultCustomerMap.get("list[1]").toString());
        Assert.assertEquals("3", defaultCustomerMap.get("list[2]").toString());


        Assert.assertEquals("1", defaultCustomerMap.get("a.list[0]").toString());
        Assert.assertEquals("2", defaultCustomerMap.get("a.list[1]").toString());
        Assert.assertEquals("3", defaultCustomerMap.get("a.list[2]").toString());
    }


    @Test
    public void test_access_nested1() {
        final HashMap<String, Object> value = Maps.newHashMap();
        value.put("key2", "value2");
        value.put("key2list1", Lists.newArrayList(1, 2, 3));

        final DefaultCustomerMap customerMap = new DefaultCustomerMap(Maps.newHashMap());
        customerMap.put("key1", value);

        final String string = customerMap.getString("key1.key2");
        Assert.assertEquals("value2", string);

        List<Integer> key2list1 = customerMap.getList("key1.key2list1");
        System.out.println(key2list1);
    }


    @Test
    public void test_putToList() {
        final HashMap<String, Object> value = Maps.newHashMap();
        value.put("list", Lists.newArrayList(1, 2, 3));
        final DefaultCustomerMap customerMap = new DefaultCustomerMap(value);
        Object obj = customerMap.getList("list");
        System.out.println(obj);
        customerMap.putToList("list", Lists.newArrayList(4));
        customerMap.putToList("list", Lists.newArrayList(5));

        List<Integer> key2list1 = customerMap.getList("list");
        System.out.println(key2list1);
    }


}
