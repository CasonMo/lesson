package com.mo.service.impl;


import com.mo.dao.IAdminDao;
import com.mo.domain.Admin;
import com.mo.domain.Student;
import com.mo.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: PeiHsien Mo
 * Date: 2019/11/6
 * Time: 19:42
 */
@Service("adminService")
public class AdminServiceImpl implements IAdminService {
    @Autowired
    private IAdminDao adminDao;

    @Override
    public void updateAdmin(Admin admin) {
        adminDao.updateAdmin(admin);
    }

    @Override
    public Admin find(String id,String password) {
        Admin admin = adminDao.find(id, password);
        return admin;
    }

    @Override
    public Admin findById(String id) {
        Admin admin = adminDao.findById(id);
        return admin;
    }

    @Override
    public String deleteUser(String id) {
        String s = adminDao.deleteUser(id);
        return s;
    }


}
