package eye2web.articles.repository;

import eye2web.articles.domain.Article;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ArticleRepository extends CrudRepository<Article, UUID> {

    Optional<Article> findOneById(final UUID id);

    List<Article> findByCodeContaining(final String code);

    List<Article> findAllByCode(final String code);

    @Query("SELECT a FROM Article a join fetch a.prices WHERE a.code LIKE :code%")
    List<Article> findByCodeStartsWith(@Param("code") final String code);

    @Query("SELECT a FROM Article a join fetch a.prices WHERE a.code LIKE %:code")
    List<Article> findByCodeEndsWith(@Param("code") final String code);

}
