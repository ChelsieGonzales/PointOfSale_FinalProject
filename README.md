# 🛒 Point of Sale System - Meow at Yah 🐱

## 📌 Overview
The **Meow at Yah Point of Sale System** is a Java-based console application designed to manage sales transactions efficiently. It provides functionalities such as listing products, processing orders, generating receipts, updating inventory, and managing product details. This system is tailored for a pet shop selling various cat-related products. 🐾

## ✨ Features
- **🔑 User Authentication**: Requires a valid username (`admin`) and password (`cashier`) to access the system.
- **🛍️ Product Management**:
  - 📜 View a list of available products.
  - 🔎 Search for specific products by name or index.
  - ➕ Add, ✏️ update, and ❌ delete products.
- **📝 Order Processing**:
  - 🛒 Place an order by selecting products and specifying quantities.
  - ✅ Ensure sufficient inventory before processing orders.
  - 💰 Display order information and total cost.
- **💳 Billing and Receipt Generation**:
  - 💵 Accept payment from customers.
  - 💲 Calculate change and confirm successful payment.
  - 🧾 Generate a receipt with the list of purchased products.
- **📦 Inventory Management**:
  - 📉 Automatically update inventory when a product is purchased.
  - 🔄 Reset order data after successful transactions for new customers.

## 🚀 How to Run
1. 📥 Clone the repository or download the project files.
2. ⚙️ Ensure you have **Java JDK 8+** installed on your system.
3. 🖥️ Open a terminal or command prompt and navigate to the project directory.
4. 🏗️ Compile the Java file using:
   ```sh
   javac PointOfSale.java
   ```
5. ▶️ Run the program:
   ```sh
   java PointOfSale
   ```
6. 🔑 Enter the login credentials:
   - **Username**: `admin`
   - **Password**: `cashier`
7. 📌 Follow the menu prompts to interact with the system.

## 🏷️ Sample Products
| 🔢 Index | 🏷️ Product Name     | 💰 Price (PHP) | 📦 Inventory |
|-------|-----------------|-------------|-----------|
| 1     | Kitcat chicken  | 94.99       | 95        |
| 2     | Monge proteins  | 179.99      | 95        |
| 3     | Fancy Feast     | 139.99      | 95        |
| 4     | Goodest Cat     | 23.99       | 95        |
| ...   | ...             | ...         | ...       |

## 🔧 Possible Enhancements
- 🖥️ Implement a graphical user interface (GUI) using **Java Swing** or **JavaFX**.
- 🗄️ Add a database for persistent data storage instead of arrays.
- 📊 Implement a user-friendly reporting feature for sales analysis.
- 👥 Support multiple users with different roles (e.g., cashier, manager).

## 📜 License
This project is open-source and free to use. Feel free to modify and enhance it! 🛠️

## 👨‍💻 Author
Developed with ❤️ by Chelsie Gonzales firts year student in Computer Science.

