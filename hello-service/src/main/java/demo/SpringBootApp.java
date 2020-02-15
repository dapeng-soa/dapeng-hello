package demo;
import com.github.dapeng.core.definition.SoaServiceDefinition;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@SpringBootApplication(scanBasePackages = "com.dapeng.example.service")
//@ImportResource("classpath:/META-INF/spring/services.xml")
public class SpringBootApp {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        try {
            ConfigurableApplicationContext ctx = SpringApplication.run(SpringBootApp.class, args);
            System.out.println("ctx = " + ctx);
            Map<String, SoaServiceDefinition> beans = ctx.getBeansOfType(SoaServiceDefinition.class);
            for (String key : beans.keySet()) {
                System.out.println("bean:" + key + ":" + beans.get(key));
            }
        }
        catch (Throwable ex){
            System.out.println("===== load springboot failed");
            ex.printStackTrace();
        }
    }

}