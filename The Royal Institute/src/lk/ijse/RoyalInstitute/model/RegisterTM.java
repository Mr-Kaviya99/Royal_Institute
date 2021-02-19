package lk.ijse.RoyalInstitute.model;

import lk.ijse.RoyalInstitute.dto.CourseDTO;
import lk.ijse.RoyalInstitute.dto.StudentDTO;

public class RegisterTM {
    private String regNo;
    private String regDate;
    private String regFee;
    private String StudentId;
    private String CourseId;

    public RegisterTM(String regNo, String regDate, String regFee, String studentId, String courseId) {
        this.regNo = regNo;
        this.regDate = regDate;
        this.regFee = regFee;
        StudentId = studentId;
        CourseId = courseId;
    }

    public RegisterTM(String regNo, String regDate, String regFee, StudentDTO studentDTO, CourseDTO courseDTO) {
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

    public String getStudentId() {
        return StudentId;
    }

    public void setStudentId(String studentId) {
        StudentId = studentId;
    }

    public String getCourseId() {
        return CourseId;
    }

    public void setCourseId(String courseId) {
        CourseId = courseId;
    }

    @Override
    public String toString() {
        return "RegisterTM{" +
                "regNo='" + regNo + '\'' +
                ", regDate='" + regDate + '\'' +
                ", regFee='" + regFee + '\'' +
                ", StudentId='" + StudentId + '\'' +
                ", CourseId='" + CourseId + '\'' +
                '}';
    }
}
