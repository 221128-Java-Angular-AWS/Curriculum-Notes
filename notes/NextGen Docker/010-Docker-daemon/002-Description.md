The Docker daemon (dockerd) listens for Docker API requests and manages Docker objects such as images, containers, networks, and volumes. A daemon can also communicate with other daemons to manage Docker services.

Docker daemon is the brain behind the whole operation. When you use the docker run command to start up a container, your docker client will translate that command into an HTTP API call and sends it to the docker daemon. Docker daemon then evaluates the request, talks to the underlying os and provisions your container.

On a typical installation, the Docker daemon is started by a system utility, not manually by a user. This makes it easier to automatically start Docker when the machine reboots.

If you don’t want to use a system utility to manage the Docker daemon, or just want to test things out, you can manually run it using the dockerd command. You may need to use sudo, depending on your operating system configuration.

When you start Docker this way, it runs in the foreground and sends its logs directly to your terminal.
