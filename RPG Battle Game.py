# import random
#
# class Character:
#     def __init__(self, name, health = 0, attack_power = 0):
#         self.name = name
#         self.health = health
#         self.attack_power = attack_power
#
#     def attack(self, target):
#         damage = random.randint(1, self.attack_power)
#         target.health -= damage
#         print(f"{self.name} attacks {target.name} for {damage} damage! {target.health}")
#
#     def is_alive(self):
#         if self.health > 0:
#             return True
#         else:
#             return False
#
#     def print_info(self):
#         print(f"Name: {self.name}")
#         print(f"Health: {self.health}")
#
# class Warrior(Character):
#     def __init__(self, name, health = 120, attack_power = 20):
#         super().__init__(name, health, attack_power)
#
#     def shield_bash(self, target):
#         damage = random.randint(5, 15)
#         target.health -= damage
#
# class Mage(Character):
#     def __init__(self, name, health = 80, attack_power = 30, mana = 100):
#         super().__init__(name, health, attack_power)
#         self.mana = mana
#
#     def fireball(self, target):
#         if self.mana < 20:
#             print("Mana is too low")
#             return
#
#         self.mana -= 20
#         damage = random.randint(15, 40)
#         target.health -= damage
#
# class Archer(Character):
#     def __init__(self, name, health = 90, attack_power = 22):
#         super().__init__(name, health, attack_power)
#
#     def power_shot(self, target):
#         damage = random.randint(10, 35)
#         target.health -= damage
#
# class Enemy(Character):
#     def __init__(self, name, reward, health = 60, attack_power = 15):
#         super().__init__(name, health, attack_power)
#         self.reward = reward
#
# def battle(player, enemy):
#     print(f"\n--- Battle: {player.name} vs {enemy.name} ---")
#
#     while player.is_alive() and enemy.is_alive():
#         player.attack(enemy)
#
#         if enemy.is_alive():
#             enemy.attack(player)
#
#     if player.is_alive():
#         print(f"{player.name} defeated {enemy.name}!")
#     else:
#         print(f"{enemy.name} defeated {player.name}!")
#
# player = Warrior("Abdul")
#
# goblin = Enemy("Goblin", 50, 50, 10)
# dragon = Enemy("Dragon", 200, 120, 25)
#
# battle(player, goblin)
# player.print_info()
#
# battle(player, dragon)
# player.print_info()
