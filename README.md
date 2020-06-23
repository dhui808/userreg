# userreg
User Registration with Spring Boot and Docker

Architecture
![Architecture](Architecture.png)

Build project:
./mvnw install dockerfile:build

Make sure your maven settings.xml includes your Docker credentials:
    <severs>
        <server>
            <id>docker.io</id>
            <username>your_docker_id</username>
            <password>your docker_password</password>
            <configuration>
                <email>your_email_address</email>
            </configuration>
        </server>
    </severs>
  
Push the image to dockerhub:
./mvnw dockerfile:push
or
docker push docker.io/dannyhui/userreg

Run application:
docker run -d -p 8080:8080 dannyhui/userreg

Test with Postman:
Create a POST request:
Headers:
	Content-Type: application/json
Body:
{
    "userName": "marksmith",
    "firstName": "Mark",
    "lastName": "Smith",
    "mobile": "4169084567",
    "email": "mark.smith@accenture.com",
    "address": "100 Bay St Toronto Q1J7S2 CA",
    "telephone": "6476785678"
}

Test with curl:
curl -X POST -d @testdata/register1.json http://localhost:8080/user/register --header "Content-Type:application/json"

Swagger doc URL:
http://localhost:8080/swagger-ui.html

