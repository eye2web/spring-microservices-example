package eye2web.articles.controller.helper;

import eye2web.articles.domain.Article;
import eye2web.articles.dto.ArticleResponse;
import eye2web.articles.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ArticleMapperHelper {

    private final PriceService priceService;
    private final ModelMapper modelMapper;

    public ArticleResponse toArticleResponse(final Article article) {

        final var lastPriceOpt = priceService.tryGetLatestPrice(article.getPrices());

        final ArticleResponse articleResponse = modelMapper.map(article, ArticleResponse.class);

        lastPriceOpt.ifPresent(price -> articleResponse.setPrice(price.getPrice()));

        return articleResponse;
    }

}
