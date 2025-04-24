# 🏦 BuggyBankingApp

A deliberately flawed command-line banking application built to test your debugging and problem-solving skills along with giving a real world like experience on open source contributions.

This project is part of the CodeJAM Future Minds coding competition organized by the Department of Computer Science & Engineering, University of Moratuwa.

---

## 🚀 Project Description

BuggyBankingApp is a simple CLI-based Java application simulating a basic banking system. It allows users to:

- Create bank accounts
- Deposit and withdraw money
- Transfer funds between accounts
- View account information and transaction history

However... it’s buggy on purpose 😈  
You must identify and fix logic, input handling, and structural issues. Functionality is validated automated tests running when you raised PRs (pull requests).

---

## 🧱 Tech Stack

- Java
- Maven
- JUnit 5

---

## 📂 Project Structure

| File                   | Description                                         |
|------------------------|-----------------------------------------------------|
| AccountRepository.java | Manages the storage and retrieval of account data. |
| BankAccount.java       | Holds data and logic for individual bank accounts.  |
| BankService.java       | Implements core banking business logic (manages accounts, processes actions). |
| InputUtil.java         | Handles all command-line interface (CLI) input.    |
| Main.java              | Controls the command-line interface (CLI) loop and menu. |
| Transaction.java       | Represents a single banking transaction (deposit, withdrawal, transfer). |
| TransactionLogger.java | Logs and prints transaction information to the CLI.   |


---

## ▶️ Compile and Run the Application

```bash
javac -d out src\main\java\cse\school\codejam\*.java
java -cp out cse.school.codejam.Main
```

📌 Make sure you're running the above commands from the project root directory.

---

## ⚠️ Note

This project contains intentional bugs in logic and structure.  
Your job is to fix them under time pressure 💪  
Good luck and happy debugging!

---
