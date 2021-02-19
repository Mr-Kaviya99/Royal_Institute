package lk.ijse.RoyalInstitute.dto;


import lk.ijse.RoyalInstitute.entity.Course;
import lk.ijse.RoyalInstitute.entity.Student;

public class RegisterDTO implements SuperDTO {
    private String regNo;
    private String regDate;
    private String regFee;
    private StudentDTO studentDTO;
    private CourseDTO courseDTO;

    public RegisterDTO(String regNo, String regDate, String regFee, StudentDTO studentDTO, CourseDTO courseDTO) {
        this.regNo = regNo;
        this.regDate = regDate;
        this.regFee = regFee;
        this.studentDTO = studentDTO;
        this.courseDTO = courseDTO;
    }

    public RegisterDTO(String regNo, String regDate, String regFee, Student student, Course course) {
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getRegFee() {
        return regFee;
    }

    public void setRegFee(String regFee) {
        this.regFee = regFee;
    }

    public StudentDTO getStudentDTO() {
        return studentDTO;
    }

    public void setStudentDTO(StudentDTO studentDTO) {
        this.studentDTO = studentDTO;
    }

    public CourseDTO getCourseDTO() {
        return courseDTO;
    }

    public void setCourseDTO(CourseDTO courseDTO) {
        this.courseDTO = courseDTO;
    }

    @Override
    public String toString() {
        return "RegisterDTO{" +
                "regNo=" + regNo +
                ", regDate='" + regDate + '\'' +
                ", regFee='" + regFee + '\'' +
                ", studentDTO=" + studentDTO +
                ", courseDTO=" + courseDTO +
                '}';
    }
}

