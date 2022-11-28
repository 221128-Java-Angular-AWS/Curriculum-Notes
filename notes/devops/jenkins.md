# DevOps Tools � Jenkins

Jenkins is a self-contained, open source automation server, which can be used to automate the building, testing and deployment of software. Jenkins can be installed standalone, through native system packages, or using Docker.

### References
* [Jenkins Documentation](https://www.jenkins.io/doc/)
* [Installation of Jenkins](https://www.jenkins.io/doc/book/installing/)
* [Jenkins Pipeline Tutorial](https://www.youtube.com/watch?v=s73nhwYBtzE)
* [Using Jenkins](https://www.jenkins.io/doc/book/using/)
* [Managing Jenkins](https://www.jenkins.io/doc/book/managing/)
* [Defined Pipeline-compatible steps](https://www.jenkins.io/doc/pipeline/steps/)

## Jenkins Installation
To utilize Jenkins, it is recommended to [install Docker](https://docs.docker.com/get-docker/) on your operating system. Moreover, you can also utilize an [AWS Linux Ubuntu EC2](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/get-set-up-for-amazon-ec2.html) server.
* [Jenkins Install - MacOS](https://www.jenkins.io/download/lts/macos/)
* [Jenkins Install - Linux](https://www.jenkins.io/doc/book/installing/#linux)
* [Jenkins Install - Windows](http://mirrors.jenkins.io/windows/)

## Using Jenkins
After you [download Jenkins](https://www.jenkins.io/doc/pipeline/tour/getting-started/), open a terminal a Run:
```
java -jar jenkins.war --httpPort=8080.
```

Next, navigate to `http://localhost:8080` and follow the instructions to complete the installation process.

## Pipeline Tutorial
A Jenkins Pipeline is a suite of plugins which support the implementation of a Continuous Delivery Pipeline in Jenkins. The follow details steps for utilizing a Jenkins pipeline with Java.

You can follow these steps to establish your pipeline [here](https://gitlab.com/revature_training/devops-team/-/tree/master/trainer-examples/matthew-oberlies/pipeline-demo/scripts). Alternatively you can follow these [steps to build a Java app with Maven](https://www.jenkins.io/doc/tutorials/build-a-java-app-with-maven/).

Creating a custom pipeline can offer you a great deal of flexibility. To create a custom pipeline, you will need to create a `jenkinsfile`:
1. Configure your `jenkinsfile` (see below)
1. Navigate to your Jenkins server and select 'New Item' from the Jenkins menu.
1. Provide a name for your new item (i.e. "Pipeline-Example")
1. Click "Add Source" to choose the type and details for your repository
1. Click "Save". You can now build your project using this new pipeline

A `jenkinsfile` consists of agents, stages, and steps.

An [agent](https://www.jenkins.io/doc/book/pipeline/syntax/#agent) informs Jenkins where, and how to execute the Pipeline. For example:
* From a docker image
```
pipeline {
    agent { 
        docker { image 'maven:3.3.3' }
    }
    // additional information to follow //
}
```
* From anywhere

```
pipeline {
    agent any
    // additional information to follow //
}
```

An agent is required at the top level of a pipeline block but can also optionally be used at the stage level to define stage-level usage.

[Stages](https://www.jenkins.io/doc/book/pipeline/syntax/#stages) are a sequence of one or more individual custom [stage](https://www.jenkins.io/doc/book/pipeline/syntax/#stages) directives. Each stage will consist of multiple steps, that are performed by a Jenkins pipeline.

Stages Block
* The stages block is required to list each individual stage directive
* Each pipeline should only contain a single stages block.
* This stages block must contain as least one stage directive
* May contain multiple stage directives. 

Stage Directive
* Each stage directive requires a string parameter for the name of the stage.
* Each stage directive requires at least one step
* May contain multiple steps

For example:
```
pipeline {
    agent any
    stages {
        stage('Deploy') {
            // List of steps go here //
        }
    }
}
```

[Steps](https://www.jenkins.io/doc/book/pipeline/syntax/#steps) are the specific actions taken by a Jenkins Pipeline. 

Steps Block
* Do not require parameters
* May contain a script block to define behavior

For example:
```
pipeline {
    agent any
    stages {
        stage('Deploy') {
            steps {
                echo 'Hello World'

                script {
                    def browsers = ['chrome', 'firefox']
                    for (int i = 0; i < browsers.size(); i++) {
                        echo "Testing the ${browsers[i]} browser"
                    }
                }
            }
        }
    }
}
```

### Disadvantages of Jenkins
* Requires custom jenkinsfile syntax for pipeline configuration

### Advantages of Jenkins
* Completely Open Source
* Free
* Supports all Operating systems
* Supports all source code repositories
