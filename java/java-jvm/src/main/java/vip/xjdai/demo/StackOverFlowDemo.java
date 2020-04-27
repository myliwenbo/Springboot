package vip.xjdai.demo;

//book和student相互循环引用
public class StackOverFlowDemo {

    static class Student{
        String name;
        Book book;

        public Student(String name) {
            this.name = name;
        }
        //循环调用toString方法
        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", book=" + book +
                    '}';
        }
    }

    static class Book {
        String isbn;
        Student student;

        public Book(String isbn, Student student) {
            this.isbn = isbn;
            this.student = student;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "isbn='" + isbn + '\'' +
                    ", student=" + student +
                    '}';
        }
    }

    public static void main(String[] args) {
        Student student=new Student("zhang3");
        Book book=new Book("1111",student);
        student.book=book;
        System.out.println(book.toString());
    }

}
