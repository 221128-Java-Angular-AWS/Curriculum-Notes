## Description
A Docker image is a blueprint for a Docker container. Similar to the way a Java class is a blueprint for instantiating Java objects. These images are described by a dockerfile and composed into a binary file which can then be run as a container by the Docker engine.

Images form a kind of heirarchy of layers. One image can be `FROM` a parent, and inherit it's properties. When inheriting `FROM` another image we can add in additional info, dependencies, commands, applications, etc. This creates a new image which could be thought of as the parent image with a new layer on top. Each layer is an image itself, and is made up of the previous layer and changes to that layer.

## Managing Images 

We can use the docker CLI to manage the images on our local system. We can list out the existing images, get their details, remove, and update them. Additionally, we can use the CLI to aid in connecting to a registry to quickly and easily distribute changes. In this case updating the software is as simple as updating the image. Users can easily pull new images and spin up containers/applications with the modifications made. 