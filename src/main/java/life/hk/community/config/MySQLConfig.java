package life.hk.community.config;

import org.hibernate.dialect.MySQL55Dialect;
import org.hibernate.dialect.MySQL5InnoDBDialect;

/**
 * User: gaoyishu
 * Date: 2020/1/14
 * Time: 00:07
 */
public class MySQLConfig extends MySQL55Dialect {
    @Override
    public String getTableTypeString() {
        return "ENGINE=InnoDB DEFAULT CHARSET=utf8";
    }
}
