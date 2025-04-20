# Indexing Application

This project is an indexing application designed to process text files and apply various indexing rules to extract useful information. The application can be run from the command line and accepts a list of files as parameters.

## Features

1. **Count Uppercase Words**: The application counts the number of words that start with an uppercase letter in each provided file.
2. **List Long Words**: It lists all words that are longer than 5 characters in each file.

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven

### Installation

1. Clone the repository:
   ```
   git clone <repository-url>
   ```
2. Navigate to the project directory:
   ```
   cd indexing-application
   ```
3. Build the project using Maven:
   ```
   mvn clean package
   ```

### Usage

Run the application from the command line with the following command:
```
java -jar target/indexing-application.jar file1.txt file2.html
```

Replace `file1.txt` and `file2.html` with the paths to the files you want to process.

## Extensibility

The application is designed to be easily extensible. New indexing rules can be added by creating new classes that extend the `IndexingRule` abstract class and implementing the `applyRule(File file)` method.

## Contributing

Contributions are welcome! Please feel free to submit a pull request or open an issue for any enhancements or bug fixes.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.