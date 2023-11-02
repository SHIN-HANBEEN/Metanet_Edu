
/*
    VO, DTO, DOMAIN 은 모두 정보를 담는 객체라는 뜻이다.
    사원 1명의 데이터를 담을 수 있는 객체(클래스) 라는 뜻이다.

    아래 처럼, 생성자, Getter, Setter, toString( ) 을 완성하면 VO, DTO, DOMAIN 이라고 합니다.
 */
public class Emp {
    private int empno;
    private String name;
    private String job;
    private int sal;

    public Emp() {}
    public Emp(int empno, String name, String job, int sal) {
        super();
        this.empno = empno;
        this.name = name;
        this.job = job;
        this.sal = sal;
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empno=" + empno +
                ", name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", sal=" + sal +
                '}';
    }
}
