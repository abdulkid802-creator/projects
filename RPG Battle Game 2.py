import random

# ============================================================
#  RPG BATTLE GAME — Abdul's original classes + game loop
# ============================================================


# ----------------------------------------------------------
# BASE CLASS (your original, unchanged)
# ----------------------------------------------------------
class Character:
    def __init__(self, name, health=0, attack_power=0):
        self.name = name
        self.health = health
        self.max_health = health   # NEW: needed for the health bar display
        self.attack_power = attack_power

    def attack(self, target):
        damage = random.randint(1, self.attack_power)
        target.health -= damage
        print(f"  {self.name} attacks {target.name} for {damage} damage!")
        return damage

    def is_alive(self):
        return self.health > 0   # cleaner version of your original

    def print_info(self):
        bar = make_health_bar(self.health, self.max_health)
        print(f"  {self.name} | {bar} {self.health}/{self.max_health} HP")


# ----------------------------------------------------------
# HERO SUBCLASSES (your originals + special move feedback)
# ----------------------------------------------------------
class Warrior(Character):
    def __init__(self, name, health=120, attack_power=20):
        super().__init__(name, health, attack_power)

    def shield_bash(self, target):
        damage = random.randint(5, 15)
        target.health -= damage
        print(f"  {self.name} SHIELD BASHES {target.name} for {damage} damage! (stun!)")
        return damage


class Mage(Character):
    def __init__(self, name, health=80, attack_power=30, mana=100):
        super().__init__(name, health, attack_power)
        self.mana = mana

    def fireball(self, target):
        if self.mana < 20:
            print(f"  Not enough mana! ({self.mana}/20 needed)")
            return 0
        self.mana -= 20
        damage = random.randint(15, 40)
        target.health -= damage
        print(f"  {self.name} launches FIREBALL at {target.name} for {damage} damage! (Mana left: {self.mana})")
        return damage

    def print_info(self):
        super().print_info()
        print(f"  Mana: {self.mana}/100")


class Archer(Character):
    def __init__(self, name, health=90, attack_power=22):
        super().__init__(name, health, attack_power)

    def power_shot(self, target):
        damage = random.randint(10, 35)
        target.health -= damage
        print(f"  {self.name} fires a POWER SHOT at {target.name} for {damage} damage!")
        return damage


# ----------------------------------------------------------
# ENEMY CLASS (your original + reward now gets used)
# ----------------------------------------------------------
class Enemy(Character):
    def __init__(self, name, reward, health=60, attack_power=15):
        super().__init__(name, health, attack_power)
        self.reward = reward   # gold dropped on defeat


# ----------------------------------------------------------
# HELPER: visual health bar
# ----------------------------------------------------------
def make_health_bar(current, maximum, length=20):
    if maximum == 0:
        filled = 0
    else:
        filled = int((current / maximum) * length)
    filled = max(0, min(filled, length))
    bar = "█" * filled + "░" * (length - filled)
    return f"[{bar}]"


# ----------------------------------------------------------
# BATTLE FUNCTION — now interactive, player chooses moves
# ----------------------------------------------------------
def battle(player, enemy):
    print(f"\n{'='*50}")
    print(f"  ⚔  {player.name}  vs  {enemy.name}")
    print(f"{'='*50}")

    while player.is_alive() and enemy.is_alive():

        # --- Show status ---
        print()
        player.print_info()
        enemy.print_info()
        print()

        # --- Build the menu based on class ---
        print("  Choose your action:")
        print("  [1] Basic Attack")

        if isinstance(player, Warrior):
            print("  [2] Shield Bash  (5–15 dmg, guaranteed hit)")
        elif isinstance(player, Mage):
            print(f"  [2] Fireball     (15–40 dmg, costs 20 mana | you have {player.mana})")
        elif isinstance(player, Archer):
            print("  [2] Power Shot   (10–35 dmg)")

        # --- Get valid input ---
        choice = ""
        while choice not in ["1", "2"]:
            choice = input("  > ").strip()
            if choice not in ["1", "2"]:
                print("  Enter 1 or 2.")

        # --- Execute player move ---
        print()
        if choice == "1":
            player.attack(enemy)
        elif choice == "2":
            if isinstance(player, Warrior):
                player.shield_bash(enemy)
            elif isinstance(player, Mage):
                player.fireball(enemy)
            elif isinstance(player, Archer):
                player.power_shot(enemy)

        # --- Enemy attacks back ---
        if enemy.is_alive():
            enemy.attack(player)
        else:
            print(f"\n  {enemy.name} has been defeated!")
            print(f"  +{enemy.reward} gold earned!")   # reward now gets used
            return True  # player won

    print(f"\n  {player.name} was defeated by {enemy.name}...")
    return False  # player lost


# ----------------------------------------------------------
# CLASS SELECTION SCREEN
# ----------------------------------------------------------
def choose_class(name):
    print("\n  Choose your class:")
    print("  [1] Warrior  — 120 HP | 20 ATK | Shield Bash")
    print("  [2] Mage     —  80 HP | 30 ATK | Fireball (uses mana)")
    print("  [3] Archer   —  90 HP | 22 ATK | Power Shot")

    choice = ""
    while choice not in ["1", "2", "3"]:
        choice = input("  > ").strip()

    if choice == "1":
        return Warrior(name)
    elif choice == "2":
        return Mage(name)
    elif choice == "3":
        return Archer(name)


# ----------------------------------------------------------
# MAIN GAME LOOP
# ----------------------------------------------------------
def main():
    print("=" * 50)
    print("        WELCOME TO THE RPG BATTLE GAME")
    print("=" * 50)

    name = input("\n  Enter your hero's name: ").strip()
    if not name:
        name = "Hero"

    player = choose_class(name)
    gold = 0

    # Enemy progression — gets harder each round
    enemies = [
        Enemy("Goblin",    reward=30,  health=50,  attack_power=10),
        Enemy("Orc",       reward=60,  health=80,  attack_power=16),
        Enemy("Dark Knight", reward=100, health=110, attack_power=22),
        Enemy("Dragon",    reward=200, health=150, attack_power=30),
    ]

    print(f"\n  {player.name} the {type(player).__name__} begins their quest!")
    print(f"  {len(enemies)} enemies stand in your way.\n")
    input("  Press Enter to start...")

    for enemy in enemies:
        won = battle(player, enemy)

        if not won:
            print(f"\n{'='*50}")
            print(f"  GAME OVER")
            print(f"  Gold collected: {gold}")
            print(f"{'='*50}")
            return

        gold += enemy.reward
        print(f"  Total gold: {gold}")

        # Small heal between fights
        if player.is_alive():
            heal = 20
            player.health = min(player.health + heal, player.max_health)
            print(f"  You rest and recover {heal} HP.")

        if enemy != enemies[-1]:
            input("\n  Press Enter to face the next enemy...")

    # Victory!
    print(f"\n{'='*50}")
    print(f"  🏆  VICTORY!  All enemies defeated!")
    print(f"  Final gold: {gold}")
    print(f"  Remaining HP: {player.health}/{player.max_health}")
    print(f"{'='*50}")


if __name__ == "__main__":
    main()