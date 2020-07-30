package xyz.xkrivzooh.dozer.tools.xml.generate;

import com.google.common.collect.Lists;
import org.junit.Test;
import xyz.xkrivzooh.dozer.tools.enhance.DefaultCustomerMap;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DozerContentGenerateServiceTest {

    DozerContentGenerateService dozerContentGenerateService = new DozerContentGenerateService();

    @Test
    public void test() {
        final ArrayList<DozerConverter> converters = Lists.newArrayList();
        final DozerConverter converter = new DozerConverter();
        converter.setType("com.github.dozermapper.core.converters.TestCustomConverter");
        final DozerClass classA = new DozerClass();
        classA.setValue("com.github.dozermapper.core.vo.SpringBean");
        converter.setClassA(classA);
        converter.setClassB(classA);
        converters.add(converter);

        final DozerCustomerConverter dozerCustomerConverter = new DozerCustomerConverter();
        dozerCustomerConverter.setConverters(converters);

        final DozerConfiguration configuration = new DozerConfiguration();
        configuration.setDateFormat("MM/dd/yyyy HH:mm");
        configuration.setStopOnErrors(false);
        configuration.setWildcard(true);
        configuration.setDozerCustomerConverter(dozerCustomerConverter);

        final ArrayList<DozerFieldMapping> mappings = Lists.newArrayList();
        final DozerFieldMapping fieldMapping = new DozerFieldMapping();
        final DozerField dozerFieldA = new DozerField();
        dozerFieldA.setKey("anAttributeToMap");
        fieldMapping.setDozerFieldA(dozerFieldA);
        fieldMapping.setDozerFieldB(dozerFieldA);
        fieldMapping.setRemoveOrphans(true);
//        fieldMapping.setDozerFieldHitA(new DozerFieldHit("java.lang.Integer"));
//        fieldMapping.setDozerFieldHitB(new DozerFieldHit("java.lang.Integer"));
        mappings.add(fieldMapping);

        final DozerMapping dozerMapping = new DozerMapping();
        dozerMapping.setClassA(classA);
        dozerMapping.setClassB(classA);
        dozerMapping.setWildcard(true);
        dozerMapping.setDateFormat("MM/dd/yyyy HH:mm");
        dozerMapping.setMappings(mappings);

        final DozerContentGenerateParam generateParam = new DozerContentGenerateParam();
        generateParam.setDozerConfiguration(configuration);
        generateParam.setDozerMapping(dozerMapping);


        final String content = dozerContentGenerateService.generate(generateParam);
        System.out.println(content);
    }

    @Test
    public void test_generate() {
        final DozerContentGenerateParam generateParam = new DozerContentGenerateParam();

        final DozerMapping dozerMapping = new DozerMapping();
        dozerMapping.setClassA(new DozerClass(DefaultCustomerMap.class.getCanonicalName()));
        dozerMapping.setClassB(new DozerClass(DefaultCustomerMap.class.getCanonicalName()));
        final ArrayList<DozerFieldMapping> mappings = Lists.newArrayList();
        dozerMapping.setMappings(mappings);

        final DozerFieldMapping field1 = new DozerFieldMapping();
        field1.setDozerFieldA(new DozerField("respString"));
        field1.setDozerFieldB(new DozerField("writeString"));
        mappings.add(field1);

        final DozerFieldMapping field2 = new DozerFieldMapping();
        field2.setDozerFieldA(new DozerField("respInt"));
        field2.setDozerFieldB(new DozerField("writeInt"));
        mappings.add(field2);

        final DozerFieldMapping field3 = new DozerFieldMapping();
        field3.setDozerFieldA(new DozerField("respList"));
        field3.setDozerFieldB(new DozerField("writeList"));
        field3.setCopyByReference(Boolean.TRUE);
        mappings.add(field3);

        final DozerFieldMapping field4 = new DozerFieldMapping();
        field4.setDozerFieldA(new DozerField("respMap"));
        field4.setDozerFieldB(new DozerField("writeMap"));
        mappings.add(field4);

        generateParam.setDozerMapping(dozerMapping);

        final String generate = dozerContentGenerateService.generate(generateParam);
        System.out.println(generate);
    }
}
