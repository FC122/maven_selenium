# Selenium Maven Project

## Overview
This project offers a structured framework for creating and executing automated test cases using Selenium and TestNG. It is designed to facilitate the automation of web application testing through a well-organized structure.

## Features
### Page Object Model (POM)
- Implements the Page Object Model for structured, reliable, and expandable test automation.

### Configuration Properties
- Includes a `Configuration.properties` file that centralizes all environment variables.

### ConfigFileReader
- Provides a file reader to simplify the use of environment variables.

### Page Factory
- Utilizes Selenium's Page Factory for efficient and easy-to-maintain page object initialization.

### Browser Factory
- Implements a browser factory to support running tests on multiple browsers.

## Requirements
- Maven 3.9.8
- Java 21.0.2
- Windows 11
- Chromedriver 114.0.5735.90

## Installation
1. Clone the repository:
```sh
git clone <repository_url>
```

2. Navigate to the maven_selenium directory:
```sh
cd maven_selenium
```

3. Install the project dependencies:
```sh
mvn install
```

4. Run the tests:
```sh
mvn test
```

## Configuration
Ensure the configuration.properties file is correctly set up with all necessary environment variables. This file should be located in the src/main/resources directory and may include variables such as:

- browser: The browser to use for tests (e.g., chrome, firefox).
- url: The base URL of the application to be tested.
- timeout: The default timeout for implicit waits.

## Usage
- Page Objects: Define web elements and actions for each page of your application in the src/main/java/com/yourcompany/pages directory.
- Test Cases: Create test cases in the src/test/java/com/yourcompany/tests directory.
### Running Specific Tests
To run specific test classes or methods, you can use the following Maven command:
```sh
mvn -Dtest=TestClassName test
```

Or to run a specific method in a test class:
```sh
mvn -Dtest=TestClassName#methodName test
```

## Contributing
1. Fork the repository.
2. Create a new branch:
```sh
git checkout -b feature/your-feature
```
3. Make your changes.
4. Commit your changes:
```sh
git commit -m 'Add some feature'
```
5. Push to the branch:
```sh
git push origin feature/your-feature
```
6. Open a pull request

## License
The MIT License (MIT)
Copyright © 2024 <copyright holders>

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the “Software”), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

## Contact
For any questions or issues, please contact filip.cica1234@gmail.com


