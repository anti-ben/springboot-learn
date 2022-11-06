# SpringBoot with Prometheus & Grafana for monitoring

## Quick Start

First, you need to change the ip to your ip in the **prometheus.yaml**.

Then,

```bash
mvn clean install
mvn spring-boot:run

# check
docker-compose config
# start in the bg
docker-compose up -d
# stop
docker-compose down
```

At last, open your browser to
- http://localhost:8080/actuator/prometheus (admin:admin)
- http://localhost:9090
- http://localhost:3000

## tips

https://grafana.com/grafana/dashboards/
