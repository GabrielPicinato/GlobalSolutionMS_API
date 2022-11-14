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
import br.com.fiap.microservicegs.model.Regional;
import br.com.fiap.microservicegs.repository.RegionalRepository;

@RestController
public class RegionalController {
	
	@Autowired
	private RegionalRepository regionalRepository;
	

	
	@GetMapping("/regional/{id}")
	@PreAuthorize("hasRole('adm')")
	public Optional<Regional> getRegional(@PathVariable(value ="id") long id){
		return regionalRepository.findById(id);
	}
	@GetMapping("/regional")
	@PreAuthorize("hasRole('adm')")
	public List<Regional> getAllRegionais(){
		return regionalRepository.findAll();
	}
	
	@DeleteMapping("/regional")
	@PreAuthorize("hasRole('adm')")
	public void removeRegional(@RequestBody Regional regional) {
		regionalRepository.delete(regional);
	}
	
	@PutMapping("/regional")
	@PreAuthorize("hasRole('adm')")
	public Regional putRegional (@RequestBody Regional regional) {
		return regionalRepository.save(regional);
	}
	@PostMapping("/regional")
	@PreAuthorize("hasRole('adm')")
	public Regional createRegional(@RequestBody Regional regional) {
		return regionalRepository.save(regional);
	}

}
