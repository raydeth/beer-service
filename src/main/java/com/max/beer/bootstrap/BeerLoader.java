package com.max.beer.bootstrap;

import com.max.beer.domain.Beer;
import com.max.beer.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    final private BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if (beerRepository.count() == 0) {
            beerRepository.save(Beer.builder()
                    .name("Mango Bobs")
                    .style("IPA")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(337010000001L)
                    .price(new BigDecimal("12.95"))
                    .build());

            beerRepository.save(Beer.builder()
                    .name("Galaxy Cat")
                    .style("PALE_ALE")
                    .quantityToBrew(200)
                    .upc(337010000002L)
                    .minOnHand(12)
                    .price(new BigDecimal("11.95"))
                    .build());
        }
        System.out.println("Loaded Beers: " + beerRepository.count());
    }
}
