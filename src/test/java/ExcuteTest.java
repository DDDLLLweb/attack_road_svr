import com.el.core.jdbc.CustomJdbcConfig;
import com.el.core.jdbc.MybatisConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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

    public static int[] twoSum(int[] nums, int target) {
        int[] result = {};
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] + nums[j] == target) {
                    result = new int[]{i, j};
                    break;
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        int iNum =Integer.MAX_VALUE ;
        int jNum;
        int kNum;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (iNum == nums[i]) {
                continue;
            }
            iNum = nums[i];
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);

                    jNum = nums[j];
                    do {
                        j++;
                        if (j>=k) {
                            break;
                        }
                    } while (jNum == nums[j]);
                    kNum = nums[k];
                    do {
                        k--;
                        if (j>=k) {
                            break;
                        }
                    } while (kNum == nums[k]);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 13;
        int[] ints = twoSum(nums, target);
        System.out.println(ints[0] + " " + ints[1]);
    }
}
