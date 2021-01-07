package cc.ligu.mvc.service.impl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import cc.ligu.common.service.BasicService;
import cc.ligu.mvc.persistence.dao.MoneyMapper;
import cc.ligu.mvc.persistence.entity.Money;
import cc.ligu.mvc.service.MoneyService;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;

/**
 * Created by zjy on 2018/5/21.
 */
@Service
public class MoneyServiceImpl extends BasicService implements MoneyService {

    @Autowired
    MoneyMapper moneyMapper;

    public static void main(String[] args) {
        String base = "https://www.tvmao.com/drama/XWNfZG4i/episode/";
        for (int i = 1; i <= 30; i++) {
            base+= (i-1)/3+"-"+i;
            System.out.println(base+"：第"+i+"集\r\n"+getText(parseUrl(base)));
            base = "https://www.tvmao.com/drama/XWNfZG4i/episode/";
        }
    }
    public static String getText(Document document){
        Elements contents = document.getElementsByTag("article").get(0).getElementsByTag("p");
        StringBuffer sb = new StringBuffer();
        contents.forEach(f->{
            sb.append(f.text()+"\r\n");
        });
        return sb.toString();
    }
    public static Document parseUrl(String url){
        //http请求
        HttpRequest request = HttpUtil.createGet(url);
        String str = request.execute().body();
        //Jsoup解析html
        return Jsoup.parse(str);
    }

    public static Document parseHtml(String searchKey) throws UnsupportedEncodingException {
        String baseUrl = "https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&tn=baidu" + "&wd=" + URLEncoder
            .encode(searchKey, "utf-8")
            + "&oq=%25E9%2593%25B6%25E6%25B2%25B3&rsv_pq=d7741fd70001281a&rsv_t=c086c5G3KF8XoYNjWaoGfScD00IOU%2FT3EgmCVcKLppG6oAAFRwS3ON2qmOs"
            + "&rqlang=cn&rsv_dl=tb&rsv_enter=1&rsv_sug3=1&rsv_sug2=0&rsv_btype=t&inputT=4&rsv_sug4=694";
        //http请求
        HttpRequest request = HttpUtil.createGet(baseUrl);

        String str = request.execute().body();
        //Jsoup解析html
        return Jsoup.parse(str);
    }

    public static String getCurrentFee(Document document) {
        Element res = document.getElementById("content_left");
        Element firstResult = res.getElementById("1");
        if (firstResult != null) {
            Elements shishi = firstResult.getElementsByClass("op-stockdynamic-cur-info c-gap-right-small");
            if (shishi != null && CollectionUtil.isNotEmpty(shishi)) {
                return shishi.text().replace("(", "").replace(")", "").replace("%", "");
            }
        }
        return "0";
    }

    @Override
    public Map calcDetail(List<String> nameList, List<String> muchList) {
        Map res = new TreeMap();
        double total = 0;
        for (int i = 0; i < nameList.size(); i++) {
            String fuDu = queryMoneyDetail(nameList.get(i));
            double thisShod = Double.parseDouble(fuDu) * Double.parseDouble(muchList.get(i)) / 100;
            total += thisShod;
            res.put(nameList.get(i), "今日幅度:" + fuDu + "；今日收益：" + thisShod);
        }
        res.put("今日总收益", total);
        return res;
    }

    @Override
    public String queryMoneyDetail(String name) {
        String curr = "0";
        try {
            Money res = moneyMapper.selectByPrimaryKey(name);
            if (res == null) {
                String fee = getCurrentFee(parseHtml(name));
                Money latest = new Money();
                latest.setMoneyDate(new Date());
                latest.setMoneyName(name);
                latest.setTodayDetail(fee);
                moneyMapper.insertSelective(latest);
                curr = fee;
            } else {
                if (new Date().getTime() - res.getMoneyDate().getTime() > 5 * 60 * 1000) {
                    // 大于5分钟，再爬
                    String fee = null;
                    try {
                        fee = getCurrentFee(parseHtml(name));
                        res.setTodayDetail(fee);
                        res.setMoneyDate(new Date());
                        moneyMapper.updateByPrimaryKeySelective(res);
                        curr = fee;
                    } catch (Exception e) {
                    }
                }
                curr = res.getTodayDetail();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return curr;
    }
}
