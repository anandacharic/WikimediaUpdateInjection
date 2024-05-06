# Wikimedia Message Update Project

This project implements a messaging system using Apache Kafka for updating data using Wikimedia messages. It consists of a consumer and a producer, with Kafka acting as the messaging queue. The updated data is pulled from Wikimedia messages and pushed to another consumer, where it is stored in a MySQL database.

## Overview

The Wikimedia Message Update Project facilitates the real-time updating of data using messages from Wikimedia. The project includes the following components:

- **Producer**: Responsible for producing messages containing data updates from Wikimedia.
- **Consumer**: Consumes messages from the Kafka topic, processes them, and pushes the updated data to another consumer.
- **Kafka**: Acts as the messaging queue, facilitating communication between the producer and consumer.

## Workflow

1. The producer fetches data updates from Wikimedia messages and produces them to the Kafka topic.
2. The consumer subscribes to the Kafka topic, consumes messages, processes them, and pushes the updated data to another consumer.
3. The secondary consumer stores the updated data in a MySQL database for further processing or analysis.

## Technologies Used

- Apache Kafka: For messaging queue functionality.
- MySQL: For storing the updated data.
- Java: Programming language used for implementation.
- Kafka Connect: For connecting Kafka to external systems.
- Wikimedia API: For fetching data updates from Wikimedia messages.

## Usage

1. Clone or download the repository.
2. Set up Kafka and MySQL on your local machine or server.
3. Configure the project with the necessary Kafka and MySQL connection properties.
4. Build and run the producer and consumer components.
5. Monitor Kafka topics and MySQL database for data updates and processing.

## Contributions

Contributions to this project are welcome! If you have suggestions for enhancements, improvements, or additional features, feel free to open an issue or submit a pull request.
