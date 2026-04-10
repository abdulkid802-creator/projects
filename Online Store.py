class Product:
    def __init__(self, name, price = 0.0, stock = 0):
        self.name = name
        self.price = price
        self.stock = stock

    def apply_discount(self, percentage):
        discount_amount = self.price * (percentage / 100)
        self.price -= discount_amount

    def print_info(self):
        print(f"Name: {self.name}")
        print(f"Price: {self.price}")
        print(f"Stock: {self.stock}")

class Electronics(Product):
    def __init__(self, name, price = 0.0, stock = 0, warranty_years = ""):
        super().__init__(name, price, stock)
        self.warranty_years = warranty_years

    def print_info(self):
        print(f"Name: {self.name}")
        print(f"Price: {self.price}")
        print(f"Stock: {self.stock}")
        print(f"Warranty years: {self.warranty_years}")

class Clothing(Product):
    def __init__(self, name, price = 0.0, stock = 0, size = ""):
        super().__init__(name, price, stock)
        self.size = size

    def print_info(self):
        print(f"Name: {self.name}")
        print(f"Price: {self.price}")
        print(f"Stock: {self.stock}")
        print(f"Size: {self.size}")

class Food(Product):
    def __init__(self, name, price = 0.0, stock = 0, expiry_date = ""):
        super().__init__(name, price, stock)
        self.expiry_date = expiry_date

    def print_info(self):
        print(f"Name: {self.name}")
        print(f"Price: {self.price}")
        print(f"Stock: {self.stock}")
        print(f"Expiry date: {self.expiry_date}")

class Store:
    def __init__(self, name):
        self.name = name
        self.inventory = []

    def add_product(self, product):
        self.inventory.append(product)

    def show_inventory(self):
        for product in self.inventory:
            product.print_info()

    def sale(self, percentage):
        for product in self.inventory:
            product.apply_discount(percentage)

store = Store("Abdul's Shop")

electronics = Electronics("Laptop", 999.99, 10, "2yr warranty")
clothing = Clothing("T-Shirt", 19.99, 50, "Size M")
food = Food("Bread", 2.49, 100, "Expires 01/05/25")

# Add to store
store.add_product(electronics)
store.add_product(clothing)
store.add_product(food)

# Show original inventory
print("=== BEFORE SALE ===")
store.show_inventory()

# Apply 10% sale
store.sale(10)
print()
# Show updated inventory
print("\n=== AFTER 10% SALE ===")
store.show_inventory()