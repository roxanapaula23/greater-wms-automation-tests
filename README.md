# Greater WMS Automation Tests

---

## Description

This repository contains automated tests written in **Java**, using **Selenium WebDriver** and **TestNG**. The tests are targeted at the [Warehouse Backend Application](https://github.com/your-org/warehouse-backend) and validate key workflows such as login, registration, and warehouse operations.

---

## Prerequisites

Before you begin, ensure you have the following installed:

- Java 23 
- Maven
- Git
- Chrome browser (for ChromeDriver)
- ChromeDriver

---

## Start Warehouse Web App

To start the backend system, clone and run the following repository:

```bash
git clone https://github.com/roxanapaula23/greater-wms.git
cd warehouse-wms
docker-compose -f docker-compose.yml up -d
```

Make sure it runs at `http://localhost:8080` (or update your config accordingly).

---

## Clone Project

```bash
git clone https://github.com/your-org/ngtesting-selenium.git
cd ngtesting-selenium
```

---

## Install Dependencies

```bash
mvn clean install
```

---

## Run Tests

### Option 1: From Terminal
```bash
mvn test
```

---
