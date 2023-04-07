#
# Build stage
#
FROM openjdk:17.0.6
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]

# COPY . .
# RUN mvn clean package -DskipTests

# #
# # Package stage
# #
# FROM openjdk:11-jdk-slim
# COPY --from=build /target/demo-0.0.1-SNAPSHOT.jar demo.jar
# # ENV PORT=8080
# EXPOSE 8080
# ENTRYPOINT ["java","-jar","demo.jar"]
