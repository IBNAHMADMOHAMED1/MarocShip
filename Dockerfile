## From : pull the base image from Docker Hub
## RUN : execute the command
## CMD : execute the command when the container starts
### EXPOSE : expose the port that the container is listening on
### WORKDIR : set the working directory
### COPY : copy the file  your local machine to the container
### ADD : copy the file from the host to the container (you can also use it to download the file from git...)
### ENTRYPOINT : execute the command when the container starts
### VOLUME : mount the volume to the container
### ENV : set the environment variable : ENV <key> <value>

##   version: '3.5'
   #  services:
   #    jboss:
   #      image: quay.io/wildfly/wildfly
   #      ports:
   #        - 8084:8080
   #      volumes:
   #        - ./target/marocShip_1-1.0-SNAPSHOT.war:/opt/jboss/wildfly/standalone/deployments/ROOT.war
   #    postgres:
   #      image: postgres
   #      container_name: postgres-container
   #      volumes:
   #        - C:\Users\youcode\Desktop\datat:/var/lib/postgresql/data
   #      environment:
   #        - POSTGRES_PASSWORD=postgres
   #        - POSTGRES_DB=123456
   #      ports:
   #        - 5432:5432
   #      restart:
   #        always






