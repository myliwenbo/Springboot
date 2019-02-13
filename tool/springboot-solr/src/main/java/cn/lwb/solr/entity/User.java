package cn.lwb.solr.entity;

import org.apache.solr.client.solrj.beans.Field;

public class User {
    @Field
    private String name;
    @Field
    private String id;
    @Field
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
