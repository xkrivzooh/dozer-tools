package xyz.xkrivzooh.dozer.tools.xml.generate;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import java.util.List;

@JacksonXmlRootElement(localName = "mapping")
@Data
public class DozerMapping {

    @JacksonXmlProperty(isAttribute = true, localName = "map-id")
    private String mapId;

    @JacksonXmlProperty(isAttribute = true, localName = "type")
    private final String type = "one-way";

    @JacksonXmlProperty(isAttribute = true, localName = "map-null")
    private final Boolean mapNull = false;

    @JacksonXmlProperty(localName = "class-a")
    private DozerClass classA;

    @JacksonXmlProperty(localName = "class-b")
    private DozerClass classB;

    @JacksonXmlProperty(isAttribute = true, localName = "wildcard")
    private Boolean wildcard;

    @JacksonXmlProperty(isAttribute = true, localName = "date-format")
    private String dateFormat;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "field")
    private List<DozerFieldMapping> mappings;

}
