import dao.AddressDAO;
import dto.AddressDTO;
import dto.StudentIDAndNameDTO;
import model.Student;
import dao.StudentDAO;

import java.rmi.StubNotFoundException;
import java.util.List;

public class HibernateMain {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
//        Student student = new Student("shyam","csi");
//        studentDAO.save(student);

//        //find all data
//        List<Student> allStudentList= studentDAO.findAll();  //returns the same data type that is used in the DAO
//        System.out.println(allStudentList);
//
//        List<StudentIDAndNameDTO> mappedStudent = studentDAO.findAllStudentIdAndName();
//        System.out.println(mappedStudent);

//        //to find by id
//        Student returnData= studentDAO.findById(52);
//        System.out.println(returnData);


        //to update name by id
        System.out.println(studentDAO.findById(52)); //checking original value

        studentDAO.updateNameById(52,"Shyam");
        System.out.println(studentDAO.findById(52)); //checking the updated value

        //to delete by id
//        studentDAO.deleteById(2);

        AddressDAO addressDAO=new AddressDAO();

        AddressDTO tempAddress=new AddressDTO("PKR","TEMP",52);
        AddressDTO permanentAddress=new AddressDTO("KTM","PERM",52);

        addressDAO.save(tempAddress);
        addressDAO.save(permanentAddress);
    }
}
