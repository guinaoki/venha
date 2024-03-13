package br.com.fiap.springpjchamadostecnicos.resources;


import br.com.fiap.springpjchamadostecnicos.entity.Ocorrencia;
import br.com.fiap.springpjchamadostecnicos.repository.OcorrenciaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ocorrencia")
public class OcorrenciaResources {

    @Autowired
    private OcorrenciaRepository repo;

    @GetMapping
    public List<Ocorrencia> findAll(){
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Ocorrencia findById(@PathVariable Long id){
        return repo.findById(id).orElseThrow();
    }

    @Transactional
    @PostMapping
    public Ocorrencia save(@RequestBody Ocorrencia ocorrencia){
        return repo.save(ocorrencia);
    }

}
