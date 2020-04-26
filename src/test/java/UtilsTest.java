import com.zyc.DB.JDBCUtils;
import com.zyc.Date.DateUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 * @author zhouyongcai
 * @create_time 2020/4/26 11:11
 * @note：
 */

public class UtilsTest {

    @org.junit.Test
    public void testConn() throws Exception {
        Connection conn = JDBCUtils.getConn();

    }

    @Test
    public void testDate() {
        String backDateStr = DateUtils.getBackDateStr(30, DateUtils.DAY, "yyyy-MM-dd");
        System.out.println(backDateStr);
        String a1 = DateUtils.getBackDateStr(13, DateUtils.MONTH, "yyyy-MM");
        System.out.println(a1);
        String a2 = DateUtils.getBackDateStr(20, DateUtils.YEAR, "yyyy");
        System.out.println(a2);
//        String a3 = DateUtils.getBackDateStr(2, DateUtils.WEEK, "yyyy-MM-dd");
//        System.out.println(a3);
        String a4 = DateUtils.getBackDateStr(2, DateUtils.HOUR, "yyyy-MM-dd-HH");
        System.out.println(a4);
    }

}
