# 🛒 Supermarket Checkout System

A console-based supermarket checkout system built in Java. Scan products, manage your basket, apply discount codes and checkout — all through a simple menu interface.

Built as a Java OOP learning project focusing on class design, ArrayLists and method return types.

---

## 💻 How to Use

Run the program and use the menu to scan products into your basket, remove items, apply discounts and checkout.

---

## ✅ Features

- Scan products into basket by entering details
- Remove products from basket by barcode
- View all items in basket with full details
- Apply discount codes to reduce the total
- Checkout to see final total
- Error handling for invalid barcodes and discount codes
- Pre-stocked supermarket inventory with 5 products

---

## 🗂️ Project Structure

```
Supermarket Checkout System/
└── src/
    ├── Main.java           # Entry point — menu loop
    ├── Product.java        # Product data — name, price, category, barcode
    ├── Basket.java         # Manages basket — add, remove, total, display
    ├── Discount.java       # Discount codes and percentage calculations
    └── Supermarket.java    # Store inventory — add, find, display products
```

---

## ▶️ How to Run

**Requirements:** Java JDK 11 or above

1. Clone the repository:
   ```bash
   git clone https://github.com/abdulkid802-creator/JavaProjects.git
   ```

2. Navigate to the src folder and compile:
   ```bash
   cd JavaProjects/SupermarketCheckout/src
   javac *.java
   ```

3. Run the program:
   ```bash
   java Main
   ```

---

## 🧠 Java Concepts Practised

- **Classes and encapsulation** — each class has a single clear responsibility
- **ArrayLists** — dynamic product and basket management
- **Boolean return types** — `removeProduct()` returns success/failure
- **`removeIf`** — clean removal by barcode condition
- **Scanner** — reading user input from console
- **Switch expressions** — clean menu handling
- **Null checks** — handling invalid barcodes and missing products

---

## 👤 Author

**Abdul** — Computing Student @ TU Dublin
[GitHub](https://github.com/abdulkid802-creator)
