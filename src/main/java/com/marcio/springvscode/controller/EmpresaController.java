package com.marcio.springvscode.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.marcio.springvscode.exception.ResourceNotFoundException;
import com.marcio.springvscode.model.Empresa;
import com.marcio.springvscode.repository.EmpresaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class EmpresaController {

    @Autowired
    private EmpresaRepository empresaRepository;

    @GetMapping("empresas")
    public List<Empresa> getAllEmpresa() {
        return this.empresaRepository.findAll();
    }

    @GetMapping("/empresas/{id}")
    public ResponseEntity<Empresa> getEmpresaByID(@PathVariable(value = "id") Long empresaId)
            throws ResourceNotFoundException {
        Empresa empresa = this.empresaRepository.findById(empresaId)
                .orElseThrow(() -> new ResourceNotFoundException("Empresa não encontrada para o id :: " + empresaId));
        return ResponseEntity.ok().body(empresa);
    }

    @PutMapping("/empresas/{id}")
    public ResponseEntity<Empresa> updateEmpresa(@PathVariable(value = "id") Long empresaId,
            @Validated @RequestBody Empresa empresaDetails) throws ResourceNotFoundException {

        Empresa empresa = this.empresaRepository.findById(empresaId)
                .orElseThrow(() -> new ResourceNotFoundException("Empresa não encontrada para o id :: " + empresaId));

        empresa.setCodigo(empresaDetails.getCodigo());
        empresa.setNomeEmpresa(empresaDetails.getNomeEmpresa());

        return ResponseEntity.ok(this.empresaRepository.save(empresa));
    }

    @DeleteMapping("/empresas/{id}")
    public Map<String, Boolean> deleteEmpresa(@PathVariable(value = "id") Long empresaId)
            throws ResourceNotFoundException {

        Empresa empresa = this.empresaRepository.findById(empresaId)
                .orElseThrow(() -> new ResourceNotFoundException("Empresa não encontrada para o id :: " + empresaId));

        this.empresaRepository.delete(empresa);

        Map<String, Boolean> response = new HashMap<>();

        response.put("deleted", Boolean.TRUE);

        return response;
    }

    @PostMapping("empresas")
    public Empresa saveEmpresa(@RequestBody Empresa empresa) {
        return this.empresaRepository.save(empresa);
    }

}
