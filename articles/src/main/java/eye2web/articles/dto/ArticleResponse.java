package eye2web.articles.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
public class ArticleResponse {

    private UUID id;
    private String name;
    private String code;
    private BigDecimal price;

    @JsonFormat(pattern = "MM-yyyy-dd:HH:mm:ss")
    private LocalDateTime created;
}
