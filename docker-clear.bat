docker stop $(docker ps --format "{{.Names}}" | findstr dtest)
docker rm  $(docker ps -a --format "{{.Names}}" | findstr dtest)
docker rmi $(docker images --format "{{.Repository}}:{{.Tag}}" | findstr dtest)
