package dao;

import dto.AddressDTO;
import model.Address;
import model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateSessionFactory;

public class AddressDAO {
    private final SessionFactory sessionFactory;

    public AddressDAO() {
        this.sessionFactory = HibernateSessionFactory.getSessionFactory();
    }


    public void save(AddressDTO addressDTO) {
        Session session = sessionFactory.openSession();
        Transaction transaction= session.getTransaction();
        transaction.begin();

        Address address = new Address(addressDTO.getName(),addressDTO.getType());
        Student student = session.find(Student.class,addressDTO.getStudent_id());
        address.setStudent(student);
        session.persist(address);

        transaction.commit();
        session.close();
    }
}
