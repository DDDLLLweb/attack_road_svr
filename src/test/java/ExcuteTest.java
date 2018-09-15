import com.el.core.jdbc.CustomJdbcConfig;
import com.el.core.jdbc.MybatisConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author neo.pan
 * @since 2018/3/22
 */
@ActiveProfiles({"dev", "test"})
@RunWith(SpringRunner.class)
@ContextConfiguration(
    initializers = {ConfigFileApplicationContextInitializer.class},
    classes = {CustomJdbcConfig.class, MybatisConfig.class}
)
@Transactional
public class ExcuteTest {

    @Test
    public void none() {
        // do nothing but for `gradle test`
    }

}
