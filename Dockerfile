FROM gcr.io/distroless/java:11-debug
SHELL ["/busybox/sh", "-c"]
WORKDIR /app
COPY build/libs/analytics-service.jar /app
CMD ["analytics-service.jar"]