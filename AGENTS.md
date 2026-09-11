# AGENTS.md

Instrucciones para el agente de IA que abra este repositorio (Claude Code, Cursor, Codex, Copilot, Gemini). Se cargan solas: no hay que pegar nada en ningun chat.

## Que es este repositorio

Es el codigo base de un reto de aprendizaje de Pragma: **Integración de Resiliencia en el Core de Pagos**.

| | |
|---|---|
| Tema | Construcción de Servicios REST Robustos y Escalables |
| Nivel | senior-l2 |
| Chapter | Backend |
| Especialidad | Java |
| Stack | Java 21 / Spring Boot 3.4 |
| Patron arquitectonico | hexagonal/clean |
| Tiempo estimado | 15 horas |

## Tu tarea

Dejar este proyecto en estado **verificable**: que el comando de verificacion corra sin errores. Escribi los archivos en disco, en este repositorio. No generes ZIPs ni archivos adjuntos.

En orden:

1. Corre `mvn clean compile` y mira que falla.
2. Completa lo que falte de la lista de abajo: manifiesto de dependencias, punto de entrada, capa de interfaz y las capas del patron declarado.
3. Arregla SOLO los errores que impiden compilar o arrancar.
4. Volve a correr `mvn clean compile` hasta que pase.
5. Pará ahí.

## Regla dura: las fases son trabajo del humano

**PROHIBIDO implementar los entregables de las fases.** El valor del reto esta en que la persona los resuelva. Tu trabajo es que tenga un proyecto que arranca; el hueco pedagogico se queda como esta.

No resuelvas nada de esto:

- **Fase 1 — Exploración del Sistema de Pagos**: Mapa de interacciones del core de pagos con servicios externos, incluyendo umbrales y modos de falla.
- **Fase 2 — Implementación de CircuitBreaker**: CircuitBreaker configurado y funcionando para un servicio externo crítico.
- **Fase 3 — Implementación de Retry y Fallback**: Patrones Retry y Fallback configurados y funcionando para un servicio externo crítico.
- **Fase 4 — Integración y Validación**: Core de pagos con métodos de tolerancia a fallos integrados y validados, junto con documentación de resultados y decisiones.

Distincion operativa:

- **Arreglar** (si): import faltante, tipo que no existe, dependencia sin declarar, error de sintaxis, archivo referenciado que no existe.
- **No tocar** (no): logica de negocio incompleta, validaciones ausentes, secretos hardcodeados, APIs deprecadas que funcionan, concurrencia insegura, patrones mejorables. Eso es lo que la persona tiene que encontrar.

## Estado del proyecto

### Archivos declarados: todos presentes

Estan los archivos que la arquitectura declara. Igual corre el comando de verificacion: que existan no garantiza que compilen.

### Presentes (8)

- `pom.xml`
- `src/main/resources/application.yml`
- `src/main/java/com/pragma/corepagos/domain/model/Payment.java`
- `src/main/java/com/pragma/corepagos/application/usecase/ProcessPaymentUseCase.java`
- `src/main/java/com/pragma/corepagos/infrastructure/adapters/external/AntifraudServiceAdapter.java`
- `src/main/java/com/pragma/corepagos/infrastructure/adapters/external/PaymentGatewayAdapter.java`
- `src/main/java/com/pragma/corepagos/infrastructure/config/ResilienceConfig.java`
- `src/main/java/com/pragma/corepagos/infrastructure/controller/PaymentController.java`

### Capas del patron declarado

Cada una tiene que existir como directorio real con al menos un archivo. Codigo plano en la raiz no satisface el patron.

- `src/main/java/com/pragma/corepagos/domain`
- `src/main/java/com/pragma/corepagos/application`
- `src/main/java/com/pragma/corepagos/infrastructure`
- `src/main/resources`

## Verificacion

```bash
mvn clean compile
```

Ese comando pasando es la definicion de "terminado" para vos.

## Convenciones que tenes que respetar

- Un solo ecosistema: no declares librerias de otro lenguaje ni mezcles gestores de paquetes.
- Toda libreria que uses tiene que estar declarada en el manifiesto de dependencias.
- Todo import declarado tiene que usarse; todo tipo usado tiene que existir o venir de una dependencia declarada.
- El patron es **hexagonal/clean**: los contratos (interfaces, puertos) los define la capa interna y los implementa la externa, nunca al revés.
- Los archivos que crees llevan implementacion real, no stubs: sin `TODO`, sin cuerpos vacios, sin `// getters y setters`.

## Contexto del candidato

Sirve para calibrar el nivel del codigo, no para resolver las fases.

- Perfil: Chapter Backend, Especialidad Desarrollador, Tecnología Java, Senior L2
- Brecha que el reto ataca: Aplica al menos dos metodos de tolerancia a fallos a traves de codigo, como CircuitBreaker, Retry, Fallback y RateLimit
- Mision: Integrar un modelo de resiliencia en el core de pagos

---

*Generado por Challenge Generator — Pragma. `README.md` tiene el enunciado completo del reto para la persona. `PROMPT_MEJORA.md` es la variante para pegar en un chat, si se prefiere ese flujo.*
