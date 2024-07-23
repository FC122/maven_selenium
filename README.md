# Selenium Maven
## Overview
The project is offering a structured framework for creating and executing automated test cases. By leveraging Selenium and TestNg, this project facilitates the automation of web application testing.

## Features
### POM
The project implements Page-Object Model for structured, reliable and expandble test automation.

### Configuration.properties
File which contains all environment variables in one place..

### ConfigFileReader
Implements a file reader for environment variable ease of use.

### Page Factory
Uses selenium page factory.

### Browser Factory
Implements a browser factory for running multiple browsers.


## Requirements
Maven 3.9.8
Java 21.0.2
Windows 11
Chromedriver 114.0.5735.90


## Installation
1. Clone the repo
2. Navigate tot maven_selenium
3. Run
```
mvn install
```
4. Run
```
mvn test
```