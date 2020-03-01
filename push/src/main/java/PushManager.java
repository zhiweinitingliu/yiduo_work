/**
 * @Description :
 * @Author : wdk
 * @CretaTime : 2020/3/1 16:23
 * @LastModify(最终修改人) :wdk
 * @LastModifyTime(最终修改时间) : 2020/3/1 16:23
 * @LastCheckBy :wdk
 */
public class PushManager {
    private static final PushManager ourInstance = new PushManager();

    public static PushManager getInstance() {
        return ourInstance;
    }

    private PushManager() {
    }


}
