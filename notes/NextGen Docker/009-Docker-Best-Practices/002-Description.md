#Create ephemeral containers
The image defined by your Dockerfile should generate containers that are as ephemeral as possible. By “ephemeral”, we mean that the container can be stopped and destroyed, then rebuilt and replaced with an absolute minimum set-up and configuration.

#Understand build context
When you issue a docker build command, the current working directory is called the build context. By default, the Dockerfile is assumed to be located here, but you can specify a different location with the file flag (-f). Regardless of where the Dockerfile lives, all recursive contents of files and directories in the current directory are sent to the Docker daemon as the build context.

#Scan for Security Vulnerabilities
You can perform active scans of your Docker images to identify key vulnerabilities. Several tools are available, including Docker Scan, which is built into the Docker CLI.
Scans assess the operating system packages installed in the image and match them against known lists of Common Vulnerabilities and Exposures (CVEs). Suggested remediation steps are provided for each detected problem.
You should utilize a container scanning engine as a best-practice step to avoid issues slipping into production unseen. Add a scan to the image build stage of your CI pipeline to protect yourself from developers unwittingly adding risky packages to your image.

#Remove Unneeded Dependencies
Docker images should be as minimal as possible. Streamlining your builds to include just the bare essentials makes for smaller image sizes, faster builds, and a reduced attack surface. You’ll also use less network bandwidth when transferring images to registries and hosting providers.
Don’t install any packages or libraries that your application doesn’t use. As you’ll rarely interact with running containers yourself, there’s no point in adding common CLI utilities on the off chance you might want them later. Maintaining this practice will help your Dockerfile stay focused on containerizing your application instead of an entire OS environment.
