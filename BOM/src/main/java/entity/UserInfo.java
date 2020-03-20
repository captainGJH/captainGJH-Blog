package entity;

/**
 * @Auther: mxt
 * @Date: 2019/10/9 14:16
 * @Description:
 */
public class UserInfo {
    private int u_id;
    private String u_name;
    private  String u_pwd;
    private int roleid;
    private int dutyid;
    private int deptid;
    private String joindate;
    private int enduid;//学历

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_pwd() {
        return u_pwd;
    }

    public void setU_pwd(String u_pwd) {
        this.u_pwd = u_pwd;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public int getDutyid() {
        return dutyid;
    }

    public void setDutyid(int dutyid) {
        this.dutyid = dutyid;
    }

    public int getDeptid() {
        return deptid;
    }

    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }

    public String getJoindate() {
        return joindate;
    }

    public void setJoindate(String joindate) {
        this.joindate = joindate;
    }

    public int getEnduid() {
        return enduid;
    }

    public void setEnduid(int enduid) {
        this.enduid = enduid;
    }
}
