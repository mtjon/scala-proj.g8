FROM adoptopenjdk:11-jre-openj9

ARG PROJECT
ARG UID
ARG GID=$UID
ARG USER=mtjon
ARG GROUP=$USER

ENV APP=$PROJECT

RUN groupadd -g $GID $GROUP \
 && useradd -u $UID -NM $USER

COPY $PROJECT/target/pack /opt/$PROJECT

USER $UID
WORKDIR /opt/$PROJECT

ENTRYPOINT sh ./bin/$APP
