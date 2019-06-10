import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by v-yangxu on 2019/6/6.
 */
@SpringBootApplication
@EnableDubbo
public class DubboProviderApplication {
    public static void main(String[] args){
        SpringApplication.run(DubboProviderApplication.class,args);
    }
}
