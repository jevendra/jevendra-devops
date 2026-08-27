# Food Ordering DevOps Project

Java Spring Boot + MySQL + HTML/CSS/JavaScript application prepared for DevOps practice.

## Run locally
1. Start MySQL and create database `foodapp`.
2. Run `mvn clean package`
3. Run `mvn spring-boot:run`
4. Open http://localhost:8080

## Docker
mvn clean package
docker compose up --build

## API
GET /api/foods
POST /api/foods
GET /actuator/health

## Git
git init
git add .
git commit -m "Initial food ordering application"
git branch -M main
git remote add origin YOUR_GITHUB_REPOSITORY_URL
git push -u origin main
