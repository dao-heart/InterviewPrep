package Java8;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Student implements Comparable<Student> {

    int ID;
    String name;
    double GPA;
    double score;

    public Student(int ID, String name, double GPA, double score) {
        this.ID = ID;
        this.name = name;
        this.GPA = GPA;
        this.score = score;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public double getGPA() {
        return GPA;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", GPA=" + GPA +
                ", score=" + score +
                '}';
    }

    public double getScore() {
        return score;
    }

    /*@Override
    public int compareTo(Student student){
        if(this.getGPA()==student.getGPA()) return 0;
        if(this.getGPA()>student.getGPA()) return -1;
        else return 1;
    }
*/
    @Override
    public int compareTo(Student student){
        if(this.getScore()==student.getScore()) return 0;
        if(this.getScore()>student.getScore()) return -1;
        else return 1;
    }
}


public class PriorityQueueCheck {
    public static void main(String[] args) {

        Student s1 = new Student(1,"Gaurang", 4,10);
        Student s2 = new Student(2,"Shreya", 3.4,10);
        Student s3 = new Student(3,"Vishruti", 3.5,10);
        Student s4 = new Student(4,"Nitin", 3.7,10);
        Student s5 = new Student(5,"Amol", 3.9,10);

        //Queue<Student> pQueue = new PriorityQueue(); // with comparable -> compareTo @override used for sorting the records based on class
        //--------------------
/*
        Comparator<Student> comparator =  new Comparator<Student>(){ //[SAME]  with comparator -> compare @override used for sorting based on @overriden function
            @Override
           public int compare(Student student1, Student student2){
               if(student1.getGPA()==student2.getGPA()) return 0;
               if(student1.getGPA()>student2.getGPA()) return -1;
               else return 1;
           }
        };

        Queue<Student> pQueue =  new PriorityQueue<>(comparator);*/

        //----------------------------


        Comparator<Student> comparator = (student1, student2) -> { // [SAME] Same code with lambda
            if(student1.getGPA()==student2.getGPA()) return 0;
            if(student1.getGPA()>student2.getGPA()) return -1;
            else return 1;
        };

        Queue<Student> pQueue =  new PriorityQueue<>(comparator);


        //-------------------------------
        pQueue.add(s1);
        pQueue.add(s2);
        pQueue.add(s3);
        pQueue.add(s4);
        pQueue.add(s5);

        System.out.println("Queue in order of GPA");
        System.out.println();
        while (!pQueue.isEmpty()){
            System.out.println(pQueue);

            System.out.println(pQueue.remove());
        }


    }
}
