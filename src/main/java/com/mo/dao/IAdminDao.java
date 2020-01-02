package com.mo.dao;


import com.mo.domain.Admin;
import com.mo.domain.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: PeiHsien Mo
 * Date: 2019/11/6
 * Time: 19:38
 */

public interface IAdminDao {

    public void updateAdmin(Admin admin);

    public Admin find(@Param(value = "id") String id, @Param(value = "password")String password);

    public Admin findById(@Param(value = "id") String id);

    public String deleteUser(@Param(value = "id") String id);

}
