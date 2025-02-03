package src.com.problems.student;
class StudentRecordManagement {
    public static void main(String[] args) {
        StudentNode sn = new StudentNode();
        Student s1 = new Student("10hs", "Alice", 21, 'd');
        Student s2 = new Student("10s", "Alice1", 23, 'c');
        Student s3 = new Student("1011hs", "Alice3", 22, 'd');
        Student s4 = new Student("10hews", "Alice5", 26, 'a');
        Student s5 = new Student("10hsfsfs", "Alice6", 18, 'b');
        sn.addBegning(s1);
        sn.addBegning(s2);
        sn.addEnding(s3);
        sn.search("1011hs");
        sn.dispaly();
        sn.addBegning(s4);
        sn.updateGrade("10hews", 'e');
        sn.atPosition(2, s5);
        sn.dispaly();
        // System.out.println("-------------------------");
        sn.delete("10s");
        sn.dispaly();
    }

}
