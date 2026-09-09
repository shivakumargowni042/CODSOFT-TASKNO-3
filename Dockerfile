FROM eclipse-temurin:17-jdk AS build
WORKDIR /app
COPY src/ src/
RUN mkdir -p out && javac -encoding UTF-8 -d out src/*.java

FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/out out/
RUN mkdir -p data
ENV DATA_DIR=data
ENV PORT=8080
EXPOSE 8080
CMD ["java", "-cp", "out", "src.Server"]
