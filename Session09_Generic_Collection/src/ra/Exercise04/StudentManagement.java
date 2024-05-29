package ra.Exercise04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentManagement {
    static List<Student> studentList = new ArrayList<>();

    public static void showAll(){
        System.out.println("DANH SÁCH SINH VIÊN LÀ:");
        for (Student student : studentList){
            System.out.println(student);
        }
    }

    public static void addStudent(Student student){
        studentList.add(student);
    }

    public static void removeStudent(int studentId){
        for (Student student : studentList){
            if(studentId == student.getStudentId()){
                studentList.remove(student);
                break;
            }
        }
    }

    public static Student findStudentById(int studentId){
        Student tmp = null;
        for (Student student : studentList){
            if(student.getStudentId() == studentId){
                tmp = student;
                break;
            }
        }
        return tmp;
    }

    public static void getAverageScore(){
        for (Student student : studentList){
            System.out.printf("%.3f\t", student.getAverageScore());
        }
    }

    public static void sortByScore(){
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return (int) o1.getAverageScore() - (int) o2.getAverageScore();
            }
        });
    }

    public static void main(String[] args) {
        Student student1 = new Student(1,"Trần",6.5);
        Student student2 = new Student(2,"Xuân",5.5);
        Student student3 = new Student(3,"Hồng",9.5);

        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        showAll();
        addStudent(student2);
        showAll();
        removeStudent(1);
        showAll();

        System.out.println("Điểm trung bình của tất cả sinh viên là:");
        getAverageScore();
        sortByScore();
        System.out.println("Sinh viên sắp xếp theo điểm tăng dần là: ");
        showAll();
    }


}
