# Bank Management System by Java

A console-based Bank Management System developed using **Java** and **Object-Oriented Programming (OOP)** concepts. The application provides core banking operations such as account creation, login, balance inquiry, account details, fund transfer, bank statements, and account closure.

---

## 1. Project Overview

The **Bank Management System** is a Java-based console application created to demonstrate the practical use of Object-Oriented Programming concepts through a banking use case.

The system provides a terminal-based interface through which users can create and manage bank accounts and perform common banking operations.

### Main Functions

- Create a new bank account
- Generate an account number
- Login using account number and password
- View account details
- Check account balance
- Transfer funds
- View bank statement / transaction history
- Close an account
- Log out from the system
- Exit the application

---

## 2. Technologies Used

- **Programming Language:** Java
- **Programming Paradigm:** Object-Oriented Programming (OOP)
- **Input Handling:** Java `Scanner`
- **File Handling:** Java I/O
- **Data Handling:** Local text files
- **Version Control:** Git and GitHub

---

## 3. Project Structure

```text
Bank-Management-System-by-Java/
│
├── SRC/
│   ├── Main.java
│   ├── Login.java
│   ├── Creation.java
│   ├── Deletion.java
│   ├── AccountDetails.java
│   ├── BalanceInquiry.java
│   ├── Transaction.java
│   └── BankStatement.java
│
├── db/
│   ├── credentials.txt
│   ├── userDB.txt
│   └── balanceDB.txt
│
├── Docs/
│   ├── ProjectReport.pdf
│   └── screenshot.pdf
│
└── README.md
```

### Folder and File Description

| File / Folder | Purpose |
|---|---|
| `SRC/` | Contains all Java source-code files |
| `db/` | Contains the local text files required by the application |
| `credentials.txt` | Stores account authentication information |
| `userDB.txt` | Stores customer account information |
| `balanceDB.txt` | Stores account balance information |
| `Docs/` | Contains project documentation and supporting files |
| `ProjectReport.pdf` | Detailed project report |
| `screenshot.pdf` | Project screenshots / supporting visuals |
| `README.md` | Project setup and execution instructions |

---

## 4. Environment Requirements

Before running the project, make sure the following software is installed on the system.

### Java Development Kit (JDK)

The project requires a Java Development Kit because both the Java runtime and Java compiler are needed.

Verify the Java runtime:

```bash
java -version
```

Verify the Java compiler:

```bash
javac -version
```

Both commands should display an installed Java version.

A current LTS JDK or another compatible modern JDK is recommended.

---

## 5. Clone the Repository

Open Terminal and navigate to the directory where you want to store the project.

Clone the repository:

```bash
git clone https://github.com/[YOUR_USERNAME]/Bank-Management-System-by-Java.git
```

Enter the project directory:

```bash
cd Bank-Management-System-by-Java
```

---

## 6. Verify the Project

After entering the project directory, verify the required folders are present:

```bash
ls
```

The project should contain:

```text
SRC/
db/
Docs/
README.md
```

You can also verify the Java source files:

```bash
ls SRC
```

And verify the required database files:

```bash
ls db
```

The `db` directory should contain:

```text
credentials.txt
userDB.txt
balanceDB.txt
```

The project should be run from the repository root so that the application's relative file paths resolve correctly.

---

## 7. Compile the Project

From the project root directory, compile all Java source files using:

```bash
javac -d out SRC/*.java
```

### Explanation

- `javac` — invokes the Java compiler.
- `-d out` — places compiled `.class` files inside the `out` directory.
- `SRC/*.java` — compiles all Java source files stored in `SRC`.

If compilation is successful, the command completes without errors and creates the `out` directory.

---

## 8. Run the Project

After successful compilation, run the application using:

```bash
java -cp out Main
```

The application will launch in the terminal and display the main banking interface.

The starting menu provides options for:

```text
Type 1: Login
Type 2: Create Account
```

---

## 9. Expected Execution Flow

The basic execution flow of the application is:

```text
Start Application
       │
       ▼
Main Menu
       │
   ┌───┴───────────┐
   │               │
   ▼               ▼
 Login        Create Account
   │               │
   └───────┬───────┘
           ▼
      Banking Menu
           │
   ┌───────┼────────┬──────────┬──────────┐
   ▼       ▼        ▼          ▼          ▼
 Balance  Details  Transfer  Statement  Closure
```

After authentication or successful account creation, the user is taken to the banking menu where the available banking operations can be selected.

---

## 10. Complete Setup and Execution

For an evaluator who already has Java installed, the complete process is:

### Step 1 — Clone

```bash
git clone https://github.com/[YOUR_USERNAME]/Bank-Management-System-by-Java.git
```

### Step 2 — Enter the project

```bash
cd Bank-Management-System-by-Java
```

### Step 3 — Compile

```bash
javac -d out SRC/*.java
```

### Step 4 — Run

```bash
java -cp out Main
```

The application will then start in the terminal.

---

## 11. Project Documentation

Additional project documentation is available in the `Docs/` directory.

### Project Report

```text
Docs/ProjectReport.pdf
```

The project report provides detailed documentation related to the project.

### Screenshots

```text
Docs/screenshot.pdf
```

This file contains supporting screenshots of the project and its execution.

---

## 12. OOP Concepts Demonstrated

The project demonstrates the practical use of important Object-Oriented Programming concepts, including:

### Classes and Objects

Separate Java classes are used to represent different banking operations and system responsibilities.

### Interfaces

Interfaces are used to define method contracts for specific functionality such as account creation and authentication.

### Encapsulation

Related data and behavior are organized within appropriate classes.

### Abstraction

Interfaces are used to define required behavior while implementation details remain within their respective classes.

### Modular Design

Different banking operations are separated into dedicated classes, making the source code easier to understand and maintain.

---

## 13. Author

**Pranshu Gupta**
