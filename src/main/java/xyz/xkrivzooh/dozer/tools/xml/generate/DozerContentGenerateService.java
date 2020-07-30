package xyz.xkrivzooh.dozer.tools.xml.generate;

import com.google.common.base.Preconditions;

public class DozerContentGenerateService {

    private static final String dozerXmlHeader = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<mappings xmlns=\"http://dozermapper.github.io/schema/bean-mapping\"\n" +
            "          xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
            "          xsi:schemaLocation=\"http://dozermapper.github.io/schema/bean-mapping http://dozermapper.github.io/schema/bean-mapping.xsd\">";

    private static final String dozerXmlFooter = "</mappings>";

    private DozerConfiguration defaultDozerConfiguration = new DozerConfiguration();

    public String generate(DozerContentGenerateParam generateParam) {
        Preconditions.checkNotNull(generateParam);

        final DozerConfiguration dozerConfiguration = generateParam.getDozerConfiguration();
        final DozerMapping dozerMapping = generateParam.getDozerMapping();
        Preconditions.checkNotNull(dozerMapping);

        StringBuilder sb = new StringBuilder(dozerXmlHeader).append("\n");
        if (dozerConfiguration != null) {
            sb.append(XmlMapper.writeValueAsString(dozerConfiguration)).append("\n");
        } else {
            sb.append(XmlMapper.writeValueAsString(defaultDozerConfiguration)).append("\n");
        }

        return sb.append(XmlMapper.writeValueAsString(dozerMapping)).append("\n").append(dozerXmlFooter).toString();
    }


}
