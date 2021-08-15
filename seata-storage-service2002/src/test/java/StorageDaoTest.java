import edu.hue.springcloud.dao.StorageDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 47552
 * @date 2021/08/15
 */
public class StorageDaoTest {

    @Autowired
    private StorageDao storageDao;

    @Test
    public void test() {
        storageDao.updateStorage(1L,1);
    }

}
