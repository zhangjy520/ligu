package cc.ligu.mvc.service;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

public interface MoneyService {
    Map calcDetail(List<String> nameList,List<String> muchList);

    String queryMoneyDetail(String name) throws UnsupportedEncodingException;
}
