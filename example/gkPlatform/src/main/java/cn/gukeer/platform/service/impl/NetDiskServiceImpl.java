package cn.gukeer.platform.service.impl;

import cn.gukeer.common.utils.PropertiesUtil;
import cn.gukeer.platform.persistence.dao.A_NetDiskShareLinkMapper;
import cn.gukeer.platform.persistence.dao.NetDiskShareLinkMapper;
import cn.gukeer.platform.persistence.dao.TeacherMapper;
import cn.gukeer.platform.persistence.entity.NetDiskShareLink;
import cn.gukeer.platform.persistence.entity.NetDiskShareLinkExample;
import cn.gukeer.platform.persistence.entity.Teacher;
import cn.gukeer.platform.persistence.entity.TeacherExample;
import cn.gukeer.platform.service.NetDiskService;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by LL on 2017/12/13.
 */
@Service
public class NetDiskServiceImpl implements NetDiskService {
    Properties properties = PropertiesUtil.getProperties("api.properties");
    String seafileDownload = (String) properties.get("seafileDownload");
    String seaFileServer = (String) properties.get("seaFileServer");

    @Autowired
    NetDiskShareLinkMapper netDiskShareLinkMapper;

    @Autowired
    A_NetDiskShareLinkMapper a_netDiskShareLinkMapper;

    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public void batchInsertNetDiskShareLinks(List<NetDiskShareLink> netDiskShareLinks) {
        a_netDiskShareLinkMapper.batchInsertNetDiskShareLinks(netDiskShareLinks);
    }

    @Override
    public Map<String, String> findAllSharedBySchoolId(String schoolId) {
        //先根据teacherId查询所有的数据
        NetDiskShareLinkExample example = new NetDiskShareLinkExample();
        example.createCriteria().andSchoolIdEqualTo(schoolId);


        Map<String, String> dbMap = new HashedMap();
        List<NetDiskShareLink> netDiskShareLinksFromDB = netDiskShareLinkMapper.selectByExample(example);
        if (null != netDiskShareLinksFromDB && netDiskShareLinksFromDB.size() > 0) {
            for (NetDiskShareLink netDiskShareLink : netDiskShareLinksFromDB) {
                dbMap.put(netDiskShareLink.getEmail() + netDiskShareLink.getTeacherId() + netDiskShareLink.getShareType() + netDiskShareLink.getLink(), netDiskShareLink.getLink());
            }
        }
        return dbMap;
    }

    @Override
    public List<NetDiskShareLink> findNetDiskShareLinkByShareTypeAndTeacherId(String refId, Integer type) {
        NetDiskShareLinkExample example = new NetDiskShareLinkExample();
        example.createCriteria().andTeacherIdEqualTo(refId).andShareTypeEqualTo(type);
        List<NetDiskShareLink> netDiskShareLinks = netDiskShareLinkMapper.selectByExample(example);
        try {
            if (null != netDiskShareLinks && netDiskShareLinks.size() > 0) {
                for (NetDiskShareLink netDiskShareLink : netDiskShareLinks) {
                    Boolean isDir = netDiskShareLink.getIsDir();
                    String link = netDiskShareLink.getLink();
                    String token =netDiskShareLink.getToken();
                    if (isDir) {

                    }else {
                        link +="?dl=1";
                        System.out.println(link);
                    }
                    netDiskShareLink.setLink(link);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return netDiskShareLinks;
    }

    @Override
    public int batchDelShareFiles(String[] arrIds, String operation, String teacherId) {
        NetDiskShareLinkExample example = new NetDiskShareLinkExample();
        List<String> list = new ArrayList<>();
        if (arrIds.length > 0) {
            list = Arrays.asList(arrIds);
        }
        example.createCriteria().andIdIn(list);
        String link = "";
        String email = "";
        int succ = 0;
        /*
        *   ids+++         74b88eb29f41e1872eb432fe7e1daf98
            teacherId===   0042c7da431c9e321247d96c74665d9e
            operation++++++service   cancel
            succcc::::::0
        * */
        System.out.println("operation++++++service" + operation);
        if (operation.equals("delete")) {
            succ = netDiskShareLinkMapper.deleteByExample(example);
            System.out.println("operation++++deletesucc++++++service" + succ);
        } else {
            System.out.println("operation++++canselsucc++++++service+++before" + succ);
            example.createCriteria().andIdIn(list);
            List<NetDiskShareLink> netDiskShareLinks = netDiskShareLinkMapper.selectByExample(example);
            if (null != netDiskShareLinks && netDiskShareLinks.size() > 0) {
                System.out.println("operation++++canselsucc++++++service+++before>0  但是删除出错了" + succ);
                for (NetDiskShareLink netDiskShareLink : netDiskShareLinks) {
                    NetDiskShareLinkExample exampleCancel = new NetDiskShareLinkExample();
                    link = netDiskShareLink.getLink();
                    email = netDiskShareLink.getEmail();
                    exampleCancel.createCriteria().andLinkEqualTo(link).andEmailEqualTo(email);
                    succ = netDiskShareLinkMapper.deleteByExample(exampleCancel);
                    System.out.println("operation++++canselsucc++++++service" + succ);
                    if (succ > 0) {
                        return succ;
                    }
                }
            }
        }
        System.out.println("succcc::::::" + succ);
        return succ;
    }

    @Override
    public List<Teacher> findSharePeopleByEmail(String email, String link, String id) {
        List<Teacher> teacherList = new ArrayList<>();
        List<String> teacherListIds = new ArrayList<>();
        NetDiskShareLinkExample example = new NetDiskShareLinkExample();
        example.createCriteria().andEmailEqualTo(email).andLinkEqualTo(link).andShareTypeEqualTo(1);
        List<NetDiskShareLink> netDiskShareLinks = netDiskShareLinkMapper.selectByExample(example);
        if (null != netDiskShareLinks && netDiskShareLinks.size() > 0) {
            for (NetDiskShareLink netDiskShareLink : netDiskShareLinks) {
                if (id.equals(netDiskShareLink.getTeacherId())) {
                    continue;
                }
                teacherListIds.add(netDiskShareLink.getTeacherId());
            }
        }

        if (teacherListIds.size() > 0) {
            TeacherExample teacherExample = new TeacherExample();
            teacherExample.createCriteria().andIdIn(teacherListIds);
            teacherList = teacherMapper.selectByExample(teacherExample);
        }

        return teacherList;
    }

    @Override
    public List<NetDiskShareLink> findNetDiskShareLinkByIds(String[] arrIds) {
        List<NetDiskShareLink> netDiskShareLinks = null;
        if (arrIds.length>0){
            List<String> list = Arrays.asList(arrIds);
            NetDiskShareLinkExample netDiskShareLinkExample = new NetDiskShareLinkExample();
            netDiskShareLinkExample.createCriteria().andIdIn(list);
            netDiskShareLinks = netDiskShareLinkMapper.selectByExample(netDiskShareLinkExample);
        }
        return netDiskShareLinks;
    }
}
