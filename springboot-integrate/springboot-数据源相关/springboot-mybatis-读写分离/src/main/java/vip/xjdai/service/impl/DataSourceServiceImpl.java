/**
 * 
 */
package vip.xjdai.service.impl;

import org.springframework.stereotype.Service;

import vip.xjdai.config.Master;
import vip.xjdai.service.DataSourceService;

/**
 * @author lwb
 *
 */
@Service
public class DataSourceServiceImpl implements DataSourceService {

    @Override
    public String selectAll() {
        return null;
    }

    @Override
    public String getOne() {
        System.out.println("get");
        return null;
    }

    @Override
    public String insert() {

        return null;
    }

    @Override
    public String add() {

        return null;
    }

    @Override
    public String update() {

        return null;
    }

    @Override
    public String edit() {
        return null;
    }

    @Override
    public String delete() {

        return null;
    }

    @Override
    public String remove() {
        return null;
    }

    @Master
    @Override
    public String getToken() {
        return null;
    }

}
