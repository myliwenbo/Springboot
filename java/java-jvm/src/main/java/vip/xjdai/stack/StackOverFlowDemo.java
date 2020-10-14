package vip.xjdai.stack;


/**
 * 栈溢出演示
 */
public class StackOverFlowDemo {

    static class Student {
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

    /**
     * 对象直接打印的时候会去调用 toString() 方法，也正是因为这个原因导致了循环调用
     * @param args
     */
    public static void main(String[] args) {
        Student student = new Student("zhang3");
        Book book = new Book("1111", student);
        student.book = book;
        System.out.println(book.toString());
    }

}
