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

import br.com.fiap.microservicegs.model.Veiculo;
import br.com.fiap.microservicegs.repository.VeiculoRepository;

@RestController
public class VeiculoController {

	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@GetMapping("/veiculo/{id}")
	@PreAuthorize("hasRole('adm')")
	public Optional<Veiculo> getVeiculo(@PathVariable(value ="id") long id) {
		return veiculoRepository.findById(id);
	}
	@GetMapping("/veiculo")
	@PreAuthorize("hasRole('adm')")
	public List<Veiculo> getAllVeiculos() {
		return veiculoRepository.findAll();
	}
	
	@DeleteMapping("/veiculo")
	@PreAuthorize("hasRole('adm')")
	public void removeVeiculo(@RequestBody Veiculo veiculo) {
		veiculoRepository.delete(veiculo);
	}
	
	@PutMapping("/veiculo")
	@PreAuthorize("hasRole('adm')")
	public Veiculo putVeiculo(@RequestBody Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	}
	@PostMapping("/veiculo")
	@PreAuthorize("hasRole('adm')")
	public Veiculo createVeiculo(@RequestBody Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	}
	
}
