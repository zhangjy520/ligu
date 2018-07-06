# 1 部署说明：
## 1.1 需要部署的软件
    mysql5.7
    jdk1.8
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
