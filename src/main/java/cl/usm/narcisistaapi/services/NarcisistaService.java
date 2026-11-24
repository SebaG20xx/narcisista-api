package cl.usm.narcisistaapi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import cl.usm.narcisistaapi.entities.Resultado;

@Service
public class NarcisistaService {

	public static final long LIMITE_LISTA = 1_000_000;

	/**
	 * Un numero es narcisista si es igual a la suma de sus digitos,
	 * cada uno elevado a la cantidad de digitos. Ej: 153 = 1^3 + 5^3 + 3^3.
	 */
	public Resultado verificar(long numero) {
		if (numero < 0) {
			throw new IllegalArgumentException("El numero no puede ser negativo");
		}
		int digitos = String.valueOf(numero).length();
		long suma = 0;
		long resto = numero;
		while (resto > 0) {
			suma += potencia(resto % 10, digitos);
			resto /= 10;
		}
		return new Resultado(numero, digitos, suma, suma == numero);
	}

	public List<Long> listar(long hasta) {
		if (hasta < 0 || hasta > LIMITE_LISTA) {
			throw new IllegalArgumentException("El limite debe estar entre 0 y " + LIMITE_LISTA);
		}
		List<Long> narcisistas = new ArrayList<>();
		for (long n = 0; n <= hasta; n++) {
			if (verificar(n).narcisista()) {
				narcisistas.add(n);
			}
		}
		return narcisistas;
	}

	private long potencia(long base, int exponente) {
		long resultado = 1;
		for (int i = 0; i < exponente; i++) {
			resultado *= base;
		}
		return resultado;
	}

}
