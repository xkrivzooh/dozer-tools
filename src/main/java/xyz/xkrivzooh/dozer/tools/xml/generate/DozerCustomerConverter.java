package xyz.xkrivzooh.dozer.tools.xml.generate;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import java.util.List;

@JacksonXmlRootElement(localName = "custom-converters")
@Data
public class DozerCustomerConverter {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "converter")
    private List<DozerConverter> converters;
}
