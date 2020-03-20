package com.gjh.service;

import com.gjh.entity.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NewsBiz {
    News getnews(int id);
    Page<News> listNews(Pageable pageable,News news);

}
