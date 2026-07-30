#include <iostream>
#include <map>
#include <string>

using namespace std;

// Student Result System

struct Student
{
    string name;
    map<string, int> marks;
    int total;
    double percentage;
    string grade;
};

map<string, Student> students;

string calculateGrade(double percentage)
{
    if (percentage >= 90)
        return "A+";
    else if (percentage >= 80)
        return "A";
    else if (percentage >= 70)
        return "B";
    else if (percentage >= 60)
        return "C";
    else if (percentage >= 50)
        return "D";
    else
        return "F";
}

void addStudent()
{
    string rollNo, name;

    cout << "Enter Roll Number: ";
    cin >> rollNo;

    cin.ignore();

    cout << "Enter Student Name: ";
    getline(cin, name);

    map<string, int> marks;
    string subjects[] = {"Math", "Physics", "Computer"};

    int total = 0;

    for (string subject : subjects)
    {
        int mark;
        cout << "Enter " << subject << " marks: ";
        cin >> mark;

        marks[subject] = mark;
        total += mark;
    }

    double percentage = (double)total / 3;
    string grade = calculateGrade(percentage);

    students[rollNo] = {name, marks, total, percentage, grade};

    cout << "Student added successfully!\n";
}

void displayResults()
{
    if (students.empty())
    {
        cout << "No records found\n";
        return;
    }

    for (auto student : students)
    {
        cout << "\n----------------------\n";
        cout << "Roll Number: " << student.first << endl;
        cout << "Name: " << student.second.name << endl;

        cout << "Marks:\n";
        for (auto mark : student.second.marks)
        {
            cout << mark.first << ": " << mark.second << endl;
        }

        cout << "Total: " << student.second.total << endl;
        cout << "Percentage: " << student.second.percentage << "%" << endl;
        cout << "Grade: " << student.second.grade << endl;
    }
}

void searchStudent()
{
    string roll;

    cout << "Enter Roll Number to search: ";
    cin >> roll;

    if (students.find(roll) != students.end())
    {
        Student data = students[roll];

        cout << "\nStudent Result\n";
        cout << "Name: " << data.name << endl;

        cout << "Marks:\n";
        for (auto mark : data.marks)
        {
            cout << mark.first << ": " << mark.second << endl;
        }

        cout << "Percentage: " << data.percentage << "%" << endl;
        cout << "Grade: " << data.grade << endl;
    }
    else
    {
        cout << "Student not found\n";
    }
}

int main()
{
    while (true)
    {
        cout << "\n===== Student Result System =====\n";
        cout << "1. Add Student\n";
        cout << "2. Display Results\n";
        cout << "3. Search Student\n";
        cout << "4. Exit\n";

        string choice;

        cout << "Enter choice: ";
        cin >> choice;

        if (choice == "1")
        {
            addStudent();
        }
        else if (choice == "2")
        {
            displayResults();
        }
        else if (choice == "3")
        {
            searchStudent();
        }
        else if (choice == "4")
        {
            cout << "Program Ended\n";
            break;
        }
        else
        {
            cout << "Invalid choice\n";
        }
    }

    return 0;
}
