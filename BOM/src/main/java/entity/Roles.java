package entity;

/**
 * @Auther: mxt
 * @Date: 2019/10/9 15:46
 * @Description:
 */
public class Roles {
    private int roleid;
    private String rolename;
    private  String power;

    public Roles() {
    }

    public Roles(int roleid, String rolename, String power) {
        this.roleid = roleid;
        this.rolename = rolename;
        this.power = power;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }
}
