package lk.ijse.RoyalInstitute.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Course implements SuperEntity{
    @Id
    private String proId;
    private String pro;
    private String duration;
    private String fee;
    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    private List<Register>register;

    public Course(List<Register> registrations) {
        this.register = registrations;
    }

    public Course(String code) {
        this.proId = code;
    }

    public Course(String proId, String pro, String duration, String fee) {
        this.proId = proId;
        this.pro = pro;
        this.duration = duration;
        this.fee = fee;
    }

    public Course() {
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public String getPro() {
        return pro;
    }

    public void setPro(String pro) {
        this.pro = pro;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Course{" +
                "proId='" + proId + '\'' +
                ", pro='" + pro + '\'' +
                ", duration='" + duration + '\'' +
                ", fee='" + fee + '\'' +
                '}';
    }
}
