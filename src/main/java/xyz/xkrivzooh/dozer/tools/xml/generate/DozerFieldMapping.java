package xyz.xkrivzooh.dozer.tools.xml.generate;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

@Data
public class DozerFieldMapping {

    @JacksonXmlProperty(isAttribute = true, localName = "copy-by-reference")
    private Boolean copyByReference;

    @JacksonXmlProperty(isAttribute = true, localName = "custom-converter")
    private String customerConverter;

    @JacksonXmlProperty(isAttribute = true, localName = "custom-converter-param")
    private String customerConverterParam;

    @JacksonXmlProperty(localName = "a")
    private DozerField dozerFieldA;

    @JacksonXmlProperty(localName = "b")
    private DozerField dozerFieldB;

    @JacksonXmlProperty(isAttribute = true, localName = "remove-orphans")
    private Boolean removeOrphans;

    @JacksonXmlProperty(localName = "a-hint")
    private DozerFieldHit dozerFieldHitA;

    @JacksonXmlProperty(localName = "b-hit")
    private DozerFieldHit dozerFieldHitB;

}
