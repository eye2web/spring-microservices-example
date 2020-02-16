package eye2web.articles.controller;

import eye2web.articles.dto.ArticleResponse;
import eye2web.articles.service.ArticleService;
import eye2web.articles.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;
    private final PriceService priceService;
    private final ModelMapper modelMapper;

    @GetMapping("/articles")
    public ResponseEntity<List<ArticleResponse>> getAllArticles() {

        final var articles = articleService.allArticles();

        final var results = articles.stream().map(article -> {
            final var lastPriceOpt = priceService.tryGetLatestPrice(article.getPrices());

            final ArticleResponse articleResponse = modelMapper.map(article, ArticleResponse.class);

            lastPriceOpt.ifPresent(price -> articleResponse.setPrice(price.getPrice()));
            return articleResponse;
        }).collect(Collectors.toList());


        return ResponseEntity.ok(results);
    }

}
