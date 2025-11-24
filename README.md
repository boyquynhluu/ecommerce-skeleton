# E-commerce Skeleton (WebFlux + Kafka + Redis + Eureka + Gateway)

## Prerequisites
- JDK 21
- Gradle 8.6+ (or add Gradle wrapper)
- Docker & Docker Compose

## First build
```bash
# from repo root
./gradlew clean build -x test
```

## Start infra + services
```bash
docker compose up --build
```

## Test
- Eureka: http://localhost:8761
- Gateway:
  - http://localhost:8080/ping (gateway itself won't have a ping; try services through routes)
  - http://localhost:8080/api/catalog/ping
  - http://localhost:8080/api/orders/ping
  - http://localhost:8080/api/inventory/ping
```

## Next steps
- Add entities, repositories (R2DBC), Kafka topics, and reactive handlers.
- Introduce proper security (JWT) on Gateway & services.
- Configure Prometheus/Grafana, OpenTelemetry, Resilience4j if needed.
