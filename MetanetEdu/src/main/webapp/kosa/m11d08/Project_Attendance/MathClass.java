package kr.or.kosa.m11d08.Project_Attendance;

import java.util.ArrayList;
import java.util.Date;

public class MathClass implements CollegeClass{
    private Date starttime;
    private Date endtime;
    private int numofclass;
    private boolean isopen;
    private ArrayList<Student> studentslist;

    MathClass(Date starttime, Date endtime, int numofclass) {
        this.starttime = starttime;
        this.endtime = endtime;
        this.numofclass = numofclass;
        this.isopen = false;
        this.studentslist = null;
    }
    @Override
    public void open() {
        this.isopen = true;
    }

    @Override
    public void close() {
        this.isopen = false;
    }


}
