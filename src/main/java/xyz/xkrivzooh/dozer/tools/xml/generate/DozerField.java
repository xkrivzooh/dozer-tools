package xyz.xkrivzooh.dozer.tools.xml.generate;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.Data;

@JacksonXmlRootElement
@Data
public class DozerField {

    @JacksonXmlProperty(isAttribute = true, localName = "map-set-method")
    private String setMethod = "put";

    @JacksonXmlProperty(isAttribute = true, localName = "map-get-method")
    private String getMethod = "get";

    @JacksonXmlProperty(isAttribute = true, localName = "key")
    private String key;

    @JacksonXmlText
    private final String value = "this";

    public DozerField() {
    }

    public DozerField(String key) {
        this.key = key;
    }
}
