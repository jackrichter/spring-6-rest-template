package guru.springframework.spring7resttemplate.client;

import guru.springframework.spring7resttemplate.model.BeerDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BeerClientImplTest {

    @Autowired
    BeerClientImpl beerClient;

    @Test
    void getBeersById() {
        Page<BeerDTO> beerDTOs = beerClient.listBeers();
        BeerDTO beerDTO = beerDTOs.getContent().get(0);

        BeerDTO byId = beerClient.getBeerById(beerDTO.getId());

        assertNotNull(byId);
    }

    @Test
    void listBeersNoBeerName() {
        beerClient.listBeers(null, null, null, null, null);
    }

    @Test
    void listBeers() {

        beerClient.listBeers("ALE", null, null, null, null);
    }
}