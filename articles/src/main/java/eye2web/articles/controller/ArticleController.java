package eye2web.articles.controller;

import eye2web.articles.controller.helper.ArticleMapperHelper;
import eye2web.articles.domain.Article;
import eye2web.articles.dto.ArticleRequest;
import eye2web.articles.dto.ArticleResponse;
import eye2web.articles.dto.SearchOption;
import eye2web.articles.service.ArticleService;
import eye2web.articles.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;
    private final PriceService priceService;
    private final ModelMapper modelMapper;
    private final ArticleMapperHelper articleMapperHelper;

    @GetMapping("/articles")
    public ResponseEntity<List<ArticleResponse>> getAllArticles() {

        final var articles = articleService.allArticles();

        final var results = articles.stream()
                .map(articleMapperHelper::toArticleResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(results);
    }

    @PostMapping("/articles")
    public ResponseEntity<ArticleResponse> newArticle(@Valid @RequestBody final ArticleRequest articleRequest) {

        final var article = modelMapper.map(articleRequest, Article.class);

        article.setPrices(Collections.singletonList(priceService.createPrice(articleRequest.getPrice())));

        final var createdArticle = articleService.createArticle(article);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(articleMapperHelper.toArticleResponse(createdArticle));
    }

    @GetMapping("/articles/search/{searchOption}/code/{code}")
    public ResponseEntity<List<ArticleResponse>> searchForArticle(@PathVariable("searchOption") final SearchOption searchOption,
                                                                  @PathVariable("code") final String code) {

        final var articles = articleService.searchByCode(searchOption, code);

        final var results = articles.stream()
                .map(articleMapperHelper::toArticleResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(results);
    }

}
