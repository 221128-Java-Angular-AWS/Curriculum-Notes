## Summary

**Containerization**

- A container is like a lightweight virtual machine without the need to emulate hardware.
- An application is packaged with all dependencies and libraries into a container for portability and isolation.
- Containerization abstracts away the host operating system with limited access to its resources.
- A container can run its own guest OS, but unlike a VM a container doesn't have to.


**Advantages of Containerization**

 - **Portability**: When bundled into a container with its dependencies, a container can run properly in any environment supported by the container engine.
  - **Security**: The container engine provides an isolated sandbox for applications, preventing them from effecting other containers or the host operating system.
 - **Efficiency**: Containers are considered to be lightweight, a smaller and more efficient solution compared to VMs.
 - **Scalability**: Containerization allows for orchistration of many containers, a great solution for horizontal scaling.


**Disadvantages of Containerization**

- **Security**: Compared to VMs, containers do not offer the same level of isolation and separation.
- **Complexity**: Introducing containerization will add complexity to your project, adding new points of failure and vulnerability.
- **Monitoring**: Containerization solutions generally do not have the same level of monitoring that is built into virtual machine solutions.

