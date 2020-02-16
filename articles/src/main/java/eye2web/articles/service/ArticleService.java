package eye2web.articles.service;

import eye2web.articles.domain.Article;
import eye2web.articles.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

}

