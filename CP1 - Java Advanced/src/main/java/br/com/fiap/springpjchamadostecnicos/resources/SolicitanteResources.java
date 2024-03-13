package br.com.fiap.springpjchamadostecnicos.resources;


import br.com.fiap.springpjchamadostecnicos.entity.Endereco;
import br.com.fiap.springpjchamadostecnicos.entity.Solicitante;
import br.com.fiap.springpjchamadostecnicos.entity.Telefone;
import br.com.fiap.springpjchamadostecnicos.repository.EnderecoRepository;
import br.com.fiap.springpjchamadostecnicos.repository.SolicitanteRepository;
import br.com.fiap.springpjchamadostecnicos.repository.TelefoneRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@RestController
@RequestMapping("/solicitante")
public class SolicitanteResources {

    @Autowired
    private SolicitanteRepository repo;

    @Autowired
    private TelefoneRepository telefoneRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping
    public List<Solicitante> findAll(){
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Solicitante findById(@PathVariable Long id){
        return repo.findById(id).orElseThrow();
    }

    @Transactional
    @PostMapping
    public Solicitante save(@RequestBody Solicitante solicitante){
        return repo.save(solicitante);
    }


}
