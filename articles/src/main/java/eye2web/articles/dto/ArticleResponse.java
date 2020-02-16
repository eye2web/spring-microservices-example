package eye2web.articles.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class ArticleResponse {

    private UUID id;
    private String name;
    private String code;
    private BigDecimal price;
}
