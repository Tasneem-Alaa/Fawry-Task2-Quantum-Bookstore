# 📚 Quantum Bookstore

An online bookstore system implemented in Java.  
Supports different book types: PaperBook, EBook, and DemoBook.

---

## ✨ Features

- ➕ Add books to inventory with details (ISBN, title, year, price).  
- 🗑️ Remove outdated books older than a specified number of years.  
- 🛒 Buy books by ISBN, quantity, with shipping/email based on book type.  
- 📦 Handles stock management and exceptions (e.g. not enough stock, book not for sale).  
- 🔧 Easily extensible to add new book types without modifying existing code.

---

## 📚 Book Types

- 📖 **PaperBook**: physical books with stock, shipped to an address.  
- 💻 **EBook**: digital books sent via email.  
- 🎬 **DemoBook**: showcase/demo books not available for purchase.

---

## 🚀 Getting Started

1. Clone the repository  
2. Compile the Java source files  
3. Run the `BookStoreTesting` class or the `main` method in your main class to execute all tests automatically.

---

## 🧪 Tests Overview

The system includes several test methods covering key scenarios:

- **Add Book**: tests adding various book types to the inventory.  
- **Remove Outdated Books**: tests removing books older than a specified number of years.  
- **Buy Paper Book**: tests buying paper books, including stock reduction and handling insufficient stock.  
- **Buy EBook**: tests buying eBooks and sending via email.  
- **Buy Demo Book**: tests buying demo books which are not for sale, ensuring proper exception handling.  
- **Buy Book Not Found**: can be added to test behavior when attempting to buy a non-existent book.

All these tests run automatically when you execute the main test class, printing clear output for each case.

---

## ⚠️ Exception Handling

The system throws exceptions in cases such as:  
- Book not found  
- Not enough stock available  
- Book is a demo and not available for purchase

---
## Screens from running 
![image](https://github.com/user-attachments/assets/b9f82e3d-6b68-4b09-b0cb-9f0fe001b6c0)
![image](https://github.com/user-attachments/assets/294141bd-38e6-4d30-97d3-7c4da2809aff)

## 👩‍💻 Author

Tasneem Alaa – Computer Science Student

---

Feel free to contribute or raise issues! 🚀
