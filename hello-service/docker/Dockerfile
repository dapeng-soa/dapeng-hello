FROM dapengsoa/dapeng-container:2.2.2
MAINTAINER dapengsoa@gmail.com

ENV CONTAINER_HOME /dapeng-container
ENV PATH $CONTAINER_HOME:$PATH
ENV PROJECT_NAME hello-service

RUN chmod +x ${CONTAINER_HOME}/bin/*.sh
WORKDIR ${CONTAINER_HOME}/bin
COPY ${PROJECT_NAME} ${CONTAINER_HOME}/apps/${PROJECT_NAME}/

ENTRYPOINT ["./startup.sh"]
