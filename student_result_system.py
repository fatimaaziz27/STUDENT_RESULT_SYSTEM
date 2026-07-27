# Features:
# Add student records
# Store marks of subjects
# Calculate total marks
# Calculate percentage
# Assign grades
# Display student results
# Search student results
# Python Code:
# Student Result System

students = {}

def calculate_grade(percentage):
    if percentage >= 90:
        return "A+"
    elif percentage >= 80:
        return "A"
    elif percentage >= 70:
        return "B"
    elif percentage >= 60:
        return "C"
    elif percentage >= 50:
        return "D"
    else:
        return "F"


def add_student():
    roll_no = input("Enter Roll Number: ")
    name = input("Enter Student Name: ")

    marks = {}
    subjects = ["Math", "Physics", "Computer"]

    for subject in subjects:
        marks[subject] = int(input(f"Enter {subject} marks: "))

    total = sum(marks.values())
    percentage = total / len(subjects)

    grade = calculate_grade(percentage)

    students[roll_no] = {
        "name": name,
        "marks": marks,
        "total": total,
        "percentage": percentage,
        "grade": grade
    }

    print("Student added successfully!\n")


def display_results():
    if not students:
        print("No records found")
        return

    for roll, data in students.items():
        print("\n----------------------")
        print("Roll Number:", roll)
        print("Name:", data["name"])
        print("Marks:", data["marks"])
        print("Total:", data["total"])
        print("Percentage:", data["percentage"], "%")
        print("Grade:", data["grade"])


def search_student():
    roll = input("Enter Roll Number to search: ")

    if roll in students:
        data = students[roll]

        print("\nStudent Result")
        print("Name:", data["name"])
        print("Marks:", data["marks"])
        print("Percentage:", data["percentage"], "%")
        print("Grade:", data["grade"])
    else:
        print("Student not found")


while True:
    print("\n===== Student Result System =====")
    print("1. Add Student")
    print("2. Display Results")
    print("3. Search Student")
    print("4. Exit")

    choice = input("Enter choice: ")

    if choice == "1":
        add_student()

    elif choice == "2":
        display_results()

    elif choice == "3":
        search_student()

    elif choice == "4":
        print("Program Ended")
        break

    else:
        print("Invalid choice")

# Example Output:
# ===== Student Result System =====
# 1. Add Student
# 2. Display Results
# 3. Search Student
# 4. Exit

# Enter choice: 1

# Enter Roll Number: 101
# Enter Student Name: Fatima
# Enter Math marks: 90
# Enter Physics marks: 85
# Enter Computer marks: 95

# Student added successfully!
# Concepts Practiced:

# ✅ Variables
# ✅ Input/Output
# ✅ Functions
# ✅ Dictionaries
# ✅ Loops
# ✅ Conditional statements
# ✅ CRUD operations

# Next improvements you can add:

# Save records permanently using a .txt or .json file
# Add GUI using Tkinter
# Add login system for teachers/admin
# Generate result cards as PDF
# Use SQLite database
