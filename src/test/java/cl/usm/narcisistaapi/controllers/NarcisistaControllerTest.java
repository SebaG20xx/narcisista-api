package cl.usm.narcisistaapi.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import cl.usm.narcisistaapi.entities.Resultado;
import cl.usm.narcisistaapi.services.NarcisistaService;

class NarcisistaControllerTest {

	private final NarcisistaController controller = new NarcisistaController(new NarcisistaService());

	@Test
	void verificarOk() {
		ResponseEntity<Object> respuesta = controller.verificar(370);
		assertEquals(HttpStatus.OK, respuesta.getStatusCode());
		assertEquals(new Resultado(370, 3, 370, true), respuesta.getBody());
	}

	@Test
	void verificarConError() {
		ResponseEntity<Object> respuesta = controller.verificar(-1);
		assertEquals(HttpStatus.BAD_REQUEST, respuesta.getStatusCode());
		assertEquals("El numero no puede ser negativo", respuesta.getBody());
	}

	@Test
	void listarOk() {
		ResponseEntity<Object> respuesta = controller.listar(5);
		assertEquals(HttpStatus.OK, respuesta.getStatusCode());
		assertEquals(List.of(0L, 1L, 2L, 3L, 4L, 5L), respuesta.getBody());
	}

	@Test
	void listarConError() {
		ResponseEntity<Object> respuesta = controller.listar(-1);
		assertEquals(HttpStatus.BAD_REQUEST, respuesta.getStatusCode());
	}

}
