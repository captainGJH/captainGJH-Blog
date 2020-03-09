package com.gjh.service;

import com.gjh.entity.BlogTag;

import java.util.List;

public interface BlogTagService {

    List<BlogTag> listTag();

    List<BlogTag> listTag(String ids);

}
