package com.mo.tools;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

/**
 * Created by IntelliJ IDEA.
 * User: PeiHsien Mo
 * Date: 2019/11/18
 * Time: 11:00
 */

public class Jump {
    private String hyperlink = null;
    public static String success(Model model,String msg,String hyperlink) {

        model.addAttribute("msg",msg);
        model.addAttribute("hyperlink",hyperlink);

        return "success";
    }
    public static String success(Model model,String msg){

        model.addAttribute("msg",msg);
        model.addAttribute("hyperlink",null);

        return "success";
    }
    public static String error(Model model,String msg,String hyperlink) {
        model.addAttribute("msg",msg);
        model.addAttribute("hyperlink",hyperlink);

        return "error";
    }
}
