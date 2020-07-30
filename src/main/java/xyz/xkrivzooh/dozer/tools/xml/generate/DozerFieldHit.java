package xyz.xkrivzooh.dozer.tools.xml.generate;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.Data;

@Data
@JacksonXmlRootElement
public class DozerFieldHit {

    @JacksonXmlText
    private String value;

    public DozerFieldHit(String value) {
        this.value = value;
    }
}
