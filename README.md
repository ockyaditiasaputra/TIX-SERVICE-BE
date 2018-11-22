# TIX SERVICE

## Requirement :
- Redis
- MongoDB
- Kafka

## Install using default profile
```
mvn -U clean install
```

## Install using custom profile
```
mvn -U -Dspring.profiles.active={dev/local} clean install
```

## Install with generated jacoco report
```
mvn -U jacoco:prepare-agent clean install jacoco:report
```

## Install with generated jacoco report & push to sonar qube
```
mvn -U jacoco:prepare-agent clean install jacoco:report sonar:sonar -Dsonar.host.url=http://localhost:9000 -Dsonar.login=9b021b09a1323a1aca60c60cf65198affe119383
```
