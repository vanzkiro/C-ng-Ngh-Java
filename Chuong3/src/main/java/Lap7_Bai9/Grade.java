/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lap7_Bai9;

/**
 *
 * @author DELL
 */
public class Grade {
    private String studentId;
    private String studentName;
    private double attendanceScore; // Chuyên cần (10%)
    private double midtermScore;    // Giữa kỳ (30%)
    private double finalScore;      // Cuối kỳ (60%)

    public Grade() {}

    public Grade(String studentId, String studentName, double attendanceScore, double midtermScore, double finalScore) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.attendanceScore = attendanceScore;
        this.midtermScore = midtermScore;
        this.finalScore = finalScore;
    }

    // Tính điểm tổng kết
    public double getTotalScore() {
        double total = (attendanceScore * 0.1) + (midtermScore * 0.3) + (finalScore * 0.6);
        return Math.round(total * 10.0) / 10.0;
    }

    // Quy đổi xếp loại A / B / C / D / F
    public String getRank() {
        double total = getTotalScore();
        if (total >= 8.5) return "A";
        if (total >= 7.0) return "B";
        if (total >= 5.5) return "C";
        if (total >= 4.0) return "D";
        return "F";
    }

    // Getters & Setters
    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public double getAttendanceScore() { return attendanceScore; }
    public void setAttendanceScore(double attendanceScore) { this.attendanceScore = attendanceScore; }

    public double getMidtermScore() { return midtermScore; }
    public void setMidtermScore(double midtermScore) { this.midtermScore = midtermScore; }

    public double getFinalScore() { return finalScore; }
    public void setFinalScore(double finalScore) { this.finalScore = finalScore; }
}
