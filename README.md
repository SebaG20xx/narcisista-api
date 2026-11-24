# narcisista-api

API REST hecha con Spring Boot (Java 17) que verifica números narcisistas. Es el backend de `narcisista-web`.

Un número es narcisista cuando es igual a la suma de sus dígitos elevados a la cantidad de dígitos.
Ejemplo: 153 = 1³ + 5³ + 3³.

## Endpoints

| Método | Ruta                    | Respuesta                                                          |
|--------|-------------------------|--------------------------------------------------------------------|
| GET    | `/verificar?numero=153` | `{"numero":153,"digitos":3,"suma":153,"narcisista":true}`          |
| GET    | `/listar?hasta=1000`    | `[0,1,2,3,4,5,6,7,8,9,153,370,371,407]` (máximo `hasta=1000000`)   |

Si el número es negativo o el límite no es válido responde 400 con un mensaje.

## Comandos

```
mvn clean verify
ENTORNO=dev PUERTO=8090 docker compose -p narcisista-api-dev up -d --build
```

| Entorno | Rama       | Puerto |
|---------|------------|--------|
| dev     | feature/** | 8090   |
| prod    | release/** | 8091   |

La lista se calcula en el servidor, por eso `hasta` tiene un máximo de 1.000.000.
