package com.gjh.dao;

import com.gjh.entity.Attention;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttentionDao extends JpaRepository<Attention,Long> {
    int countByBesubscribeAndIsdel(Long bsid,String isdel);

    int countByAfansAndIsdel(Long fanid,String isdel);

    List<Attention> findByAfans(Long fid);
    List<Attention> findByBesubscribe(Long bsid);




}
