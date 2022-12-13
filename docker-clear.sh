docker stop $(docker ps --format "{{.Names}}" | grep dtest)
docker rm  $(docker ps -a --format "{{.Names}}" | grep dtest)
docker rmi $(docker images --format "{{.Repository}}:{{.Tag}}" | grep dtest)