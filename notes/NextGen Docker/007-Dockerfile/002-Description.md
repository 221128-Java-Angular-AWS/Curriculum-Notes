- A Dockerfile is a script that carries out different commands and actions to build a Docker image, which can then be used to deploy a Docker container. 
- The commands and information within the Dockerfile can be configured to use specific software versions and dependencies for stable deployments. You can also use a Docker registry to store and access your public (or private) Docker images.
- Once a Dockerfile is written, you can use the docker build command to generate a Docker image based on the Dockerfile’s instructions. Then, you can deploy a container based on the image with commands like docker run or docker create.
- Here are common instructions that you can use in your Dockerfiles to build images:
 - Basic Definitions
  * FROM: Define the base image, such as ubuntu or Debian, used to start the build process. Required for each Dockerfile.
  * MAINTAINER: Define the full name and email address of the image creator.
Variables
  * ENV: Set environment variables that persist when the container is deployed.
  * ARG: Set a passable build-time variable. Can be used as an alternative to ENV to create a variable that does not persist when the container is deployed from the image.
Command Execution
  * RUN: Execute commands, such as package installation commands, on a new image layer.
  * CMD: Execute a specific command within the container that is deployed with the image, or set default parameters for an ENTRYPOINT instruction. Only one is used per Dockerfile.
  * ENTRYPOINT: Set a default application to be used every time a container is deployed with the image. Only one is used per Dockerfile.
  * USER: Set the UID (the username) to run commands in the container.
  * WORKDIR: Set the container path where subsequent Dockerfile commands are executed
