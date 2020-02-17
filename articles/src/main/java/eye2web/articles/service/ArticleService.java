package eye2web.articles.service;

import eye2web.articles.domain.Article;
import eye2web.articles.dto.SearchOption;
import eye2web.articles.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class ArticleService {

    private final ArticleRepository articleRepository;

    public List<Article> allArticles() {

        log.debug("fetching articles");
        final var results = new ArrayList<Article>();

        articleRepository.findAll().iterator().forEachRemaining(results::add);

        return results;
    }

    public Article createArticle(final Article article) {
        setPricesRelation(article);
        article.setCreated(LocalDateTime.now());
        return articleRepository.save(article);
    }

    private void setPricesRelation(final Article article) {
        article.getPrices().forEach(price -> price.setArticle(article));
    }

    public List<Article> searchByCode(final SearchOption searchOption, final String code) {

        switch (searchOption) {
            case STARTS_WITH:
                return articleRepository.searchByCodeStartsWith(code);
            default:
                return articleRepository.findAllByCode(code);
        }
    }

}

