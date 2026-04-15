FROM ubuntu:latest
LABEL authors="junio"

ENTRYPOINT ["top", "-b"]