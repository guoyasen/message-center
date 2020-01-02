FROM 192.168.41.41:5000/msa/openjdk:1.8.201
ENV TZ=Asia/Shanghai
VOLUME /tmp
ADD ./target/app.jar app.jar
ADD ./docker/cfg/  ./cfg

USER root
RUN chown -R msaadm:msaadm /home/msaadm
USER msaadm
ENTRYPOINT java -jar -Xmx${MEMORY_MB}m -Xms${MEMORY_MB}m -Denv=${APOLLO_ENV} -D${APOLLO_ENV}_meta=${APOLLO} app.jar
