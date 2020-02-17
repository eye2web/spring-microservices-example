package eye2web.articles.config;

import eye2web.articles.dto.converter.SearchOptionConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebConfiguration extends WebMvcConfigurationSupport {

    @Override
    public FormattingConversionService mvcConversionService() {
        final var formattingConversionService = super.mvcConversionService();
        formattingConversionService.addConverter(new SearchOptionConverter());
        return formattingConversionService;
    }

}
