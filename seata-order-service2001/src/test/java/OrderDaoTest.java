import edu.hue.springcloud.dao.OrderDao;
import edu.hue.springcloud.domian.Order;
import edu.hue.springcloud.service.OrderService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 47552
 * @date 2021/08/15
 */
public class OrderDaoTest {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderService orderService;

    @Test
    public void test() {
        orderDao.updateOrder(7L,0);
    }

}
