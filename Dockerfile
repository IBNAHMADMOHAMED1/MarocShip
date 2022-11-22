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

FROM quay.io/wildfly/wildfly:latest
COPY ./target /opt/jboss/wildfly/standalone/deployments/
##EXPOSE 8084







