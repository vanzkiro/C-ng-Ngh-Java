package Lap6_Bai7;

public class Student1 {
    private int stt;
    private String maSV;
    private String name;
    private String queQuan;

    public Student1(int stt, String maSV, String name, String queQuan) {
        this.stt = stt;
        this.maSV = maSV;
        this.name = name;
        this.queQuan = queQuan;
    }

    public int getStt() { return stt; }
    public String getMaSV() { return maSV; }
    public String getName() { return name; }
    public String getQueQuan() { return queQuan; }
}