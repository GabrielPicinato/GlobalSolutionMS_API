package br.com.fiap.microservicegs.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.microservicegs.model.Ambiente;
import br.com.fiap.microservicegs.repository.AmbienteRepository;

@RestController
public class AmbienteController {

	@Autowired
	private AmbienteRepository ambienteRepository;
	
	@GetMapping("/ambiente/{id}")
	@PreAuthorize("hasRole('adm')")
	public Optional<Ambiente> getAmbiente(@PathVariable(value ="id") long id){
		return ambienteRepository.findById(id);
	}
	
	@GetMapping("/ambiente")
	@PreAuthorize("hasRole('adm')")
	public List<Ambiente> getAllAmbientes(){
		return ambienteRepository.findAll();
	}
	
	@PutMapping("/ambiente")
	@PreAuthorize("hasRole('adm')")
	public Ambiente putAmbiente (@RequestBody Ambiente ambiente) {
		return ambienteRepository.save(ambiente);
	}
	@PostMapping("/ambiente")
	@PreAuthorize("hasRole('adm')")
	public Ambiente createAmbiente(@RequestBody Ambiente ambiente) {
		return ambienteRepository.save(ambiente);
	}
	@DeleteMapping("ambiente")
	@PreAuthorize("hasRole('adm')")
	public void removeAmbiente(@RequestBody Ambiente ambiente) {
		ambienteRepository.delete(ambiente);
	}
}
