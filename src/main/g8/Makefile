#!make
include .env

help:
	@echo "login   - log in to specified Docker repository"
	@echo "pack    - sbt pack the specified project"
	@echo "build   - build the specified image"
	@echo "rebuild - rebuild the specified image with sbt pack and docker"
	@echo "          build with --no-cache flag"
	@echo "itgo    - shorthand for pack, build, push, show"
	@echo "run     - run the specified project locally"
	@echo "push    - push the  image to specified Docker repository"
	@echo "show    - show the current make variables"
login:
	docker login $(DOCKER_REPO_URL) -u $(DOCKER_REPO_USER)
pack:
	sbt pack
build:
	docker image build -t $(IMAGE) -f Dockerfile --build-arg PROJECT=$(TAGNAME) --build-arg UID=$(UID) .
rebuild:
	make pack
	docker image build --no-cache -t $(IMAGE) -f Dockerfile --build-arg PROJECT=$(TAGNAME) --build-arg UID=$(UID) .
itgo:
	make pack
	make build
	make push
	make show
run:
	./$(TAGNAME)/target/pack/bin/$(TAGNAME)
push:
	docker push $(IMAGE)
show:
	@echo "#make file configuration"
	@echo "#PLATFORM         : " $(PLATFORM)
	@echo "#DOCKER_REPO_USER : " $(DOCKER_REPO_USER)
	@echo "#UID              : " $(UID)
	@echo "#DOCKER_REPO_URL  : " $(DOCKER_REPO_URL)
	@echo "#TAGNAME          : " $(TAGNAME)
	@echo "#IMAGE            : " $(IMAGE)
	@echo "#VERSION          : " $(VERSION)
