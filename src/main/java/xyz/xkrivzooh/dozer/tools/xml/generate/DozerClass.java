package xyz.xkrivzooh.dozer.tools.xml.generate;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.Data;

@JacksonXmlRootElement
@Data
public class DozerClass {

    @JacksonXmlText
    private String value;

    public DozerClass() {
    }

    public DozerClass(String value) {
        this.value = value;
    }
}
