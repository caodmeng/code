# zipkin-builder

This image is for internal use only for building other Docker images. It refreshes a
cache of maven and npm dependencies so downstream builds do not have to do so every build.

Normally, zipkin-builder is updated as part of the normal master build of zipkin-server. This
means it accumulates old dependencies over time. If the image disappears for any reason, or it has
accumulated too much cruft, it can be refreshed with

```bash
$ docker login
$ docker build -t openzipkin/zipkin-builder -f docker/builder/Dockerfile .
$ docker push openzipkin/zipkin-builder 
```

We'll add a weekly cron at some point to do this automatically.
