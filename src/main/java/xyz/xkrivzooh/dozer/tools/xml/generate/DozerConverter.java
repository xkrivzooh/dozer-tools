package xyz.xkrivzooh.dozer.tools.xml.generate;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

@JacksonXmlRootElement(localName = "converter")
@Data
public class DozerConverter {

    @JacksonXmlProperty(isAttribute = true, localName = "type")
    private String type;

    @JacksonXmlProperty(localName = "class-a")
    private DozerClass classA;

    @JacksonXmlProperty(localName = "class-b")
    private DozerClass classB;

}
