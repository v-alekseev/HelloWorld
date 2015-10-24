package com.valekseev.helloworld;

import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class HelloWorld {
    public static void main(String[] args) {

        System.out.println("HelloWorld. Main() called");

        try {
            System.out.println("Adding book");

            HelloWorld main = new HelloWorld();

            // Добавление новыхrybu
            //main.addBook("book1", 1990);


            List<Book> list;
            list = main.listBooks();

            for (Book b : list) {
                System.out.println(b.toString2());

            }


            System.out.println("Adding author");

            //main.addAuthor("Lev","Tolstoy", 100);
            List<Author> listAuthor;
            listAuthor = main.listAuthor();


            for (Author a : listAuthor) {
                System.out.println(a.toString());
                //System.out.println(a.toFullString());

            }

            //main.addAuthorToBook(new Long(1), new Long(1));
            //main.addEmailToAuthor(new Long(1),"valekseev@yandex.ru");

            System.out.println("Author - " + main.GetAuthor(new Long(1)).toFullString());

        }  catch (Exception e) {

            System.out.println("ERROR!");
            e.printStackTrace();
        }  finally {}
    }


    // Метод добавляет новую запись в таблицу BOOK
    private void addBook(String name, Integer year) {
        Session session = HibernateUtil.getCurrentSession();
        session.beginTransaction();
        Book book_record = new Book();
        book_record.setName(name);
        book_record.setYear(year);
        session.save(book_record);
        session.getTransaction().commit();
    }

    // Метод возвращает список профессий
    private List<Book> listBooks() {
        Session session = HibernateUtil.getCurrentSession();
        session.beginTransaction();
        List<Book> result = session.createQuery("from Book order by year").list();

        session.getTransaction().commit();
        return result;
    }


    // Метод добавляет новую запись в таблицу BOOK
    private void addAuthor(String firstName, String lastName,Integer age) {
        Session session = HibernateUtil.getCurrentSession();
        session.beginTransaction();
        Author author_record = new Author(firstName, lastName,age);
        session.save(author_record);
        session.getTransaction().commit();
    }

    // Метод возвращает список профессий
    private List<Author> listAuthor() {
        Session session = HibernateUtil.getCurrentSession();
        session.beginTransaction();
        List<Author> result = session.createQuery("from Author order by firstName").list();
        //List<Author> result = session.createQuery("select Author.authorId,Author.firstName,Author.lastName,Author.age,person_email_addr.emailAddresses from Author, person_email_addr order by firstName").list();
        //Query query = session.createQuery("select authorId,firstName,lastName,age from Author order by firstName");
        //List res = query.list();
        session.getTransaction().commit();
        return result;
    }
    private void addAuthorToBook(Long authorId, Long bookId) {
        Session session = HibernateUtil.getCurrentSession();
        session.beginTransaction();

        Author author = (Author) session.load(Author.class, authorId);
        Book book = (Book) session.load(Book.class, bookId);
        book.getAuthors().add(author);

        session.getTransaction().commit();
    }
    private void addEmailToAuthor(Long authorId, String emailAddress) {
        Session session = HibernateUtil.getCurrentSession();
        session.beginTransaction();

        Author aAuthor = (Author) session.load(Author.class, authorId);
        // adding to the emailAddress collection might trigger a lazy load of the collection
        aAuthor.getEmailAddresses().add(emailAddress);

        session.getTransaction().commit();
    }

    private Author GetAuthor(Long authorId) {
        Session session = HibernateUtil.getCurrentSession();
        //session.beginTransaction();

        Author aAuthor = (Author) session.load(Author.class, authorId);
         //session.getTransaction().commit();
        return  aAuthor;
    }

}

/*        List<book> list = new ArrayList<>();

        book bk1 = new book("war", 1820);
        book bk2 = new book("peace", 1320);

        list.add(bk1);
        list.add(bk2);
        for (book b : list) {
            System.out.println(b.toString());
        }


        System.out.println("**PostgreSQ && JDBC Connection **");

        try {
            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {

            System.out.println("can not found! plz check the jar file");
            e.printStackTrace();
            return;

        }

        System.out.println("PostgreSQL JDBC Driver connected!");

        Connection connection = null;

        try {

            connection = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/testdb",
                    "postgres",
                    "sa");
            if (connection != null) {
                System.out.println("you connected now!");
            }


            Statement selectStmt = connection.createStatement();
            ResultSet rs = selectStmt.executeQuery("SELECT * FROM clients");
            int i=0;
            System.out.println("Clients table." + rs.toString());
            while(rs.next())
            {
                System.out.println("Row - " + ++i);
                System.out.println("\t" + rs.getString(1));    //First Column
                System.out.println("\t" + rs.getString(2));    //Second Column
             }
           System.out.println("End clients table");

        } catch (SQLException e) {

            System.out.println("Connection Failed!");
            e.printStackTrace();

        }
        finally {
            if(connection != null)
            {
                try{
                    connection.close();
                }catch (Exception ex){
                    System.out.println("Error close connection");
                    ex.printStackTrace();
                }
            }
        }


*/
// }
