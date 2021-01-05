package educative.coderust.SrutiTest.Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LibraryManagement {
   static Map<String,Book> list = new HashMap<>();
   static Map<Integer, Student> details = new HashMap<>();
    public static void main(String[] args) throws IOException {
        Book book1 = new Book("Mathematics", "math01");
        Book book2 = new Book("Physics", "phy02");
        Book book3 = new Book("Chemistry", "ch03");
        list.put(book1.getBookid(),book1);
        list.put(book2.getBookid(),book2);
        list.put(book3.getBookid(),book3);
        while (true) {
            System.out.println("Enter Student rollnumber");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            Integer srol;
            try {
                 srol = Integer.parseInt(br.readLine());
            }catch (Exception e){
                System.out.println("Please enter valid number");
                continue;
            }
            if (details.containsKey(srol)) {
                System.out.println("Hi  " + details.get(srol).getStuname());
                bookProcessingMenu(true, details.get(srol));

            } else {
                System.out.println("Enter your name");
                BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
                String sname = br2.readLine();
                Student s = new Student(sname, srol);
                details.put(s.getRollno(), s);
                bookProcessingMenu(false, details.get(srol));
            }
        }
    }
    public static void bookProcessingMenu(Boolean flag, Student student) throws IOException {
        if (flag) {
            System.out.println("1-issue  a book");
            System.out.println("2-return a book");
            System.out.println("Enter your choice");

        } else {
            System.out.println("1-issue a book");
        }

        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
        int i=0;
        try {
             i= Integer.parseInt(br1.readLine());
        }catch (Exception e){
            System.out.println("Invalid input");
            System.out.println("Enter your choice");
        }

        switch (i) {
            case 1:
                issueBook(student);

                break;
            case 2:
                returnBook(student);
        }
    }

    public static void returnBook(Student student) throws IOException{
        if (student.blist.size() == 0) {
            System.out.println("No book is assigned to you");
        } else {
            System.out.println("Which book do you want to return");
            for (Book b : student.blist.values()) {
                System.out.println(b.bookid + " - " + b.bookname);
            }
            System.out.println("Enter Book Id to return");
            BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
            String id = br3.readLine();
            if (student.blist.containsKey(id)) {
                int i1 = student.removeBook(student.blist.get(id));
                System.out.println("book is now removed from your list");

            }
        }
    }

    public static void issueBook(Student student) throws IOException{
        if(student.blist.size()==2){
            System.out.println("You have already taken 2 books");
        }else {
            for(Book b : list.values()) {
                System.out.println(b.bookid + " - " + b.bookname);
            }
            System.out.println("Enter Book ID");
            BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
            String id = br2.readLine();
            if (list.containsKey(id)) {
                if(list.get(id).issueBook(student)){
                    int i = student.addBook(list.get(id));
                    System.out.println(i + " book is now issued for you");

                }

            }
        }


    }
        }

class Book{
    String bookname;
    String bookid;
    Student student;

    public Book(String bookname, String bookid) {
        this.bookname = bookname;
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }
    public boolean issueBook(Student student){
        if(this.student==null){
        this.student=student;
        return true;
        }else if(student.equals(this.student)){
            System.out.println("you have already assigned a book");
            return false;
        }else {
            System.out.println("This book is assigned to"+this.student.getStuname());
            return false;
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookname='" + bookname + '\'' +
                ", bookid='" + bookid + '\'' +
                '}';
    }
}
class Student{
    Map<String,Book> blist=new HashMap<>();
    String Stuname;
    Integer rollno;


    public Student(String stuname, Integer rollno) {
        Stuname = stuname;
        this.rollno = rollno;
    }
    public Student(){

    }

    public String getStuname() {
        return Stuname;
    }

    public void setStuname(String stuname) {
        Stuname = stuname;
    }

    public Integer getRollno() {
        return rollno;
    }

    public void setRollno(Integer rollno) {
        this.rollno = rollno;
    }
    public Integer addBook(Book book){
        blist.put(book.getBookid(),book);
        return blist.size();
    }
    public Integer removeBook(Book book){
        book.student=null;
        blist.remove(book.getBookid(),book);
        return blist.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(Stuname, student.Stuname) &&
                Objects.equals(rollno, student.rollno);
    }
    @Override
    public int hashCode() {
        return Objects.hash(Stuname, rollno);
    }
}