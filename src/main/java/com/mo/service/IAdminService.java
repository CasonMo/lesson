package com.mo.service;

import com.mo.domain.Admin;
import com.mo.domain.Student;


import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: PeiHsien Mo
 * Date: 2019/11/6
 * Time: 19:41
 */
public interface IAdminService {

    public void updateAdmin(Admin admin);

    public Admin find(String id,String password);

    public Admin findById(String id);
    public String  deleteUser(String id);

}
