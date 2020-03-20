package com.gjh.dao;

import com.gjh.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsDao extends JpaRepository<News,Integer>
{
    public List<News> findByOx(int type);

}
