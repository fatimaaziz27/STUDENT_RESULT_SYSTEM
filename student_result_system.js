// Student Result System
// Student Result System

const prompt = require("prompt-sync")();

const students = {};

function calculateGrade(percentage) {
    if (percentage >= 90) {
        return "A+";
    } else if (percentage >= 80) {
        return "A";
    } else if (percentage >= 70) {
        return "B";
    } else if (percentage >= 60) {
        return "C";
    } else if (percentage >= 50) {
        return "D";
    } else {
        return "F";
    }
}

function addStudent() {
    const rollNo = prompt("Enter Roll Number: ");
    const name = prompt("Enter Student Name: ");

    const marks = {};
    const subjects = ["Math", "Physics", "Computer"];

    let total = 0;

    for (const subject of subjects) {
        const mark = Number(prompt(`Enter ${subject} marks: `));
        marks[subject] = mark;
        total += mark;
    }

    const percentage = total / subjects.length;
    const grade = calculateGrade(percentage);

    students[rollNo] = {
        name,
        marks,
        total,
        percentage,
        grade
    };

    console.log("Student added successfully!\n");
}

function displayResults() {
    if (Object.keys(students).length === 0) {
        console.log("No records found");
        return;
    }

    for (const roll in students) {
        const data = students[roll];

        console.log("\n----------------------");
        console.log("Roll Number:", roll);
        console.log("Name:", data.name);
        console.log("Marks:", data.marks);
        console.log("Total:", data.total);
        console.log("Percentage:", data.percentage + "%");
        console.log("Grade:", data.grade);
    }
}

function searchStudent() {
    const roll = prompt("Enter Roll Number to search: ");

    if (students[roll]) {
        const data = students[roll];

        console.log("\nStudent Result");
        console.log("Name:", data.name);
        console.log("Marks:", data.marks);
        console.log("Percentage:", data.percentage + "%");
        console.log("Grade:", data.grade);
    } else {
        console.log("Student not found");
    }
}

while (true) {
    console.log("\n===== Student Result System =====");
    console.log("1. Add Student");
    console.log("2. Display Results");
    console.log("3. Search Student");
    console.log("4. Exit");

    const choice = prompt("Enter choice: ");

    if (choice === "1") {
        addStudent();
    } else if (choice === "2") {
        displayResults();
    } else if (choice === "3") {
        searchStudent();
    } else if (choice === "4") {
        console.log("Program Ended");
        break;
    } else {
        console.log("Invalid choice");
    }
}
