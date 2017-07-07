package kimweng.cuscapi.com.greendao;

import android.app.Application;



/**
 * Created by admin on 2017/7/6.
 */

public class APP extends Application {
    private  static  APP mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        if (mInstance==null){
            mInstance=this;
        }
    }
    private void initDB(){
    }
}
