package entity;

/**
 * @Auther: mxt
 * @Date: 2019/10/9 16:41
 * @Description:
 */
public class Codes {
    private int codeid;
    private  String codetype;
    private String codetext;

    public Codes() {
    }

    public Codes(int codeid, String codetype, String codetext) {
        this.codeid = codeid;
        this.codetype = codetype;
        this.codetext = codetext;
    }

    public int getCodeid() {
        return codeid;
    }

    public void setCodeid(int codeid) {
        this.codeid = codeid;
    }

    public String getCodetype() {
        return codetype;
    }

    public void setCodetype(String codetype) {
        this.codetype = codetype;
    }

    public String getCodetext() {
        return codetext;
    }

    public void setCodetext(String codetext) {
        this.codetext = codetext;
    }
}
