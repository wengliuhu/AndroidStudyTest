package kimweng.cuscapi.com.greendao;

import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.NotNull;

/**
 * Created by admin on 2017/7/5.
 */

public class PrintCom extends   Printer{
    @NotNull
    private  String comFilePath;
    @NotNull
    private  String buatrate;

    public String getBuatrate() {
        return buatrate;
    }

    public void setBuatrate(String buatrate) {
        this.buatrate = buatrate;
    }

    public String getComFilePath() {
        return comFilePath;
    }

    public void setComFilePath(String comFilePath) {
        this.comFilePath = comFilePath;
    }
@Generated(hash = 10000)
    public PrintCom(String buatrate, String comFilePath) {
        this.buatrate = buatrate;
        this.comFilePath = comFilePath;
    }
}
