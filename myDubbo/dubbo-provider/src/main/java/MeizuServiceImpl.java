import org.apache.dubbo.config.annotation.Service;

/**
 * Created by v-yangxu on 2019/6/6.
 */
@Service(version = "${meizu.service.version}")
public class MeizuServiceImpl implements MeizuService {

    @Override
    public String welecom(String name) {
        return "Hello "+name;
    }
}
