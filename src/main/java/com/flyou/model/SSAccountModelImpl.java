package com.flyou.model;

import com.flyou.bean.SSBean;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author       : flyou
 * Date         : 2017/7/19 0019.
 * FileName     : SSAccountModelImpl
 * ProjectName  : SpringApi
 * Description  :
 * Version      : V1.0
 */
public class SSAccountModelImpl implements SSAccountModel {
    private List<SSBean> ssBeanList = new ArrayList<>();

    @Override
    public List<SSBean> getSSAccount() {

        Document document = null;
        try {
            document = Jsoup.connect("http://ss.ishadowx.com/").get();

            Element firstElement = document.getElementsByClass("portfolio-items").first();
            Elements ssElements = firstElement.getElementsByClass("hover-text");
            for (Element element : ssElements) {
                SSBean ssBean = new SSBean();
                String address = element.getElementsByTag("h4").first().getElementsByTag("span").text();
                String password = element.getElementsByTag("h4").get(2).getElementsByTag("span").first().text();
                String portString = element.getElementsByTag("h4").get(1).text();
                String port = portString.split("：")[1];
                String methodString = element.getElementsByTag("h4").get(3).text();
                String method = methodString.split(":")[1];
                ssBean.setAddress(address);
                ssBean.setPort(port);
                ssBean.setPassword(password);
                ssBean.setMethod(method);
                if (ssBean.getPassword() == null || ssBean.getPassword().isEmpty()) {
                    continue;
                }
                ssBeanList.add(ssBean);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ssBeanList;
    }
}
