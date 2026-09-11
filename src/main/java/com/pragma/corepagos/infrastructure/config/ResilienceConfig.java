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