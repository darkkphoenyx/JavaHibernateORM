package dto;

public class StudentIDAndNameDTO {
    private Integer studentID;
    private String studentName;
    public StudentIDAndNameDTO(Integer studentID, String studentName) {
        this.studentID = studentID;
        this.studentName = studentName;
    }

    public StudentIDAndNameDTO() {   //for instantiating

    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return "StudentIDAndNameDTO{" +
                "studentID=" + studentID +
                ", studentName='" + studentName + '\'' +
                '}';
    }
}
