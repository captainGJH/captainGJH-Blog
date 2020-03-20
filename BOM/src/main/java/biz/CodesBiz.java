package biz;

import entity.Codes;

import java.util.List;

public interface CodesBiz {
    public List<Codes> queryByType(String type);
}
