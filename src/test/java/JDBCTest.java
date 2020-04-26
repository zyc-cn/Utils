import com.zyc.collection.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 * @author zhouyongcai
 * @create_time 2020/4/26 11:11
 * @note：
 */

public class JDBCTest {

    @Test
    public void testConn() throws Exception {
        Connection conn = JDBCUtils.getConn();
    }

}
