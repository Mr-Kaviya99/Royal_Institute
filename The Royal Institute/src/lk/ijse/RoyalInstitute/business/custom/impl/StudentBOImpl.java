package lk.ijse.RoyalInstitute.business.custom.impl;

import lk.ijse.RoyalInstitute.business.custom.StudentBO;
import lk.ijse.RoyalInstitute.dao.DAOFactory;
import lk.ijse.RoyalInstitute.dao.DAOType;
import lk.ijse.RoyalInstitute.dao.custom.impl.StudentDAOImpl;
import lk.ijse.RoyalInstitute.dto.StudentDTO;
import lk.ijse.RoyalInstitute.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {

    StudentDAOImpl studentDAO = DAOFactory.getInstance().getDAO(DAOType.STUDENT);

    @Override
    public boolean saveStudent(StudentDTO studentDTO) throws Exception {
        return studentDAO.add(new Student(studentDTO.getId(),
                studentDTO.getStudentName(),
                studentDTO.getAddress(),
                studentDTO.getContact(),
                studentDTO.getDob(),
                studentDTO.getGender()));
    }

    @Override
    public boolean deleteStudent(StudentDTO student) throws Exception {
        return studentDAO.delete(new Student(student.getId(),
                student.getStudentName(),
                student.getAddress(),
                student.getContact(),
                student.getDob(),
                student.getGender()));
    }

    @Override
    public boolean updateStudent(StudentDTO studentDTO) throws Exception {
        return studentDAO.update(new Student(studentDTO.getId(),
                studentDTO.getStudentName(),
                studentDTO.getAddress(),
                studentDTO.getContact(),
                studentDTO.getDob(),
                studentDTO.getGender()));
    }

    @Override
    public StudentDTO getStudent(String id) throws Exception {
        Student student = studentDAO.getOne(id);
        return new StudentDTO(
                student.getId(),
                student.getStudentName(),
                student.getAddress(),
                student.getContact(),
                student.getDob(),
                student.getGender());
    }

    @Override
    public ArrayList<StudentDTO> getAllStudents() throws Exception {
        List<Student> studentList = studentDAO.getAll();
        ArrayList<StudentDTO> dtoList = new ArrayList();
        for (Student student : studentList) {
            dtoList.add(new StudentDTO(
                    student.getId(),
                    student.getStudentName(),
                    student.getAddress(),
                    student.getContact(),
                    student.getDob(),
                    student.getGender()
            ));
        }
        return dtoList;
    }
}
