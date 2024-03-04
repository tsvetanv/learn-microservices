#!/bin/sh

# There are 2 ways to run the repackaged microservices' JARs by Spring Boot Maven Plugin:
# 1. mvn spring-boot:run
# 2. java -jar path/to/target.jar -> execute it iterating over JAR file of every microservice

# cleanup
if [ -d "pids" ]; then
    echo "Cleanup 'pids' directory."
    rm -r "pids"
fi
mkdir "pids"

java -jar ../eureka-server/target/eureka-server-1.0-SNAPSHOT.jar & echo $! > ./pids/eureka-server-pid.file &
java -jar ../api-gateway/target/api-gateway-1.0-SNAPSHOT.jar & echo $! > ./pids/api-gateway-pid.file &
java -jar ../customer/target/customer-1.0-SNAPSHOT.jar & echo $! > ./pids/customer-pid.file &
java -jar ../fraud/target/fraud-1.0-SNAPSHOT.jar & echo $! > ./pids/fraud-pid.file &
java -jar ../notification/target/notification-1.0-SNAPSHOT.jar & echo $! > ./pids/notification-pid.file &