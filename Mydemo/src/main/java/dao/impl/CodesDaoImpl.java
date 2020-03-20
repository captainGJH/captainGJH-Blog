package dao.impl;

import dao.CodesDao;
import entity.Codes;
import util.JDBCUTIL;
import util.JDBCUTIL;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: mxt
 * @Date: 2019/10/9 16:42
 * @Description:
 */
public class CodesDaoImpl implements CodesDao{
    private JDBCUTIL util = new JDBCUTIL();

    public List<Codes> queryByType(String type) {
        List<Codes> list = new ArrayList<>();
        ResultSet rs = util.select("select * from t_codes where codetype=?", type);
        try {
            while (rs.next()) {
                Codes c = new Codes(rs.getInt("codeid"), rs.getString("codetype"), rs.getString("codetext"));
               list.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.closeAll();
        }


        return list;
    }
}
