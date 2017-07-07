package kimweng.cuscapi.com.greendao;

import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import kimweng.cuscapi.com.greendao.db.DaoMaster;
import kimweng.cuscapi.com.greendao.db.DaoSession;
import kimweng.cuscapi.com.greendao.db.PrinterDao;

import static android.media.CamcorderProfile.get;

public class MainActivity extends AppCompatActivity {
    private static Handler handle;
    private final static int Yes = 100;
    private final static int NO = 101;
    private TextView show;

    private static DaoSession daoSession;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show = (TextView) findViewById(R.id.show);
        handle = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                Bundle bundle = msg.getData();
                String back = bundle.getString("result");
                switch (msg.what) {
                    case Yes:
//                        Toast.makeText(this, "成功。。。", Toast.LENGTH_LONG).show();
                        Toast.makeText(MainActivity.this, "成功。。。", Toast.LENGTH_LONG).show();
                        show.setText(back);
                        break;
                    case NO:
                        Toast.makeText(MainActivity.this, "失败。。。", Toast.LENGTH_LONG).show();
                        show.setText(back);
                        break;
                    default:
                        break;
                }
            }
        };
//        getFenBian();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                getResult();
//            }
//        }).start();
        initDB();
        PrinterDao printerDao=daoSession.getPrinterDao();
        try {
            long dbBack=printerDao.insert(new Printer(101,"POS70","192.168.3.21","Kitchen_01"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Printer> printerList=printerDao.loadAll();
            if (printerList.size()>0){
                Printer printer= printerList.get(0);
                Bundle bundle = new Bundle();
            Message message = new Message();
            message.what = Yes;
            bundle.putString("result", ""+printer.getPrinterIp()+printer.getPrinterName()+printer.getPrinterType());
            message.setData(bundle);
            handle.sendMessage(message);
        }



    }
    private boolean getResult() {
        boolean result = false;
        QI qi1 = new QI(0, 0);
        QI qi2 = new QI(0, 0);
        QI qi3 = new QI(0, 0);
        for (int i = 1; i < 100; i++) {
            qi2.setX(i);
            for (int j = 0; j < 100; j++) {
                qi2.setY(j);
                for (int k = 0; k < 100; k++) {
                    qi3.setX(k);
                    if (getDistance(qi1,qi2)<k){
                        break;
                    }
                    for (int l = 0; l < 100; l++) {
                        qi3.setY(l);
                        if (getDistance(qi1,qi2)<getDistance(qi1,qi3))
                        {
                            break;
                        }

                        result = IsCrrort(qi1, qi2, qi3);
                        Log.e("Now"," "+i+"*"+j+"*"+k+"*"+l);
                        if (result) {
                            Bundle bundle = new Bundle();
                            Message message = new Message();
                            message.what = Yes;
                            bundle.putString("result", "" + qi2.getX() + "、" + "" + qi2.getY() + "、" + "" + qi3.getX() + "、" + "" + qi3.getY() + ":");
                            message.setData(bundle);
                            handle.sendMessage(message);
                            return  result;
                        }
                    }
                }
            }
        }
        if (!result) {
            Bundle bundle = new Bundle();
            Message message = new Message();
            message.what = NO;
            bundle.putString("result", "false");
            message.setData(bundle);
            handle.sendMessage(message);
        }
        return result;
    }

    private double getDistance(QI qi1, QI qi2) {
        double distance;
        distance = Math.pow((qi1.getX() - qi2.getX()), 2) + Math.pow((qi1.getY() - qi2.getY()), 2);
        distance = Math.round(distance);
        return distance;
    }

    private boolean IsCrrort(QI qi1, QI qi2, QI qi3) {
        boolean result = false;
        double Q1_Q2 = getDistance(qi1, qi2);
        double Q2_Q3 = getDistance(qi2, qi3);
        if (Q1_Q2!=Q2_Q3)
            return  false;
        double Q1_Q3 = getDistance(qi1, qi3);
        if (Q1_Q2 == Q1_Q3 && Q1_Q2 == Q2_Q3) {
            result = true;
        }
        return result;
    }
private  void  getFenBian(){
    DisplayMetrics metrics =new DisplayMetrics
/**
 * getRealMetrics - 屏幕的原始尺寸，即包含状态栏。
 * version >= 4.2.2
 */();
    getWindowManager().getDefaultDisplay().getRealMetrics(metrics);
    int width = metrics.widthPixels;
    int height = metrics.heightPixels;  Bundle bundle = new Bundle();
    Message message = new Message();
    message.what = NO;
    bundle.putString("result", "width:"+width+";"+"height"+height);
    message.setData(bundle);
    handle.sendMessage(message);

}
private void  initDB(){
    DaoMaster.DevOpenHelper helper=new DaoMaster.DevOpenHelper(this,"store.db",null);
    //获取可写数据库
    SQLiteDatabase db = helper.getWritableDatabase();
    //获取数据库对象
    DaoMaster daoMaster = new DaoMaster(db);
    //获取Dao对象管理者
    daoSession = daoMaster.newSession();
}
    public static DaoSession getDaoInstant() {
        return daoSession;
    }
}
