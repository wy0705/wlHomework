package info;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


//用于将mysql的配置文件管理在spring的容器中，从而在程序中优雅的使用。
@Component
@PropertySource("classpath:mysql.properties")
public class JdbcInfo {

    @Value("${URL}")
    private String url;

    @Value("${DRIVER}")
    private String driver;

    @Value("${USERNAME}")
    private String username;

    @Value("${PASSWORD}")
    private String password;




//    @Value("${mybatis.type.alias.package}")
//    private String typeAliasesPackage;
//
//    public String getTypeAliasesPackage() {
//        return typeAliasesPackage;
//    }
//
//    public void setTypeAliasesPackage(String typeAliasesPackage) {
//        this.typeAliasesPackage = typeAliasesPackage;
//    }


//    @Value("${mariaDB.validationQuery}")
//    private String validationQuery;
//
//    public String getValidationQuery() {
//        return validationQuery;
//    }



    public String getUrl() {
        return url;
    }

    public String getDriver() {
        return driver;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
