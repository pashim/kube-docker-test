CLEAN ENVIRONMENT

sh docker-clear.sh
./docker-clear.bat

CRIBS

1. docker attach container - attach to existing container
2. docker run --rm - deletes container on stop
3. docker inspect - inspect container
4. docker image inspect - inspect image
5. docker cp - copy from host to container/container to host/container to container
6. docker images/volumes prune - deletes all unused images/volumes

VOLUMES
7. VOLUME in dockerfile (e.x. /app/feedback) creates anonymous volume which will be deleted after container stop
8. named volumes can be created by adding name prefix (feedback:/app/feedback) it will NOT be deleted after lifecycle of container
9. combining volumes is allowed. The longest path would take mount responsibility
10. volume host-path:container-path:ro -> read only, sub volume will override parent
11. bind mount is not managed by docker (you can't see it in docker volumes list)
12. docker run --env PORT=8080 / docker run -e PORT=8080 / --env-file ./env (env)
13. docker run --build-arg DEFAULT_PORT=8080 (only inside a docker file not in runtime)

NETWORK
