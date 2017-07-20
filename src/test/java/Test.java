import com.flyou.bean.SSBean;
import com.flyou.model.SSAccountModel;
import com.flyou.model.SSAccountModelImpl;

import java.util.List;

/**
 * Author       : flyou
 * Date         : 2017/7/20 0020.
 * FileName     : Test
 * ProjectName  : SpringApi
 * Description  :
 * Version      : V1.0
 */
public class Test {
    @org.junit.Test
    public void Test(){

        SSAccountModel ssAccountModel=new SSAccountModelImpl();
        List<SSBean> ssAccount = ssAccountModel.getSSAccount();
        System.out.print(ssAccount.toString());
    }

}
