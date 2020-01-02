FROM harbor.iquantex.com/base_images/openjdk:8u212-jre-alpine
LABEL MAINTAINER="shengquan"
COPY entrypoint.sh /entrypoint.sh
COPY app.jar /opt/deployments/app.jar
WORKDIR /opt/deployments
RUN chmod +x /entrypoint.sh \
    && chgrp -R 0 /opt/deployments/ \
    && chmod -R g=u /opt/deployments \
    && addgroup daemon root \
    && chmod g+w /etc/passwd
ENTRYPOINT ["/entrypoint.sh"]
CMD ["--","java","-jar","-XX:+UnlockExperimentalVMOptions","-XX:+UseCGroupMemoryLimitForHeap","-XX:MaxRAMFraction=2","-XshowSettings:vm","/opt/deployments/app.jar"]
