# Student Course Manager

A simple system developed in Java to manage students, courses, and enrollments. This project was created purely for learning and practicing object-oriented programming in Java, without the use of external frameworks or databases.

## 📚 Overview

**Student Course Manager** is a basic educational management system developed using pure Java and object-oriented programming (OOP) principles. It allows users to manage the following operations through a text-based menu interface:

1. **Manage Students** – Register, list, and search for students.
2. **Manage Courses** – Register, list, and search for courses.
3. **Enroll Students in Courses** – Enroll students into courses.
4. **View Enrollments** – View the list of student enrollments.
5. **Exit** - Exit the system.

## 🧠 Features

- Clean object-oriented architecture with domain models for `Student`, `Course`, and `Enrollment`.
- Separation of concerns across packages:
  - `domain`: Core domain classes
  - `repositories`: Data storage (in-memory)
  - `services`: Business logic
  - `ui`: User interface handlers and input capture
  - `exceptions`: Custom exception handling
  - `utils`: Reusable utilities and messages
- Custom exception handling for common validation issues.
- Organized menu with intuitive options.

## 🗂️ Project Structure

```
src/
├── developer/ezandro/
│   ├── domain/               # Core entities
│   ├── repositories/         # In-memory data repositories
│   ├── services/             # Business logic (Managers)
│   ├── exceptions/           # Custom exceptions
│   ├── utils/                # Utility classes
│   └── ui/                   # User input and menu handling
└── main/
    └── Main.java             # Entry point
```

## ▶️ How to Run

1. Compile the project using your preferred IDE (e.g., IntelliJ, Eclipse) or command-line.
2. Run the `Main` class.
3. Follow the interactive menu to use the system.

## 💡 Technologies

- Java 24
- No external frameworks or dependencies

## 🚧 Limitations

- All data is stored **in memory only**. When the application terminates, all data is lost. This design choice was intentional to keep the project focused on learning core Java concepts.
- Console-based input/output

## 🙌 Author

Developed by Ezandro as a personal project for practicing Java.
