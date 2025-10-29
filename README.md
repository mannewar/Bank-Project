# 🏦 Bank Management System (Java Project)

## 📘 Overview
This project is a **console-based banking application** written in Java.  
It simulates basic bank operations such as opening an account, depositing money, withdrawing funds, checking balance, transferring money, and closing accounts.  
It uses **object-oriented programming concepts** and **file handling** for initialization.

---

## 🧱 Project Structure
```
BankProject/
│
├── src/
│   ├── Bank.java
│   ├── BankAccount.java
│   └── BankFrontOffice.java
│
├── bankdetails.txt   # Contains bank name, branch, and IFSC
└── accNumseq.txt     # (Optional) Unused file for account numbering
```

---

## ⚙️ Class Descriptions

### 🏦 Bank.java
- Manages an array of `BankAccount` objects.  
- Performs all banking operations like:
  - Open Account  
  - Deposit  
  - Withdraw  
  - Balance Enquiry  
  - Transfer Money  
  - Close Account  
  - Display All Accounts  

### 💳 BankAccount.java
- Represents a single bank account.  
- Reads bank details from `bankdetails.txt`.  
- Handles:
  - Deposit and Withdraw logic  
  - Account number auto-generation  
  - Returns account details via `toString()`  

### 🏢 BankFrontOffice.java
- Acts as the **main entry point (UI)**.  
- Provides a text-based menu for user interaction.  
- Uses Java’s `Scanner` class for console input.  

---

## 📂 bankdetails.txt
This text file is required in the same folder as the `.java` files.  
Example content:
```
HDFC
Ameerpet
HD123Am
```
- Line 1 → Bank Name  
- Line 2 → Branch Name  
- Line 3 → IFSC Code  

---

## 🧩 Features
✅ Open new bank accounts  
✅ Deposit and withdraw funds  
✅ Display individual or all account details  
✅ Transfer money between accounts  
✅ Handle invalid input with proper exceptions  
✅ Demonstrates static blocks, constructors, and OOP design  

---

## 💻 How to Run
1. Open the project in **Eclipse** or any Java IDE.  
2. Make sure `bankdetails.txt` is in the **project root directory**.  
3. Run `BankFrontOffice.java` → choose operations from the menu.  

---

## 🧠 Technologies Used
- **Language:** Java (JDK 8 or above)  
- **IDE:** Eclipse / IntelliJ IDEA  
- **Concepts Used:** OOP, Arrays, Static Initialization Block, File Handling, Exception Handling  

---

## 📜 Sample Menu
```
===== HDFC BANK MENU =====
1. Open Account
2. Display Account Details
3. Deposit
4. Withdraw
5. Balance Enquiry
6. Transfer Money
7. Display All Accounts
8. Exit
```

---

## 🧑‍💻 Author
**Parmeshwar**  
Java Developer | QA Enthusiast | Learning Automation Testing | Automation Engineer
