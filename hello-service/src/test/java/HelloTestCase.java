import com.dapeng.example.hello.service.HelloService;
import com.github.dapeng.core.SoaException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author with struy.
 * Create by 2018/7/9 00:39
 * email :yq1724555319@gmail.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring/services.xml"})
public class HelloTestCase {

    @Autowired
    HelloService helloService;

    @Test
    public void sayHelloTest() {
        try {
            String result = helloService.sayHello("Dapeng");
            System.out.println("result-->" + result);
            Assert.assertTrue(result.contains("Dapeng"));
        } catch (SoaException e) {
            System.out.println(e.getMsg());
        }
    }
}
