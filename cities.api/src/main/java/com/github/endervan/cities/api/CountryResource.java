package com.github.endervan.cities.api;

import com.github.endervan.cities.api.Countries.Country;
import com.github.endervan.cities.api.repository.CountryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/countries")
public class CountryResource {

    //@Autowired
    private CountryRepository repository;
    // apena  @Autowired equivale a construtor feito abaixo

    public CountryResource(CountryRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    // paginando usando Pageable ..trocando List por Page tb
    public Page<Country> countries(Pageable page) {
        return repository.findAll(page);
    }

    // buscando apena 1 pais
    @GetMapping(("/{id}"))
    public ResponseEntity getOne(@PathVariable Long id) {
        Optional<Country> optional = repository.findById(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok().body(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
