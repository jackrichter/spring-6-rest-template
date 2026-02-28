package guru.springframework.spring7resttemplate.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true, value = "pageable")
public class BeerDTOPageImpl<BeerDto> extends PageImpl<BeerDto> {

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public BeerDTOPageImpl(@JsonProperty("content") List<BeerDto> content,
                           @JsonProperty("number") int pageNumber,
                           @JsonProperty("size") int pageSize,
                           @JsonProperty("totalElements") long totalElements) {
        super(content, PageRequest.of(pageNumber, pageSize), totalElements);
    }

    public BeerDTOPageImpl(List<BeerDto> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public BeerDTOPageImpl(List<BeerDto> content) {
        super(content);
    }
}
