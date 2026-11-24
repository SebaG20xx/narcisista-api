package cl.usm.narcisistaapi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.usm.narcisistaapi.services.NarcisistaService;

@RestController
@CrossOrigin
public class NarcisistaController {

	private final NarcisistaService narcisistaService;

	public NarcisistaController(NarcisistaService narcisistaService) {
		this.narcisistaService = narcisistaService;
	}

	@GetMapping("/verificar")
	public ResponseEntity<Object> verificar(@RequestParam long numero) {
		try {
			return ResponseEntity.ok(narcisistaService.verificar(numero));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping("/listar")
	public ResponseEntity<Object> listar(@RequestParam long hasta) {
		try {
			return ResponseEntity.ok(narcisistaService.listar(hasta));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}
