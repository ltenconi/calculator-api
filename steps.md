# validate
mvn validate

# compile
mvn compile

# test
mvn test

# Static code analysis
mvn verify org.sonarsource.scanner.maven:sonar-maven-plugin:sonar

# Build Package
mvn -B -DskipTests clean package

# Build Image
IMAGE=govindarajanv/calculatorapi
VERSION=1.0.0
ID=$(docker build -q -t $IMAGE .)
docker tag $ID $IMAGE:$VERSION

# Integration/Contract Test
docker run -d -p 8080:8080 $IMAGE:$VERSION
result=$(curl -s http://localhost:8080/addition/1/2/ |jq ".result")
if [ $result -ne 3 ]; then
	echo "Integration/contract testing failed"
fi

# publish artifacts to GHE
# Publish image
docker push $IMAGE:$VERSION
docker tag $ID $IMAGE:latest
docker push $IMAGE:latest
