package lk.ijse.RoyalInstitute.business.custom;

import lk.ijse.RoyalInstitute.business.SuperBO;
import lk.ijse.RoyalInstitute.dto.StudentDTO;

import java.util.ArrayList;

public interface CourseBO extends SuperBO {
    public boolean saveStudent(StudentDTO studentDTO)throws Exception;

    public boolean deleteStudent(StudentDTO student)throws Exception;

    public boolean updateStudent(StudentDTO studentDTO)throws Exception;

    public StudentDTO getStudent(String id)throws Exception;

    public ArrayList<StudentDTO> getAllStudents()throws Exception;
}
