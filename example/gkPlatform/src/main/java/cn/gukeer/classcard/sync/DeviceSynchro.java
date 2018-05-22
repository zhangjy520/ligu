package cn.gukeer.classcard.sync;

import cn.gukeer.classcard.modelView.ClassCardNotifyView;
import cn.gukeer.classcard.modelView.ClassCardView;
import cn.gukeer.classcard.persistence.dao.A_ClassCardMapper;
import cn.gukeer.classcard.persistence.dao.A_ClassCardNotifyMapper;
import cn.gukeer.classcard.persistence.dao.ClassCardMapper;
import cn.gukeer.classcard.persistence.entity.ClassCard;
import cn.gukeer.common.entity.ResultEntity;
import cn.gukeer.common.tld.GukeerStringUtil;
import cn.gukeer.common.utils.syncdata.LdapUtils;
import cn.gukeer.platform.modelView.DeviceSynchroView;
import cn.gukeer.platform.modelView.DeviceSynchroView;
import cn.gukeer.platform.modelView.TeachTableView;
import cn.gukeer.platform.persistence.dao.*;
import cn.gukeer.platform.service.impl.CacheServiceImpl;
import com.github.pagehelper.StringUtil;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * Created by admin on 2017/8/9.
 */
@Service
public class DeviceSynchro {

    @Autowired
    CacheManager cacheManager;

    @Autowired
    A_TeachTableMapper a_teachTableMapper;
    @Autowired
    A_ClassCardNotifyMapper a_classCardNotifyMapper;
    @Autowired
    ClassCardMapper classCardMapper;

    @Autowired
    A_ClassCardMapper a_classCardMapper;
    private static final Logger logger = LoggerFactory.getLogger( DeviceSynchro.class);

    public static Properties prop = LdapUtils.getProperties("api.properties");
    public static String url = prop.getProperty("manage_url");


    public void execute(){

        List<DeviceSynchroView> deviceSynchroList = new ArrayList<DeviceSynchroView>();

//        ClassCardExample example = new ClassCardExample();
//        example.createCriteria().andDelFlagEqualTo(0);
//        example.or().andIsSynchroEqualTo(1);
//        example.or().andIsSynchroIsNull();
        List<ClassCardView> classCardList = a_classCardMapper.selectClassCardToSync();
        List<ClassCardView> classCardListHadSyno = new ArrayList<ClassCardView>();
        for( ClassCardView classCard : classCardList){
            if(StringUtil.isEmpty(classCard.getLocationName())){
                continue;
            }
            DeviceSynchroView deviceSynchro = new DeviceSynchroView();
            deviceSynchro.setId( classCard.getId());
            deviceSynchro.setMac( classCard.getMacId());
//            deviceSynchro.setSchoolId( classCard.getSchoolId());
//            deviceSynchro.setSchoolName( classCard.getSchoolName());
            deviceSynchro.setSchool(classCard.getSchoolName());
            deviceSynchro.setLocation(classCard.getLocationName());
            deviceSynchro.setType(2);
            deviceSynchro.setTime( System.currentTimeMillis());

            deviceSynchroList.add( deviceSynchro);
            classCardListHadSyno.add( classCard);
        }


        if( deviceSynchroList.size()>0){
            String uriAPI = url;//Post方式没有参数在这里
            String result = "";
            HttpPost httpRequest = new HttpPost(uriAPI);//创建HttpPost对象
            List <NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("data", new Gson().toJson(deviceSynchroList)));

            try {
                httpRequest.setEntity(new UrlEncodedFormEntity( params,HTTP.UTF_8));
                HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
                if(StringUtils.isNotEmpty(httpResponse.getEntity().toString()))
                {
                    HttpEntity httpEntity = httpResponse.getEntity();
                    result = EntityUtils.toString(httpEntity);//取出应答字符串
                    Gson gson = new Gson();

                    ResultEntity entity = gson.fromJson(result, ResultEntity.class);
                    if (!GukeerStringUtil.isNullOrEmpty(entity)){
                        if( entity.getCode() == 0){

                            for( int i = 0; i<classCardListHadSyno.size(); i++){
//                            ClassCardExample classCardExample = new ClassCardExample();
//                            classCardExample.createCriteria().andMacIdEqualTo( classCardListHadSyno.get(i).getId());

                                ClassCard card = new ClassCard();
                                card.setId(classCardListHadSyno.get(i).getId());
                                card.setIsSynchro(0);
//                            classCardMapper.updateByExampleSelective(card, classCardExample);
                                classCardMapper.updateByPrimaryKeySelective(card);
                            }
                        }
                    }

                }
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                result = e.getMessage().toString();
                logger.error(result);
            }
            catch (ClientProtocolException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                result = e.getMessage().toString();
                logger.error(result);
            }
            catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                result = e.getMessage().toString();
                logger.error(result);
            }
        }

    }


    //缓存通知公告
    public void saveNotifyToCache() {
        Map<String, List<ClassCardNotifyView>> notifyCache = new HashMap<>();
        List<ClassCardNotifyView> notifyList = a_classCardNotifyMapper.findAllNotifyViewByClassCardId(null);//查询所有班牌的通知公告

        for (ClassCardNotifyView v : notifyList) {
            String key = v.getClassCardId();
            if (notifyCache.containsKey(key)) {
                notifyCache.get(key).add(v);
            } else {
                List<ClassCardNotifyView> list = new ArrayList<>();
                list.add(v);
                notifyCache.put(key, list);
            }
        }

        CacheServiceImpl cacheInstance = new CacheServiceImpl(cacheManager, "notify-cache-node");
        cacheInstance.addCache("notify-cache", notifyCache);

    }

    //缓存课表
    public void saveTableToCache() {
        //查询所有课表，保存到缓存，key为 currentWeek+classId+cycleId+weekofoneday
        List<TeachTableView> allTables = a_teachTableMapper.findCurrentTeachTable(-1, null, null, -1);

        Map<String, List<TeachTableView>> teachTableCache = new HashMap();
        for (TeachTableView v : allTables) {

            String key = "";
            try {
                key = v.getWeekend() + v.getClassId() + v.getCycleId() + v.getWeekDay();
            }catch (Exception e){
                continue;
            }

            if (teachTableCache.containsKey(key)) {
                //如果课表map里已经存在这个key,则取出list放入
                teachTableCache.get(key).add(v);
            } else {
                //如果课表map里无此key，新建集合放入课表
                List<TeachTableView> list = new ArrayList<>();
                list.add(v);
                if(v.getClassId().equals("04cf25e799d1b0f62488798398da8ddd")){
                    System.out.println("weekend :"+v.getWeekend() +" classId :"+ v.getClassId() +" cycleId: " +v.getCycleId() +" weekday: " +v.getWeekDay());
                }
                teachTableCache.put(key, list);
            }
        }

        CacheServiceImpl cacheInstance = new CacheServiceImpl(cacheManager, "table-cache-node");
        //将课表存入到缓存
        cacheInstance.addCache("teach_table", teachTableCache);
    }

}
