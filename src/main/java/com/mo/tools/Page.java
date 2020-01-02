package com.mo.tools;

import org.springframework.ui.Model;

/**
 * Created by IntelliJ IDEA.
 * User: PeiHsien Mo
 * Date: 2019/11/22
 * Time: 20:01
 */
public class Page {
    private Integer currentPage=1;    //当前页数
    private Integer totalPages;       //总页数
    private Integer total;            //记录总行数
    private Integer pageSize=5;    //每页记录行数
    private Integer nextPage;        //下一页
    private Integer prefPage;       //前一页
    private String link;       //跳转的链接

    public Page(Model model, Integer currentPage, Integer total, Integer pageSize, String link) {

        if(currentPage==null){
            this.currentPage = 1;
        }else {
            this.currentPage = currentPage;
        }
        this.total = total;
        this.pageSize = pageSize;
        this.link = link;
        model.addAttribute("page",toString());
    }
    public Page() {

    }
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getNextPage() {
                if (currentPage < getTotalPages()) {
            nextPage = currentPage + 1;

        } else {
            nextPage = currentPage;

        }

        return nextPage;
    }

    public Integer getPrefPage() {
                if (currentPage > 1) {
            prefPage = currentPage - 1;

        } else {
            prefPage = currentPage;

        }

        return prefPage;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {

        if(currentPage==null){
            this.currentPage = 1;
        }else {
            this.currentPage = currentPage;
        }


    }

    public Integer getTotalPages() {

        totalPages = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;

        return totalPages;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

//    public Integer getNextPage() {
//        if (currentPage < totalPages) {
//            nextPage = currentPage + 1;

//        } else {
//            nextPage = currentPage;

//        }
//    }
//
//    public Integer getPrefPage() {
//        if (currentPage > 1) {
//            prefPage = currentPage - 1;
//            return prefPage;
//        } else {
//            prefPage = currentPage;
//            return prefPage;
//        }
//    }

    @Override
    public String toString() {
        return " <div class=\"row justify-content-md-center\">\n" +
                "        <div class=\"col-12\" style=\"text-align: center\">\n" +
                "            <div class=\"btn-group\" role=\"group\" aria-label=\"Basic example\">\n" +
                "                <form method=\"GET\" action=\""+getLink()+"\">\n" +
                "                    <input type=\"hidden\" name=\"page\" value=\"1\">\n" +
                "                    <input type=\"submit\" class=\"btn btn-light\" value=\"首页\">\n" +
                "                </form>\n" +
                "                <form method=\"GET\" action=\""+getLink()+"\">\n" +
                "                    <input type=\"hidden\" name=\"page\" value=\""+getPrefPage()+"\">\n" +
                "                    <input type=\"submit\" value=\"上一页\" class=\"btn btn-light\">\n" +
                "                </form>\n" +
                "                <form method=\"GET\" action=\""+getLink()+"\">\n" +
                "                    <input style=\"width: 40px;\" type=\"text\" class=\"form-control\" name=\"page\" value=\""+currentPage+"\"/>\n" +
                "                </form>\n" +
                "\n" +
                "                <span></span>\n" +
                "                <form method=\"GET\" action=\""+getLink()+"\">\n" +
                "\n" +
                "                    <input type=\"hidden\" name=\"page\" value=\""+getNextPage()+"\">\n" +
                "                    <input type=\"submit\" value=\"下一页\" class=\"btn btn-light\">\n" +
                "                </form>\n" +
                "                <form method=\"GET\" action=\""+getLink()+"\">\n" +
                "                    <input type=\"hidden\" name=\"page\" value=\""+getTotalPages()+"\">\n" +
                "                    <input type=\"submit\" value=\"尾页\" class=\"btn btn-light\">\n" +
                "                </form>\n" +
                "                <form>\n" +
                "                    <input type=\"submit\" value=\"共："+getTotalPages()+"页\" class=\"btn btn-light\" disabled>\n" +
                "                </form>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>";
    }
}
