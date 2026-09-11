# Integración de Resiliencia en el Core de Pagos

El sistema de pagos de la institución financiera necesita ser robusto y escalable para manejar hasta 10 000 transacciones por segundo con un SLA del 99.99%. El sistema interactúa con múltiples servicios externos, incluyendo un motor antifraude, un buró de riesgos y un gateway de pagos. El objetivo es aplicar al menos dos métodos de tolerancia a fallos para asegurar que el sistema pueda manejar fallos temporales en los servicios externos sin afectar la disponibilidad del core de pagos.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Construcción de Servicios REST Robustos y Escalables |
| **Nivel** | senior-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 15 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Exploración del Sistema de Pagos

**Objetivo:** Comprender las interacciones críticas y los puntos de falla del sistema de pagos.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Identifica los servicios externos con los que interactúa el core de pagos.
- Establece los umbrales de latencia y disponibilidad para cada interacción.
- Enumera los posibles modos de falla para cada servicio externo.

**Entregable:** Mapa de interacciones del core de pagos con servicios externos, incluyendo umbrales y modos de falla.

<details>
<summary>Pistas de conocimiento</summary>

- Considera los impactos de la latencia y la disponibilidad en la experiencia del usuario.
- Piensa en cómo los fallos en servicios externos pueden propagarse al core de pagos.

</details>

### Fase 2: Implementación de CircuitBreaker

**Objetivo:** Aplicar un método de tolerancia a fallos para manejar fallos temporales en servicios externos.

**Tiempo estimado:** 5 horas

**Instrucciones:**

- Selecciona un servicio externo crítico y aplica el patrón CircuitBreaker.
- Define los umbrales de fallo y las condiciones para abrir/cerrar el circuito.
- Implementa la lógica de CircuitBreaker y verifica su funcionamiento.

**Entregable:** CircuitBreaker configurado y funcionando para un servicio externo crítico.

<details>
<summary>Pistas de conocimiento</summary>

- Considera la frecuencia de invocación del servicio y los tiempos de recuperación típicos.
- Piensa en cómo el CircuitBreaker puede afectar la latencia percibida por el usuario.

</details>

### Fase 3: Implementación de Retry y Fallback

**Objetivo:** Aplicar métodos adicionales de tolerancia a fallos para mejorar la resiliencia del sistema.

**Tiempo estimado:** 5 horas

**Instrucciones:**

- Selecciona otro servicio externo crítico y aplica los patrones Retry y Fallback.
- Define las condiciones para reintentar y las respuestas de fallback.
- Implementa la lógica de Retry y Fallback y verifica su funcionamiento.

**Entregable:** Patrones Retry y Fallback configurados y funcionando para un servicio externo crítico.

<details>
<summary>Pistas de conocimiento</summary>

- Considera la latencia adicional que pueden introducir los reintentos.
- Piensa en cómo las respuestas de fallback pueden afectar la consistencia de los datos.

</details>

### Fase 4: Integración y Validación

**Objetivo:** Integrar y validar los métodos de tolerancia a fallos en el core de pagos.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Integra los patrones CircuitBreaker, Retry y Fallback en el core de pagos.
- Realiza pruebas de carga y fallos para validar la resiliencia del sistema.
- Documenta los resultados y las decisiones tomadas.

**Entregable:** Core de pagos con métodos de tolerancia a fallos integrados y validados, junto con documentación de resultados y decisiones.

<details>
<summary>Pistas de conocimiento</summary>

- Considera la interacción entre los diferentes patrones de tolerancia a fallos.
- Piensa en cómo los resultados de las pruebas pueden informar futuras mejoras en el sistema.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es el patrón CircuitBreaker y cómo se aplica en el contexto del core de pagos?
- **paraQueSirve**: ¿Para qué sirve el patrón Retry en el contexto de la integración con servicios externos?
- **comoSeUsa**: ¿Cómo se usa el patrón Fallback para manejar fallos en servicios externos?
- **erroresComunes**: ¿Cuáles son los errores comunes al implementar patrones de tolerancia a fallos?
- **queDecisionesImplica**: ¿Qué decisiones implica la selección y configuración de patrones de tolerancia a fallos en el core de pagos?

## Criterios de Evaluacion

- Identificación correcta de servicios externos críticos y sus umbrales de rendimiento.
- Implementación efectiva del patrón CircuitBreaker con umbrales y condiciones adecuados.
- Implementación efectiva de los patrones Retry y Fallback con condiciones y respuestas adecuadas.
- Integración y validación exitosa de los patrones de tolerancia a fallos en el core de pagos.
- Documentación clara y completa de los resultados y decisiones tomadas.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT). Devuelve un ZIP con el proyecto. Sirve si no tenes un agente en el IDE.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn clean compile
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
