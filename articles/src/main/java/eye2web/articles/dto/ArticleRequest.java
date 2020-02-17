package eye2web.articles.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleRequest {

    @NotNull(message = "Name should not be null")
    @NotEmpty(message = "Name should not be empty")
    @NotBlank(message = "Name should not be blank")
    private String name;
    @NotNull(message = "Code should not be null")
    @NotEmpty(message = "Code should not be empty")
    @NotBlank(message = "Code should not be blank")
    private String code;

    @NotNull(message = "Price should not be null")
    @DecimalMin(value = "0.01", message = "Min price is validated")
    private BigDecimal price;
}
