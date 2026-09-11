# Prompt para Mejorar el Codigo Base

Copia y pega el siguiente contenido completo en un asistente de IA (Claude, ChatGPT, etc.)
para obtener un ZIP con el proyecto arrancable. Si el adjunto es una carcasa (docs/placeholders),
el asistente debe materializar la estructura del stack del briefing, sin resolver las fases del reto.

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Backend, Especialidad Desarrollador, Tecnología Java, Senior L2

### Brecha de conocimiento
Aplica al menos dos metodos de tolerancia a fallos a traves de codigo, como CircuitBreaker, Retry, Fallback y RateLimit

### Misión / candidato
Integrar un modelo de resiliencia en el core de pagos

### Datos adicionales
Candidato con 5 años de experiencia, equipo distribuido

### Reto
- Tema: Construcción de Servicios REST Robustos y Escalables
- Seniority: senior-l2
- Tipo: practical
- Título: Integración de Resiliencia en el Core de Pagos
- Tiempo estimado: 15 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Exploración del Sistema de Pagos — objetivo: Comprender las interacciones críticas y los puntos de falla del sistema de pagos. — entregable (NO resolver): Mapa de interacciones del core de pagos con servicios externos, incluyendo umbrales y modos de falla.
- Fase 2: Implementación de CircuitBreaker — objetivo: Aplicar un método de tolerancia a fallos para manejar fallos temporales en servicios externos. — entregable (NO resolver): CircuitBreaker configurado y funcionando para un servicio externo crítico.
- Fase 3: Implementación de Retry y Fallback — objetivo: Aplicar métodos adicionales de tolerancia a fallos para mejorar la resiliencia del sistema. — entregable (NO resolver): Patrones Retry y Fallback configurados y funcionando para un servicio externo crítico.
- Fase 4: Integración y Validación — objetivo: Integrar y validar los métodos de tolerancia a fallos en el core de pagos. — entregable (NO resolver): Core de pagos con métodos de tolerancia a fallos integrados y validados, junto con documentación de resultados y decisiones.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (ZIP).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.pragma</groupId>
    <artifactId>corepagos</artifactId>
    <version>1.0-SNAPSHOT</version>
    <name>corepagos</name>
    <description>Core de Pagos Robusto y Escalable</description>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.4</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <properties>
        <java.version>21</java.version>
    </properties>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-webflux</artifactId>
        </dependency>
        <dependency>
            <groupId>io.github.resilience4j</groupId>
            <artifactId>resilience4j-spring-boot2</artifactId>
            <version>1.7.1</version>
        </dependency>
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <version>42.7.0</version>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/main/resources/application.yml ===
server:
  port: 8080

spring:
  application:
    name: corepagos

resilience4j:
  circuitbreaker:
    configs:
      default:
        registerHealthIndicator: true
        failureRateThreshold: 50
        waitDurationInOpenState: 10000
        slidingWindowSize: 10
        minimumNumberOfCalls: 5
        permittedNumberOfCallsInHalfOpenState: 3
        automaticTransitionFromOpenToHalfOpenEnabled: true
  retry:
    configs:
      default:
        enabled: true
        maxAttempts: 3
        waitDuration: 1000
  timelimit:
    configs:
      default:
        timeoutDuration: 2000
  bulkhead:
    configs:
      default:
        maxConcurrentCalls: 10
        maxWaitDuration: 500ms

endpoints:
  payment:
    path: /payments
    method: POST


// === ARCHIVO: src/main/java/com/pragma/corepagos/domain/model/Payment.java ===
package com.pragma.corepagos.domain.model;

import com.pragma.corepagos.domain.exception.InvalidPaymentException;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.Instant;

public class Payment {

    @NotNull
    @Size(min = 1, max = 50)
    private String paymentId;

    @NotNull
    @Size(min = 1, max = 50)
    private String customerId;

    @NotNull
    @Positive
    private BigDecimal amount;

    @NotNull
    private Instant timestamp;

    public Payment(String paymentId, String customerId, BigDecimal amount) {
        if (paymentId == null || paymentId.trim().isEmpty()) {
            throw new InvalidPaymentException("Payment ID cannot be null or empty");
        }
        if (customerId == null || customerId.trim().isEmpty()) {
            throw new InvalidPaymentException("Customer ID cannot be null or empty");
        }
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidPaymentException("Amount must be positive");
        }
        this.paymentId = paymentId;
        this.customerId = customerId;
        this.amount = amount;
        this.timestamp = Instant.now();
    }

    public String getPaymentId() {
        return paymentId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId='" + paymentId + "'," +
                "customerId='" + customerId + "'," +
                "amount=" + amount +
                ", timestamp=" + timestamp +
                '}';
    }
}


// === ARCHIVO: src/main/java/com/pragma/corepagos/application/usecase/ProcessPaymentUseCase.java ===
package com.pragma.corepagos.application.usecase;

import com.pragma.corepagos.domain.model.Payment;
import com.pragma.corepagos.infrastructure.adapters.external.AntifraudServiceAdapter;
import com.pragma.corepagos.infrastructure.adapters.external.PaymentGatewayAdapter;
import com.pragma.corepagos.domain.exception.InvalidPaymentException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import org.springframework.stereotype.Service;

@Service
public class ProcessPaymentUseCase {

    private final AntifraudServiceAdapter antifraudServiceAdapter;
    private final PaymentGatewayAdapter paymentGatewayAdapter;

    public ProcessPaymentUseCase(AntifraudServiceAdapter antifraudServiceAdapter, PaymentGatewayAdapter paymentGatewayAdapter) {
        this.antifraudServiceAdapter = antifraudServiceAdapter;
        this.paymentGatewayAdapter = paymentGatewayAdapter;
    }

    @CircuitBreaker(name = "payment", fallbackMethod = "fallbackProcessPayment")
    @Retry(name = "payment")
    @Bulkhead(name = "payment")
    public void processPayment(Payment payment) {
        if (payment == null) {
            throw new InvalidPaymentException("Payment cannot be null");
        }

        antifraudServiceAdapter.checkFraud(payment);
        paymentGatewayAdapter.processPayment(payment);
    }

    public void fallbackProcessPayment(Payment payment, Throwable t) {
        // Log the error and handle fallback logic
        System.err.println("Payment processing failed: " + t.getMessage());
    }
}

// === ARCHIVO: src/main/java/com/pragma/corepagos/infrastructure/adapters/external/AntifraudServiceAdapter.java ===
package com.pragma.corepagos.infrastructure.adapters.external;

import com.pragma.corepagos.domain.model.Payment;
import com.pragma.corepagos.domain.exception.InvalidPaymentException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import org.springframework.stereotype.Component;

@Component
public class AntifraudServiceAdapter {

    public AntifraudServiceAdapter() {
        // Constructor logic
    }

    @CircuitBreaker(name = "antifraud", fallbackMethod = "fallbackCheckFraud")
    @Retry(name = "antifraud")
    @Bulkhead(name = "antifraud")
    public void checkFraud(Payment payment) {
        if (payment == null) {
            throw new InvalidPaymentException("Payment cannot be null");
        }

        // Simulate external service call
        if ("fraud".equals(payment.getCustomerId())) {
            throw new InvalidPaymentException("Potential fraud detected");
        }
    }

    public void fallbackCheckFraud(Payment payment, Throwable t) {
        // Log the error and handle fallback logic
        System.err.println("Antifraud check failed: " + t.getMessage());
    }
}

// === ARCHIVO: src/main/java/com/pragma/corepagos/infrastructure/adapters/external/PaymentGatewayAdapter.java ===
package com.pragma.corepagos.infrastructure.adapters.external;

import com.pragma.corepagos.domain.model.Payment;
import com.pragma.corepagos.domain.exception.InvalidPaymentException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import org.springframework.stereotype.Component;

@Component
public class PaymentGatewayAdapter {

    public PaymentGatewayAdapter() {
        // Constructor logic
    }

    @CircuitBreaker(name = "paymentGateway", fallbackMethod = "fallbackProcessPayment")
    @Retry(name = "paymentGateway")
    @Bulkhead(name = "paymentGateway")
    public void processPayment(Payment payment) {
        if (payment == null) {
            throw new InvalidPaymentException("Payment cannot be null");
        }

        // Simulate external service call
        if ("error".equals(payment.getPaymentId())) {
            throw new InvalidPaymentException("Payment processing failed");
        }
    }

    public void fallbackProcessPayment(Payment payment, Throwable t) {
        // Log the error and handle fallback logic
        System.err.println("Payment gateway processing failed: " + t.getMessage());
    }
}

// === ARCHIVO: src/main/java/com/pragma/corepagos/infrastructure/config/ResilienceConfig.java ===
package com.pragma.corepagos.infrastructure.config;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import io.github.resilience4j.bulkhead.BulkheadConfig;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class ResilienceConfig {

    @Bean
    public Resilience4JCircuitBreakerFactory circuitBreakerFactory() {
        return new Resilience4JCircuitBreakerFactory().configureDefault(id -> new Resilience4JConfigBuilder(id)
               .circuitBreakerConfig(CircuitBreakerConfig.ofDefaults())
               .retryConfig(RetryConfig.custom()
                       .maxAttempts(3)
                       .waitDuration(Duration.ofSeconds(1))
                       .build())
               .timeLimiterConfig(TimeLimiterConfig.custom()
                       .timeoutDuration(Duration.ofSeconds(2))
                       .build())
               .bulkheadConfig(BulkheadConfig.custom()
                       .maxConcurrentCalls(10)
                       .maxWaitDuration(Duration.ofMillis(500))
                       .build())
               .build());
    }
}

// === ARCHIVO: src/main/java/com/pragma/corepagos/infrastructure/controller/PaymentController.java ===
package com.pragma.corepagos.infrastructure.controller;

import com.pragma.corepagos.application.usecase.ProcessPaymentUseCase;
import com.pragma.corepagos.domain.model.Payment;
import com.pragma.corepagos.domain.exception.InvalidPaymentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private ProcessPaymentUseCase processPaymentUseCase;

    @PostMapping
    public ResponseEntity<Payment> processPayment(@RequestBody Payment payment) {
        try {
            Payment processedPayment = processPaymentUseCase.process(payment);
            return new ResponseEntity<>(processedPayment, HttpStatus.CREATED);
        } catch (InvalidPaymentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
```
