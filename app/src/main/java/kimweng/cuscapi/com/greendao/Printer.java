package kimweng.cuscapi.com.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Unique;

import static android.R.string.no;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by admin on 2017/7/5.
 */
@Entity
public class Printer {
    @NotNull
    private long storeId;
    @NotNull
    private String printerType;
    @Unique
    private String printerIp;
    @NotNull
    private String printerName;


    @Generated(hash = 206512902)
    public Printer() {
    }



    @Generated(hash = 2073450412)
    public Printer(long storeId, @NotNull String printerType, String printerIp,
            @NotNull String printerName) {
        this.storeId = storeId;
        this.printerType = printerType;
        this.printerIp = printerIp;
        this.printerName = printerName;
    }



    public String getPrinterIp() {
        return printerIp;
    }

    public void setPrinterIp(String printerIp) {
        this.printerIp = printerIp;
    }

    public String getPrinterType() {
        return printerType;
    }

    public void setPrinterType(String printerType) {
        this.printerType = printerType;
    }

    public String getPrinterName() {
        return printerName;
    }

    public void setPrinterName(String printerName) {
        this.printerName = printerName;
    }

    public long getStoreId() {
        return storeId;
    }

    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }
}
