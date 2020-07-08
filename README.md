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
    "username": "marksmith",
    "firstname": "Mark",
    "lastname": "Smith",
    "mobile": "4169084567",
    "email": "mark.smith@xyz.com",
    "address": "100 Bay St Toronto, ON Q1J 7S2 CA",
    "telephone": "6476785678",
    "password": "Canada"
}

Test with curl:

curl -X POST -d @testdata/register1.json http://localhost:8080/userreg/user/register --header "Content-Type:application/json"

curl -X GET http://localhost:8080/userreg/users/findAll --header "Content-Type:application/json"

curl -X DELETE http://localhost:8080/userreg/user/1 --header "Content-Type:application/json"

Linux/UNIX:

Successful authentication:

curl -X POST -d '{"username":"marksmith","password":"Canada"}' http://localhost:8080/userreg/user/authenticate --header "Content-Type:application/json"

Failed authentication:

curl -X POST -d '{"username":"marksmith","password":"Europe"}' http://localhost:8080/userreg/user/authenticate --header "Content-Type:application/json"

Windows:

Successful authentication:

curl -X POST -d "{\"username\":\"marksmith\",\"password\":\"Canada\"}" http://localhost:8080/userreg/user/authenticate git status
--header "Content-Type:application/json"

Failed authentication:

curl -X POST -d "{\"username\":\"marksmith\",\"password\":\"Europe\"}" http://localhost:8080/userreg/user/authenticate --header "Content-Type:application/json"

Swagger doc URL:

http://localhost:8080/swagger-ui.html

