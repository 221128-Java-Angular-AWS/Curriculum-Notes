## Implementation

**Container**

A container is a lightweight software package that contains all the dependencies and libraries required to run the software application.
- Containers are isolated processes.
- Containers don't require hardware emulation like a hypervisor.
- Containers are very fast and lightweight compared to a Virtual Machine.

**Container Engine**

The Container Engine is software used to create, manage, and run containers. The containers are kept isolated, but have access to system resources when needed. The container engine is the core software that makes containers work. Similar to the Java Virtual Machine, if the engine can run in an environment, the containers can run in the engine.


**Virtual Machine**

A virtual machine is a virtual environment in a computer that has its own virtual hardware. As far as a guest operating system running on a VM knows, it is running on real hardware. VMs are like physical computers, but exist in virtual form. These 'fake' virtual computers run atop software called a Hypervisor.

**Hypervisor**
A Hypervisor is software used to manage virtual machines. Similar to how containers run with the help of the container engine, VMs run on the hypervisor. This is what emulates hardware and is the boundary which separates the VM from the real physical hardware.


![VmVSContainer](images/VmVSContainer.PNG)

|        | **Container** | **Virtual Machine** |
|---|---|---|
| **Operating System** | Can run a guest OS, but isn't required | Requires a guest OS which is isolated completely from the physical hardware |
| **Boot-time** | lower resource and infrastructure overhead means containers boot much quicker than VMs  | VMs require more time to start as they must bootstrap the OS jsut like a physical computer  |
| **Speed** | These containers are designed to save time in the deployment process of an application | VMs are a less efficient solution for deploying a single application, as they require more infrastructure and setup |
| **Portability** | Containers allow an application to run in an environment it may not have been designed for | Virtual Machines allow an OS to run on hardware it might not be designed for |

