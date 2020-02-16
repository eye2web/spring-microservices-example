package eye2web.articles.repository;

import eye2web.articles.domain.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ArticleRepository extends CrudRepository<Article, UUID> {
}
