/**
 * 
 */
package vip.xjdai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vip.xjdai.service.DataSourceService;

/**
 * @author lwb
 *
 */
@RestController
@RequestMapping("dataSource")
public class DataSourceController {

    @Autowired
    private DataSourceService dataSourceService;

    @RequestMapping("selectAll")
    public String selectAll() {
        dataSourceService.selectAll();
        return null;
    }

    @RequestMapping("getOne")
    public String getOne() {
        dataSourceService.getOne();
        return null;
    }

    @RequestMapping("insert")
    public String insert() {
        dataSourceService.selectAll();
        return null;
    }

    @RequestMapping("add")
    public String add() {
        dataSourceService.selectAll();
        return null;
    }

    @RequestMapping("update")
    public String update() {
        dataSourceService.selectAll();
        return null;
    }

    @RequestMapping("edit")
    public String edit() {
        dataSourceService.edit();
        return null;
    }

    @RequestMapping("delete")
    public String delete() {
        dataSourceService.delete();
        return null;
    }

    @RequestMapping("remove")
    public String remove() {
        dataSourceService.remove();
        return null;
    }

    @RequestMapping("getToken")
    public String getToken() {
        dataSourceService.getToken();
        return null;
    }

}
