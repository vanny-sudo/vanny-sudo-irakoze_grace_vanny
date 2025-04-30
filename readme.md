# OOP Management Systems Collection.

## 🚀 Project Overview.

This created repository showcases 3 main Java-based systems developed as part of OOP which are:

### 📦 1. Advanced Stock Management System
A complete stock management solution for tracking products, supplier relationships, and warehouse operations for a company.

### 🛒 Advanced Online Shopping System
An online shopping system featuring product management, cart functionality, and payment processing for shopping experience of customers.

### 🚗 Advanced Motor Vehicle Insurance System
A comprehensive system for handling insurance policies, vehicle information, premium calculations and claims processing.

## 📋 System Requirements

- JDK 11+
- Docker (optional for containerized deployment)

## 🔧 Getting Started

### Method 1: Local Setup

Cloning the repository and run the applications directly:

```bash
git clone https://github.com/vanny-sudo/vanny-sudo-irakoze_grace_vanny.git


cd vanny-sudo-irakoze_grace_vanny
javac Main.java
java Main
```

### Method 2: Docker Deployment

#### Build from Source

```bash
# Build image
docker build -t 26425-irakoze-grace-vanny-oop-assignments

# Run container
docker run -it 26425-irakoze-grace-vanny-oop-assignments

# Inside container:
cd motor-insurance-system
javac Main.java
java Main
```

#### Pull Pre-built Image

```bash
# Pull from Docker Hub
docker pull gracevanny/26425-irakoze-grace-vanny-oop-assignments

# Run container
docker run -it gracevanny/26425-irakoze-grace-vanny-oop-assignments
```

## 📂 Directory Structure

```
├── motor-insurance-system/       # Motor Insurance System
│   ├── Claim.java
│   ├── CollisionPolicy.java
│   ├── ComprehensivePolicy.java
│   ├── InsurancePolicy.java
│   ├── LiabilityPolicy.java
│   └── Main.java
│   └── Person.java
│   └── RoadsideAssistancePolicy.java
│   └── ThirdPartyPolicy.java
│   └── Vehicle.java

│
├── online-shopping-system/       # Online Shopping System
│   ├── AccessoriesItem.java
│   ├── BooksItem.java
│   ├── ClothingItem.java
│   ├── Customer.java
│   ├── ElectronicsItem.java
│   ├── GroceriesItem.java
│   ├── Main.java
│   ├── Payment.java
│   ├── ShoppingCart.java
│   ├── ShoppingItem.java

│
└── stock-management/            # Stock Management System
    ├── ClothingItem.java
    ├── ElectronicsItem.java
    ├── FurnitureItem.java
    ├── GroceryItem.java
    ├── Main.java
    ├── PerishableItem.java
    ├── Product.java
    ├── StockItem.java
    ├── Supplier.java
    ├── Warehouse.java
```

## 🧪 Testing

Each system can be tested individually by navigating to its directory and running the Main class:

```bash
cd online-shopping-system
javac Main.java
java Main
```

## 🔍 Key Features

### Stock Management System
- Inventory tracking
- Supplier relationship management
- Warehouse location tracking
- Product categorization and perishable item handling

### Online Shopping System
- Product categorization (Electronics, Clothing, etc.)
- Shopping cart functionality
- Customer accounts and payment processing

### Motor Vehicle Insurance System
- Multiple policy types (Comprehensive, Liability, etc.)
- Vehicle and policyholder management
- Claims processing


---

© 2025 Irakoze Grace Vanny