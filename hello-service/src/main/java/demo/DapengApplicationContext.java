package demo;

import com.github.dapeng.core.ApplicationContext;
import com.github.dapeng.core.definition.SoaServiceDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class DapengApplicationContext implements ApplicationContext {
    @Override
    public void start() {
        System.out.println("Start app");
    }

    @Override
    public Map<String, SoaServiceDefinition> getServiceDefinitions() {
        Class<?> me = SpringBootApp.class;
        try {
            ConfigurableApplicationContext ctx = SpringApplication.run(SpringBootApp.class, new String[]{});
            Map<String, SoaServiceDefinition> defs = ctx.getBeansOfType(SoaServiceDefinition.class);
            return defs;
        }
        catch(Throwable ex){
            ex.printStackTrace();
            System.out.println("====failed");
            throw ex;
        }
    }

    @Override
    public void stop() {
        System.out.println("Stop app");
    }
}
