package xyz.xkrivzooh.dozer.tools.xml.generate;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class XmlMapperTest {
    @Test
    public void test_write_xml() {
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
        System.out.println(XmlMapper.writeValueAsString(configuration));
        /**
         * <configuration>
         *   <date-format>MM/dd/yyyy HH:mm</date-format>
         *   <stop-on-errors>false</stop-on-errors>
         *   <wildcard>true</wildcard>
         *   <custom-converters>
         *     <converter type="com.github.dozermapper.core.converters.TestCustomConverter">
         *       <class-a>com.github.dozermapper.core.vo.SpringBean</class-a>
         *       <class-b>com.github.dozermapper.core.vo.SpringBean</class-b>
         *     </converter>
         *   </custom-converters>
         * </configuration>
         */

        final ArrayList<DozerFieldMapping> mappings = Lists.newArrayList();
        final DozerFieldMapping fieldMapping = new DozerFieldMapping();
        final DozerField dozerFieldA = new DozerField();
        dozerFieldA.setKey("anAttributeToMap");
        fieldMapping.setDozerFieldA(dozerFieldA);
        fieldMapping.setDozerFieldB(dozerFieldA);
        fieldMapping.setRemoveOrphans(true);
        mappings.add(fieldMapping);

        final DozerMapping dozerMapping = new DozerMapping();
        dozerMapping.setClassA(classA);
        dozerMapping.setClassB(classA);
        dozerMapping.setWildcard(true);
        dozerMapping.setDateFormat("MM/dd/yyyy HH:mm");
        dozerMapping.setMappings(mappings);


        final String string = XmlMapper.writeValueAsString(dozerMapping);
        System.out.println(string);
        /**
         * <mapping wildcard="true" date-format="MM/dd/yyyy HH:mm">
         *   <class-a>com.github.dozermapper.core.vo.SpringBean</class-a>
         *   <class-b>com.github.dozermapper.core.vo.SpringBean</class-b>
         *   <field remove-orphans="true">
         *     <a get-method="getTheAttribute">anAttributeToMap</a>
         *     <b get-method="getTheAttribute">anAttributeToMap</b>
         *   </field>
         * </mapping>
         */
    }

    @Test
    public void test_json() throws Exception {
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

        final String string = JSON.writeValueAsString(generateParam);
        System.out.println(string);
    }


}
