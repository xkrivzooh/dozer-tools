package xyz.xkrivzooh.dozer.tools.xml.generate;

import com.ctc.wstx.stax.WstxInputFactory;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;

import javax.xml.stream.XMLInputFactory;
import java.io.IOException;


public class XmlMapper {

    private static com.fasterxml.jackson.dataformat.xml.XmlMapper xmlMapper;

    static {
        XMLInputFactory xmlInputFactory = new WstxInputFactory();
        xmlInputFactory.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, Boolean.FALSE);
        xmlMapper = new com.fasterxml.jackson.dataformat.xml.XmlMapper(new XmlFactory(xmlInputFactory));
        xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        xmlMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public static <T> T readValue(String xml, Class<T> valueType) {
        try {
            return xmlMapper.readValue(xml, valueType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String writeValueAsString(Object object) {
        try {
            return xmlMapper.writeValueAsString(object);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
