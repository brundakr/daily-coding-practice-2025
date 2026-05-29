# Kafka Learning Checklist — Java Full Stack Developer (4 YOE)

> Target Profile: Spring Boot + Angular + Java background, aiming for production-level Kafka knowledge.

---

## Phase 1 — Core Concepts (Theory First)

### Kafka Architecture
- [ ] What is Apache Kafka? Why use it over REST/DB polling?
- [ ] Topics, Partitions, Offsets
- [ ] Brokers, Clusters, Zookeeper vs KRaft (Kafka 3.x+)
- [ ] Producers and Consumers overview
- [ ] Consumer Groups and Group Coordination
- [ ] Replication Factor and Leader/Follower model
- [ ] ISR (In-Sync Replicas)

### Message Fundamentals
- [ ] Kafka record structure: Key, Value, Headers, Timestamp
- [ ] How partitioning works (key-based, round-robin)
- [ ] Message ordering guarantees (per-partition ordering)
- [ ] Retention policy (time-based, size-based)

---

## Phase 2 — Kafka Setup

- [ ] Install Kafka locally (Docker Compose preferred)
- [ ] Start Zookeeper + Kafka Broker manually
- [ ] Use Kafka CLI tools:
  - `kafka-topics.sh` — create, list, describe topics
  - `kafka-console-producer.sh` — send messages
  - `kafka-console-consumer.sh` — consume messages
  - `kafka-consumer-groups.sh` — check consumer lag
- [ ] Install **Kafka UI** (Conduktor or kafka-ui Docker image) for visual inspection

### Recommended Docker Compose Setup
```yaml
services:
  zookeeper:
    image: confluentinc/cp-zookeeper:7.5.0
    environment:
      ZOOKEEPER_CLIENT_PORT: 2181

  kafka:
    image: confluentinc/cp-kafka:7.5.0
    depends_on: [zookeeper]
    ports:
      - "9092:9092"
    environment:
      KAFKA_BROKER_ID: 1
      KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
      KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://localhost:9092
      KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR: 1

  kafka-ui:
    image: provectuslabs/kafka-ui:latest
    ports:
      - "8080:8080"
    environment:
      KAFKA_CLUSTERS_0_BOOTSTRAPSERVERS: kafka:9092
```

---

## Phase 3 — Spring Boot + Kafka Integration

### Dependencies (pom.xml)
- [ ] Add `spring-kafka` dependency
- [ ] Understand `application.properties` Kafka configs:
  - `bootstrap-servers`
  - `group-id`
  - `auto-offset-reset` (earliest / latest)
  - `key-deserializer` / `value-deserializer`

### Producer
- [ ] `KafkaTemplate<K, V>` — send messages
- [ ] Send with key for partition targeting
- [ ] `ProducerRecord` with headers
- [ ] Async send with `ListenableFuture` / `CompletableFuture`
- [ ] Producer configs: `acks`, `retries`, `idempotence`

### Consumer
- [ ] `@KafkaListener` — basic usage
- [ ] `@KafkaListener` with `ConsumerRecord<K, V>` for full metadata
- [ ] Manual Acknowledgment (`Acknowledgment.acknowledge()`)
- [ ] `AckMode`: BATCH, MANUAL, MANUAL_IMMEDIATE
- [ ] Consumer group assignment and rebalancing
- [ ] Error handling: `DefaultErrorHandler`, Dead Letter Topic (DLT)

### Serialization / Deserialization
- [ ] `StringSerializer` / `StringDeserializer`
- [ ] `JsonSerializer` / `JsonDeserializer` (with trusted packages)
- [ ] Avro + Schema Registry (advanced)

---

## Phase 4 — Intermediate Patterns

- [ ] **Dead Letter Queue (DLQ)**: Route failed messages to a `-dlt` topic
- [ ] **Retry with backoff**: `FixedBackOff`, `ExponentialBackOff`
- [ ] **Idempotent Producer**: prevent duplicate messages on retry
- [ ] **Exactly-once semantics (EOS)**: transactions in Kafka
- [ ] **Compacted Topics**: event sourcing for latest state per key
- [ ] **Partition assignment strategies**: RangeAssignor, RoundRobinAssignor
- [ ] **Offset management**: auto-commit vs manual commit
- [ ] **Consumer lag monitoring**

---

## Phase 5 — Real-World Project Ideas

### Project 1 — Order Processing System (Microservices)
- `order-service` (Producer): REST API → publishes to `orders` topic
- `inventory-service` (Consumer): listens to `orders`, updates stock
- `notification-service` (Consumer): listens to `orders`, sends email/SMS
- Topics: `orders`, `inventory-updates`, `notifications`

### Project 2 — Real-Time Dashboard
- Angular frontend polls a Spring Boot endpoint
- Spring Boot consumes from Kafka and pushes via WebSocket (STOMP)
- Demonstrates end-to-end: Kafka → Spring → Angular

### Project 3 — Event Sourcing
- Use compacted topics to store user profile change events
- Replay events to reconstruct state

---

## Phase 6 — Advanced Topics

- [ ] **Kafka Streams API**: stateful stream processing (joins, aggregations, windowing)
- [ ] **KSQL / ksqlDB**: SQL-like stream processing
- [ ] **Schema Registry + Avro**: enforce message contracts across services
- [ ] **Kafka Connect**: integrate with databases (Debezium CDC, JDBC Sink)
- [ ] **Transactions**: atomic produce across multiple topics
- [ ] **Multi-broker cluster setup**: replication, failover
- [ ] **Security**: SSL/TLS, SASL authentication, ACLs
- [ ] **Monitoring**: JMX metrics, Prometheus + Grafana, consumer lag alerts

---

## Phase 7 — Interview-Level Concepts

- [ ] Difference between Kafka and RabbitMQ / ActiveMQ
- [ ] How does Kafka guarantee ordering?
- [ ] What happens when a consumer crashes mid-processing?
- [ ] Explain at-least-once vs exactly-once delivery
- [ ] How to scale consumers? (add partitions = add consumers)
- [ ] What is consumer lag and how do you fix it?
- [ ] Explain rebalancing and its impact on throughput
- [ ] How does Kafka achieve high throughput? (sequential I/O, batching, compression)
- [ ] Kafka vs event-driven REST: when to use which?

---

## Suggested Learning Order (Week-by-Week)

| Week | Focus |
|------|-------|
| 1 | Phase 1 + 2: Theory + local setup + CLI |
| 2 | Phase 3: Spring Boot Producer + Consumer basics |
| 3 | Phase 4: Error handling, retries, DLT, manual ack |
| 4 | Phase 5: Build Order Processing project |
| 5 | Phase 5 cont: Add Angular WebSocket dashboard |
| 6 | Phase 6: Kafka Streams basics, Schema Registry |
| 7 | Phase 7: Interview prep + review advanced topics |

---

## Tools & Resources

| Tool / Resource | Link / Notes |
|----------------|--------------|
| Apache Kafka Docs | https://kafka.apache.org/documentation/ |
| Spring Kafka Docs | https://docs.spring.io/spring-kafka/docs/current/reference/html/ |
| Conduktor (Kafka UI) | https://www.conduktor.io/ |
| kafka-ui (Docker) | https://github.com/provectuslabs/kafka-ui |
| Udemy — Stéphane Maarek | Best Kafka course for Java devs |
| Confluent Dev Center | https://developer.confluent.io/ |

---

## Do I Need Two Separate Projects for Producer & Consumer?

**Short answer: No — but Yes for realistic practice.**

| Approach | When to Use |
|----------|-------------|
| **Single project** (both producer + consumer) | Start here. Good for learning the API quickly. |
| **Two separate Spring Boot apps** | Do this next. Simulates real microservices. Teaches decoupling, independent deployment, and consumer group behavior. |
| **Three+ services** | Final stage. Mimics production where one topic has multiple consumer services. |

**Recommended path:**
1. Start with one project — wire up `KafkaTemplate` and `@KafkaListener` in the same app.
2. Then split into two Spring Boot projects (`producer-service`, `consumer-service`) in the same Docker network.
3. Add a third consumer for notifications — you'll immediately see the power of fan-out.

> The real learning happens when you have **two independent consumers in different groups** both reading the same topic — that is the "aha moment" of Kafka.
