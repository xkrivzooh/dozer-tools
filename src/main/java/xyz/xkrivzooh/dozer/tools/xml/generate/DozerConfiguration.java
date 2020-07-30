package xyz.xkrivzooh.dozer.tools.xml.generate;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

@JacksonXmlRootElement(localName = "configuration")
@Data
public class DozerConfiguration {

    @JacksonXmlProperty(localName = "date-format")
    private String dateFormat;

    @JacksonXmlProperty(localName = "stop-on-errors")
    private Boolean stopOnErrors;

    @JacksonXmlProperty(localName = "wildcard")
    private Boolean wildcard;

    @JacksonXmlProperty(localName = "custom-converters")
    private DozerCustomerConverter dozerCustomerConverter;

    @JacksonXmlProperty(localName = "map-null")
    private Boolean mapNull = false;
}
