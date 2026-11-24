package cl.usm.narcisistaapi.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import cl.usm.narcisistaapi.entities.Resultado;

class NarcisistaServiceTest {

	private final NarcisistaService service = new NarcisistaService();

	@Test
	void numeroNarcisista() {
		Resultado resultado = service.verificar(153);
		assertTrue(resultado.narcisista());
		assertEquals(3, resultado.digitos());
		assertEquals(153, resultado.suma());
	}

	@Test
	void numeroNoNarcisista() {
		Resultado resultado = service.verificar(154);
		assertFalse(resultado.narcisista());
		assertEquals(190, resultado.suma());
	}

	@Test
	void unDigitoSiempreEsNarcisista() {
		assertTrue(service.verificar(7).narcisista());
	}

	@Test
	void ceroEsNarcisista() {
		assertTrue(service.verificar(0).narcisista());
	}

	@Test
	void narcisistaDeCuatroDigitos() {
		assertTrue(service.verificar(9474).narcisista());
	}

	@Test
	void numeroNegativo() {
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> service.verificar(-5));
		assertEquals("El numero no puede ser negativo", e.getMessage());
	}

	@Test
	void listarHastaMil() {
		assertEquals(List.of(0L, 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 153L, 370L, 371L, 407L), service.listar(1000));
	}

	@Test
	void listarConLimiteNegativo() {
		assertThrows(IllegalArgumentException.class, () -> service.listar(-1));
	}

	@Test
	void listarSobreElLimite() {
		assertThrows(IllegalArgumentException.class, () -> service.listar(NarcisistaService.LIMITE_LISTA + 1));
	}

}
