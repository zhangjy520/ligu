package cc.ligu.mvc.common;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.converts.OracleTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.springframework.core.io.ClassPathResource;

/**
 * mybatis-plus代码生成器(用于生成entity)<br>
 */
public class MyBatisPlusGenerator {

    public static Properties getProperties(String path) {
        Properties prop = null;
        InputStream inStream = null;
        try {
            prop = new Properties();
            inStream = new ClassPathResource(path).getInputStream();
            prop.load(inStream);
            inStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop;
    }

    public static void main(String[] args) {
        Properties properties = getProperties("mybatis-plus.properties");
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(properties.getProperty("outputDir"));// 自己的java目录
        gc.setFileOverride(true);// 是否覆盖
        gc.setActiveRecord(true);
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        gc.setAuthor(properties.getProperty("author"));
        gc .setMapperName(properties.getProperty("mapper.name"))
                .setXmlName(properties.getProperty("xml.name"))
                .setServiceName(properties.getProperty("service.name"))
                .setServiceImplName(properties.getProperty("serviceImpl.name"))
                .setControllerName(properties.getProperty("controller.name"));
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert() {
            // 自定义数据库表字段类型转换【可选】
            @Override
            public DbColumnType processTypeConvert(String fieldType) {
                return super.processTypeConvert(fieldType);
            }
        });
        /**数据库配置这块可以自己手写读取配置文件里的配置项，为了省事我直接copy**/
        dsc.setDriverName(properties.getProperty("jdbc.driver"));
        dsc.setUsername(properties.getProperty("jdbc.userName"));
        dsc.setPassword(properties.getProperty("jdbc.password"));
        dsc.setUrl(properties.getProperty("jdbc.url"));
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // strategy.setTablePrefix(new String[]{"_"});// 此处修改为表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel).setInclude(properties.getProperty("tableName").split(","));// 表名生成策略
        mpg.setStrategy(strategy);
        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(null);
        pc.setEntity(properties.getProperty("entity.path"));
        pc.setMapper(properties.getProperty("mapper.path"));
        pc.setXml(properties.getProperty("xml.path"));
        pc.setService(properties.getProperty("service.path"));
        pc.setServiceImpl(properties.getProperty("serviceImpl.path"));
        pc.setController(properties.getProperty("controller.path"));
        mpg.setPackageInfo(pc);

        // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };
        mpg.setCfg(cfg);

        // 执行生成
        mpg.execute();

        // 打印注入设置
        System.err.println(mpg.getCfg().getMap().get("abc"));
    }

}