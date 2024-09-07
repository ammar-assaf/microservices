# mysql/Dockerfile
FROM mysql:latest
ENV MYSQL_ROOT_PASSWORD=Admin@123
ENV MYSQL_DATABASE=mydb
ENV MYSQL_USER=admin
ENV MYSQL_PASSWORD=Admin@123
COPY init.sql /docker-entrypoint-initdb.d/
EXPOSE 3306
