package lk.ijse.RoyalInstitute.model;

public class CourseTM {
    private String proId;
    private String pro;
    private String duration;
    private String fee;

    public CourseTM(String proId, String pro, String duration, String fee) {
        this.proId = proId;
        this.pro = pro;
        this.duration = duration;
        this.fee = fee;
    }

    public CourseTM() {
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
