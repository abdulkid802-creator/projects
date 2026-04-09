# class Pet:
#     def __init__(self, name):
#         self.name = name
#         self.hunger = 50
#         self.happiness = 50
#         self.energy = 50
#
#     def feed(self):
#         self.hunger -= 10
#         self.energy += 10
#
#     def rest(self):
#         self.energy += 20
#
#     def speak(self):
#         pass
#
#     def play(self):
#         if self.energy < 20:
#             print("Pet is too tired")
#         else:
#             self.happiness += 10
#             self.energy -= 10
#
#     def print_info(self):
#         print(f"Name: {self.name}")
#         print(f"Hunger: {self.hunger}")
#         print(f"Happiness: {self.happiness}")
#         print(f"Energy: {self.energy}")
#
# class Dog(Pet):
#     def __init__(self, name):
#         super().__init__(name)
#
#     def speak(self):
#         print("Woof!")
#
#     def play(self):
#         super().play()
#         print(f"{self.name} is chasing a ball!")
#
# class Cat(Pet):
#     def __init__(self, name):
#         super().__init__(name)
#
#     def speak(self):
#         print("Meow!")
#
#     def play(self):
#         super().play()
#         print(f"{self.name} is playing with a ball!")
#
# class Rabbit(Pet):
#     def __init__(self, name):
#         super().__init__(name)
#
#     def speak(self):
#         print("Squeak!")
#
#     def play(self):
#         super().play()
#         print(f"{self.name} is playing with a carrot!")
#
# dog = Dog("Max")
# dog.feed()
# dog.play()
# dog.speak()
# dog.print_info()
#
# print()
#
# cat = Cat("Kai")
# cat.feed()
# cat.print_info()
# cat.play()
# cat.speak()
#
# print()
#
# rabbit = Rabbit("Kaz")
# rabbit.rest()
# rabbit.print_info()
# rabbit.play()
# rabbit.speak()
