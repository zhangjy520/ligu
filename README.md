# 1 部署说明：
## 1.1 需要部署的软件
    mysql5.7
    jdk1.7
    tomcat
    nginx
    
## 1.2 软件说明
   ### mysql.cnf
        lower_case_table_names=1
        sql_mode=STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION
        max_allowed_packet = 850M
        tmp_table_size = 256M
        max_heap_table_size = 256M
    
   ### nginx.conf
        server{
        listen 8085;#db.properties里面配置的代理端口
        location / {
                alias /home/ligu/attach/;#这个就是db.properties里配置的文件上传路径
                autoindex on;
            }
        }
        
   ### tomcat/conf/server.xml
     <Connector port="8084" protocol="HTTP/1.1"
                   connectionTimeout="20000"
                   redirectPort="8443" URIEncoding="UTF-8"/>
        
   ###  tomcat/bin/catalina.bat   
     set "JAVA_OPTS=%JAVA_OPTS% %LOGGING_MANAGER% -Dfile.encoding="UTF-8""
     
     
  如果开发工具idea出现了乱码，解决办法如下：
  ##第一步:修改intellij idea配置文件：
  
  找到intellij idea安装目录，bin文件夹下面idea64.exe.vmoptions和idea.exe.vmoptions这两个文件，分别在这两个文件中添加：-Dfile.encoding=UTF-8
  
  ##第二步：找到intellij idea的file---settings---Editor---FileEncodings的GlobalEncoding和ProjectEncoding和Default encoding for properties都配置成UTF-8
  
  ##第三步：在部署Tomcat的VM options项中添加：-Dfile.encoding=UTF-8
  
  ##第四步：重启Intellij idea即可解决乱码问题
  
  
  # mysql默认值修改
    sys_user 的photo_url的值需要修改：http://47.94.98.20:8085/source/attach/headPic/head_defalut.png  （前面的ip+端口动态替换成服务器nginx的部署地址）
    
    
    
    
    
    
   二期需求：
   doc_source 表新增了字段为工艺示例在线文档
   feedback 反馈建议表
   person_salary 人员工资发放情况表
   notice_message 人员app消息通知表
   
   
   
   
   
   保险日期格式一定要是：
   2019年3月8-2020年3月7日
   薪资日期格式一定要是
   2012-01
   
   薪资录入：发放薪资日期为有效日期截止日