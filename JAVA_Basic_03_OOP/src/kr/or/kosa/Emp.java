package kr.or.kosa;

public class Emp {
    private int empno;
    private String ename;
    //public Emp(){}
    public Emp(int empno, String ename) {
        super();
        this.empno = empno;
        this.ename = ename;
    }
    public int getEmpno() {
        return empno;
    }
    public void setEmpno(int empno) {
        this.empno = empno;
    }
    public String getEname() {
        return ename;
    }
    public void setEname(String ename) {
        this.ename = ename;
    }

    public void empInfoPrint() {
        System.out.println(this.empno +  "-" + this.ename);
    }

    public static void main(String[] args) {
        Emp[] emparr = {new Emp(1, "김"), new Emp(2, "이"),
                new Emp(3, "가")};

        for (Emp e : emparr) {
            e.empInfoPrint();
        }
    }
}