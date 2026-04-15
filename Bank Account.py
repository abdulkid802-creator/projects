class Account:
    def __init__(self, owner, balance=0):
        self.owner = owner
        self.balance = balance

    def deposit(self, amount):
        self.balance += amount

    def withdraw(self, amount):
        if amount > self.balance:
            print("Insufficient funds")
        else:
            self.balance -= amount

    def transfer(self, amount):


    def print_info(self):
        print(f"Owner: {self.owner} | Balance: €{self.balance:.2f}")

class SavingAccount(Account):
    def __init__(self, owner, balance=0, interest_rate=0.0):
        super().__init__(owner, balance)
        self.interest_rate = interest_rate

    def apply_interest(self):
        interest = self.balance * self.interest_rate
        self.balance += interest
        print(f"Interest applied: €{interest:.2f}")

    def print_info(self):
        print(f"Owner: {self.owner} | Balance: €{self.balance:.2f} | Interest Rate: {self.interest_rate*100:.1f}%")

class CheckAccount(Account):
    def __init__(self, owner, balance=0, overdraft_limit=0):
        super().__init__(owner, balance)
        self.overdraft_limit = overdraft_limit

    def withdraw(self, amount):
        if amount > self.balance + self.overdraft_limit:
            print("Exceeds overdraft limit")
        else:
            self.balance -= amount

    def print_info(self):
        print(f"Owner: {self.owner} | Balance: €{self.balance:.2f} | Overdraft Limit: €{self.overdraft_limit:.2f}")

savings = SavingAccount("Abdul", 1000, 0.05)
checking = CheckAccount("Abdul", 50, 100)

savings.deposit(500)
savings.apply_interest()
checking.withdraw(120)

savings.print_info()
checking.print_info()