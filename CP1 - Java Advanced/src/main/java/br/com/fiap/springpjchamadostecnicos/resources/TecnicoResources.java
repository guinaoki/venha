package br.com.fiap.springpjchamadostecnicos.resources;


import br.com.fiap.springpjchamadostecnicos.entity.Tecnico;
import br.com.fiap.springpjchamadostecnicos.repository.TecnicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tecnico")
public class TecnicoResources {

    @Autowired
    private TecnicoRepository repo;

    @GetMapping
    public List<Tecnico> findAll(){
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Tecnico findById(@PathVariable Long id){
        return repo.findById(id).orElseThrow();
    }

    @Transactional
    @PostMapping
    public Tecnico save(@RequestBody Tecnico tecnico){
        return repo.save(tecnico);
    }

}
