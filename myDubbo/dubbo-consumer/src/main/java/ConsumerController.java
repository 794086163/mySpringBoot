import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by v-yangxu on 2019/6/6.
 */
@RestController
public class ConsumerController {

    @Reference(version = "${meizu.service.version}")
    private MeizuService meizuService;

    public String sayHello(String name){
        return meizuService.welecom(name);
    }
}
