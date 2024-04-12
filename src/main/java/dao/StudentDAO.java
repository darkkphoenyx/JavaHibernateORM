package dao;

import dto.StudentIDAndNameDTO;
import model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateSessionFactory;

import java.util.List;

public class StudentDAO {
    private final SessionFactory sessionFactory;

    public StudentDAO() {
        this.sessionFactory = HibernateSessionFactory.getSessionFactory();
    }


    //to write one data at a time to the database
    public void save(Student student) {
        Session session = sessionFactory.openSession();
        Transaction transaction= session.getTransaction();
        transaction.begin();

        session.persist(student);   //saves student to database

        transaction.commit();
        session.close();
    }


    //to get the specific data from database using an ID
    public Student findById(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction transaction= session.getTransaction();
        transaction.begin();

        Student student = session.find(Student.class, id);   //saves student to database

        transaction.commit();
        session.close();
        return student;
    }


    //to delete a particular data using the ID
    public void deleteById(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction transaction= session.getTransaction();
        transaction.begin();

        Student student = session.get(Student.class, id);
        session.remove(student);
        transaction.commit();
        session.close();
    }

    //to get all the data from the database
    public List<Student> findAll()
    {
        Session session = sessionFactory.openSession();
        Transaction transaction= session.getTransaction();
        transaction.begin();

        List<Student> studentList= session.createQuery("from Student",Student.class).getResultList();

        transaction.commit();
        session.close();
        return studentList;
    }

    //to display the name from the database i.e only accessing certain data
    public List<StudentIDAndNameDTO> findAllStudentIdAndName(){
        Session session = sessionFactory.openSession();
        Transaction transaction= session.getTransaction();
        transaction.begin();

        //core logic -- similar to mapping
        List<StudentIDAndNameDTO> studentList = session.createQuery("Select s.id, s.name from Student s",StudentIDAndNameDTO.class).getResultList();

        transaction.commit();
        session.close();
        return studentList;
    }

    //to display the name from the database i.e only accessing certain data
    public void updateNameById(Integer id, String name) {
        Session session = sessionFactory.openSession();
        Transaction transaction= session.getTransaction();
        transaction.begin();

        //core logic -- similar to mapping
        Query updateQuery = session.createQuery("update Student set name= :name where id= :id");
        updateQuery.setParameter("name",name);
        updateQuery.setParameter("id",id);

        updateQuery.executeUpdate();

        transaction.commit();
        session.close();
    }


}
