# --- Base Book Class ---
class Book:
    def __init__(self, title, author, pages):
        self.title = title
        self.author = author
        self.pages = pages
        self.checked_out = False

    def print_info(self):
        status = "Available" if not self.checked_out else "Checked out"
        print(f"Title: {self.title} | Author: {self.author} | Pages: {self.pages} | Status: {status}")


# --- Fiction Subclass ---
class Fiction(Book):
    def __init__(self, title, author, pages, genre):
        super().__init__(title, author, pages)
        self.genre = genre

    def print_info(self):
        status = "Available" if not self.checked_out else "Checked out"
        print(f"Title: {self.title} | Author: {self.author} | Pages: {self.pages} | Genre: {self.genre} | Status: {status}")


# --- Textbook Subclass ---
class Textbook(Book):
    def __init__(self, title, author, pages, subject):
        super().__init__(title, author, pages)
        self.subject = subject

    def print_info(self):
        status = "Available" if not self.checked_out else "Checked out"
        print(f"Title: {self.title} | Author: {self.author} | Pages: {self.pages} | Subject: {self.subject} | Status: {status}")


# --- Library Class ---
class Library:
    def __init__(self, name):
        self.name = name
        self.books = []

    def add_book(self, book):
        self.books.append(book)

    def checkout(self, title):
        for book in self.books:
            if book.title == title:
                if not book.checked_out:
                    book.checked_out = True
                    print(f'"{book.title}" has been checked out.')
                    return
                else:
                    print(f'"{book.title}" is already checked out.')
                    return
        print(f'Book titled "{title}" not found.')

    def return_book(self, title):
        for book in self.books:
            if book.title == title:
                if book.checked_out:
                    book.checked_out = False
                    print(f'"{book.title}" has been returned and is now available.')
                    return
                else:
                    print(f'"{book.title}" was not checked out.')
                    return
        print(f'Book titled "{title}" not found.')

    def show_all(self):
        print(f"\nBooks in {self.name}:")
        if not self.books:
            print("The library has no books.")
        for book in self.books:
            book.print_info()

city_library = Library("City Library")

# Adding books
city_library.add_book(Fiction("Dune", "Frank Herbert", 412, "Sci-Fi"))
city_library.add_book(Textbook("Python Crash Course", "Eric Matthes", 544, "Programming"))
city_library.add_book(Fiction("1984", "George Orwell", 328, "Dystopia"))

# Checkout a book
city_library.checkout("Dune")

# Show all books
city_library.show_all()