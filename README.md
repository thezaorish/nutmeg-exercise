####**Command line utility for cats enthusiasts**

The command has the following interface:
> - $ java -jar target/nutmeg-exercise [ file | categories | fact ]

with file being the default if no arguments are passed

The command should:
> - with file, it should save (on the temporary folder) an image of a cat (as an image file) and print to stdout the url
> - with categories, it should print to stdout an ordered list with the different categories of cats
> - with fact, it should print to stdout a cat fact

#####**Technology**
- [Maven](https://maven.apache.org/) for dependency management and packaging
- [Cucumber](https://cucumber.io/) for acceptance tests
- [Unirest](http://unirest.io/java.html) for interacting with the external APIs
- [Jackson Library](https://github.com/FasterXML/jackson) for handling JSON and XML transformation
- [Guice](https://github.com/google/guice) for dependency injection
- [JUnit](http://junit.org/) for unit tests

#####**Build**
> - mvn package

#####**Run**
> - java -jar target/nutmeg-exercise [option]
