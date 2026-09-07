/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lap7_Bai8;

/**
 *
 * @author DELL
 */

public class Classroom {
    private String classId;
    private String className;
    private String advisor;
    private int studentCount;

    public Classroom() {}

    public Classroom(String classId, String className, String advisor, int studentCount) {
        this.classId = classId;
        this.className = className;
        this.advisor = advisor;
        this.studentCount = studentCount;
    }

    public String getClassId() { return classId; }
    public void setClassId(String classId) { this.classId = classId; }

    public String getClassName() { return className; }
    public void setClassName(String className) { this.className = className; }

    public String getAdvisor() { return advisor; }
    public void setAdvisor(String advisor) { this.advisor = advisor; }

    public int getStudentCount() { return studentCount; }
    public void setStudentCount(int studentCount) { this.studentCount = studentCount; }
}