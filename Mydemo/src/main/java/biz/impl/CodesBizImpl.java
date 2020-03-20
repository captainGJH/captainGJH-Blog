package biz.impl;

import biz.CodesBiz;


import dao.CodesDao;
import dao.impl.CodesDaoImpl;
import entity.Codes;

import java.util.List;

public class CodesBizImpl implements CodesBiz{

    private CodesDao dao=new CodesDaoImpl();
    @Override
    public List<Codes> queryByType(String type) {

        return dao.queryByType(type);
    }
}
