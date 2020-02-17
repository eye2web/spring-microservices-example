package eye2web.articles.dto.converter;

import eye2web.articles.dto.SearchOption;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

@Slf4j
public class SearchOptionConverter implements Converter<String, SearchOption> {

    @Override
    public SearchOption convert(final String source) {
        return SearchOption.fromValue(source);
    }

}
