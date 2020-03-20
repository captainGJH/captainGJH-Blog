package dao;

import entity.Codes;

import java.util.List;

public interface CodesDao {

    public List<Codes> queryByType(String type);
}
