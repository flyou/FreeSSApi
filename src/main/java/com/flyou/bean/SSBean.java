package com.flyou.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Author       : flyou
 * Date         : 2017/7/19 0019.
 * FileName     : SSBean
 * ProjectName  : SpringApi
 * Description  :
 * Version      : V1.0
 */
@Entity(name = "ssBean")
public class SSBean {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String address;
    private String port;
    private String password;
    private String method;
    private String image;

    public SSBean() {
    }

    public SSBean(String address, String port, String password, String method, String image) {
        this.address = address;
        this.port = port;
        this.password = password;
        this.method = method;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "SSBean{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", port='" + port + '\'' +
                ", password='" + password + '\'' +
                ", method='" + method + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
