package com.anki.files.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.anki.files.pojo.Admin;
import com.anki.files.pojo.Qa;
import com.anki.files.pojo.Users;

@Repository
public interface AdminMapper {
      Admin	login(@Param("email")String email);
      
      ArrayList<Users>showAllUsers();
      
      ArrayList<Qa>inbox();
      
      int feedBack(@Param("admin_id")int admin_id,@Param("answers")String answer,@Param("id")int id);
}
