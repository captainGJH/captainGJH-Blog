package com.gjh.dao;

import com.gjh.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDao extends JpaRepository<User,Long> {

   User findByUid(Long uid);
   User findByUemailAndUpwd(String uemail,String upwd);
   User findByUemail(String uemail);
}
