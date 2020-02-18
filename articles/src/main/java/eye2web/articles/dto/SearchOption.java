package eye2web.articles.dto;

import eye2web.articles.exception.NotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
public enum SearchOption {
    STARTS_WITH("startswith"), ENDS_WITH("endswith"), EQUALS("equals"), CONTAINS("contains");

    @Getter
    private final String searchOption;

    public static SearchOption fromValue(final String searchOption) {

        return Arrays.stream(SearchOption.values())
                .filter(searchOpt -> searchOpt.getSearchOption().equals(searchOption))
                .findFirst().orElseThrow(() -> new NotFoundException(String.format("Unknown searchOption '%s'", searchOption)));
    }
}
