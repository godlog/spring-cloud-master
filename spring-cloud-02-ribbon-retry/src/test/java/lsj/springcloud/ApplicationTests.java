package lsj.springcloud;

import lsj.springcloud.service.IndexService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author TF016519
 * @description:
 * @date 2017/12/9 15:58
 * @version:1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTests {

    @Autowired
    private IndexService indexService;

    @Test
    public void testRetry() throws Exception {
        indexService.call();
    }
}
