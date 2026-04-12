import random

REWARDS = [
    {"name": "Small Potion", "heal_amount": 20},
    {"name": "Mid Potion",   "heal_amount": 40},
    {"name": "Big Potion",   "heal_amount": 60},
    {"name": "Max Potion",   "heal_amount": 999}
]

class Character:
    def __init__(self, name, attack, health):
        self.name = name
        self.attack = attack
        self.health = health
        self.inventory = []
        self.max_health = health

    def add_items(self, item):
        self.inventory.append(item)

    def use_item(self, item_name):
        for item in self.inventory:
            if item["name"] == item_name:
                self.health = min(self.health + item["heal_amount"], self.max_health)
                self.inventory.remove(item)
                print(f"Used {item['name']}! Health is now {self.health}")
                return True
        print(f"{item_name} not found in inventory")
        return False

    def show_inventory(self):
        if not self.inventory:
            print("Inventory is empty!")
        else:
            for item in self.inventory:
                print(f"- {item['name']} (heals {item['heal_amount']})")

    def is_attacking(self, target):
        damage = self.attack
        target.health -= damage

    def is_alive(self):
        if self.health > 0:
            return True
        else:
            return False

class Warrior(Character):
    def __init__(self, name, attack = 30, health = 120):
        super().__init__(name, attack, health)

class Mage(Character):
    def __init__(self, name, attack = 15, health = 85, mana = 200):
        super().__init__(name, attack, health)
        self.mana = mana

class Archer(Character):
    def __init__(self, name, attack = 20, health = 100):
        super().__init__(name, attack, health)

def first_menu():
    print("1. Warrior")
    print("2. Mage")
    print("3. Archer")
    player_choice = input("Choose your character: ")
    return player_choice

def reward_giver():
    reward = random.choice(REWARDS)
    return reward

def battle(player, enemy):
    while player.is_alive() and enemy.is_alive():
        print(f"\n--- Battle: {player.name} vs {enemy.name} ---")
        print("1. Attack")
        print("2. Items")
        print("3. Show Inventory")
        print("4. Exit")
        choice = input("Enter your choice: ")

        if choice == "1":
            player.is_attacking(enemy)
            print(f"{player.name} attacks {enemy.name} for {player.attack} damage! Your HP: {enemy.health}")
        elif choice == "2":
            player.show_inventory()
            item_name = input("Enter item name: ")
            player.use_item(item_name)
        elif choice == "3":
            player.show_inventory()
        elif choice == "4":
            break
        else:
            print("Invalid choice")
            continue

        if enemy.is_alive():
            enemy.is_attacking(player)
            print(f"{enemy.name} attacks {player.name} for {enemy.attack} damage! Your HP: {player.health}")

def main():
    print("=== Welcome to the RPG ===")
    name = input("Enter your character name: ")
    choice = first_menu()

    if choice == "1":
        player = Warrior(name)
        print(f"\nWarrior {name} created! ATK: 30 | HP: 120")
    elif choice == "2":
        player = Mage(name)
        print(f"\nMage {name} created! ATK: 15 | HP: 85 | Mana: 200")
    elif choice == "3":
        player = Archer(name)
        print(f"\nArcher {name} created! ATK: 20 | HP: 100")
    else:
        print("Invalid choice, defaulting to Warrior")
        player = Warrior(name)

    enemies = [
        Warrior("Goblin", attack = 5, health = 30),
        Archer("Bandit", attack = 8, health = 35),
        Warrior("Skeleton", attack = 10, health = 40),
        Archer("Orc Scout", attack = 13, health = 55),
        Mage("Witch", attack = 16, health = 45),
        Warrior("Troll", attack = 20, health = 80),
        Mage("Dark Mage", attack = 24, health = 60),
        Archer("Assassin", attack = 27, health = 65),
        Warrior("Death Knight", attack = 32, health = 100),
        Mage("Shadow Lord", attack = 38, health = 150),
    ]

    ran = False

    for enemy in enemies:
        print(f"\nA wild {enemy.name} appears!")
        battle(player, enemy)

        if not player.is_alive():
            print("Game over!")
            return

        if not enemy.is_alive():
            reward = reward_giver()
            player.add_items(reward)
            print(f"You defeated {enemy.name} and received: {reward['name']}!")
            print("\nCurrent Inventory:")
            player.show_inventory()
        else:
            print(f"\nYou ran from {enemy.name}!")
            ran = True
            break

    if not ran:
        print(f"\n=== You cleared all enemies! Well done, {player.name}! ===")

main()