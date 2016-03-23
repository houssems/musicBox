# Rest Servlets and Ejb on JavaEE container

This clickstart integrates rest functionalities on JavaEE container (Glassfish), using:

        EJB 3.2
        Jersey 2.5
        Glassfish 4
        Java 7

Press the button to build, test and deploy this instantly:



## Running the project locally
```
    git clone https://github.com/CloudBees-community/glassfish4-jersey-ejb-clickstart.git
    mvn embedded-glassfish:run  
```
(check https://blogs.oracle.com/brunoborges/entry/glassfish_4_beta_and_maven to configure your pom.xml to use the embedded glassfish)

You can access this web-app at: http://localhost:8080/glassfish4-jersey-ejb-clickstart/



## Working in Eclipse/STS

### prerequisites
The following items should be installed in your system:
* Maven 3 (http://www.sonatype.com/books/mvnref-book/reference/installation.html)
* git command line tool (https://help.github.com/articles/set-up-git)
* Eclipse with the m2e plugin (m2e is installed by default when using the STS (http://www.springsource.org/sts) distribution of Eclipse)

Note: when m2e is available, there is an m2 icon in Help -> About dialog.
If m2e is not there, just follow the install process here: http://eclipse.org/m2e/download/


### Steps:

1) In the command line
```
git clone https://github.com/CloudBees-community/glassfish4-jersey-ejb-clickstart
```
2) Inside Eclipse
```
File -> Import -> Maven -> Existing Maven project