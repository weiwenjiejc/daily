package jsp.demo.bean;

import java.util.Date;

public class SignInfo {

    public Integer id;
    public Integer studentId;
    public String studentName;
    public Integer teacherId;
    public String teacherName;
    public Integer courseId;
    public String courseName;

    public Date signTime;
    public Integer signStatus;

    public Integer anotherStudentId;

    public void setAnotherStudentId(Integer anotherStudentId) {
        this.anotherStudentId = anotherStudentId;
    }

    public Integer getAnotherStudentId() {
        return anotherStudentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Date getSignTime() {
        return signTime;
    }

    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }

    public Integer getSignStatus() {
        return signStatus;
    }

    public void setSignStatus(Integer signStatus) {
        this.signStatus = signStatus;
    }

    @Override
    public String toString() {
        return "SignInfo{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", signTime=" + signTime +
                ", signStatus=" + signStatus +
                ", anotherStudentId=" + anotherStudentId +
                '}';
    }
}
