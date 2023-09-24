mvn clean install
mvn clean package

docker stop java-container
docker rm -f java-container
docker rmi -f java-microservice

docker build -t java-microservice .
docker run -d  -p 8081:8081 --name java-container  java-microservice


