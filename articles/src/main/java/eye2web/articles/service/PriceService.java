package eye2web.articles.service;

import eye2web.articles.domain.Price;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class PriceService {

    public Optional<Price> tryGetLatestPrice(final List<Price> prices) {

        return prices.stream().max(Comparator.comparing(Price::getCreated));
    }

    public Price createPrice(final BigDecimal price) {

        return Price.builder()
                .created(LocalDateTime.now())
                .price(price)
                .build();
    }

}
