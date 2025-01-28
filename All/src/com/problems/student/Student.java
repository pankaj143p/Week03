package src.com.problems.student;
// create a class Student with rollNumber, name, age, grade, next, prev
class Student {
    String rollNumber;
    String name;
    int age;
    char grade;
    Student next, prev;

    Student(String rollNumber, String name, int age, char grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}