Create a file called Docker File and edit it using vim. 
Please note that the name of the file has to be "Dockerfile" with "D" as capital.

Build your Docker File using the following instructions.
 - #This is a sample Image 
 - FROM ubuntu 
 - MAINTAINER demousr@gmail.com 
 - RUN apt-get update 
 - RUN apt-get install –y nginx 
 - CMD [“echo”,”Image created”] 

The following points need to be noted about the above file −
 * The first line "#This is a sample Image" is a comment. You can add comments to the Docker File with the help of the # command
 * The next line has to start with the FROM keyword. It tells docker, which base image you want to base your image from. In our example, we are creating an image from the ubuntu image.
 * The next command is the person who is going to maintain this image. Here you specify the MAINTAINER keyword and just mention the email ID.
 * The RUN command is used to run instructions against the image. In our case, we first update our Ubuntu system and then install the nginx server on our ubuntu image.
* The last command is used to display a message to the user.
 - Save the file. 
