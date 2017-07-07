package kimweng.cuscapi.com.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinProperty;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.Unique;

import java.lang.annotation.Annotation;
import java.util.List;
import org.greenrobot.greendao.annotation.Generated;

import static android.R.attr.name;
import org.greenrobot.greendao.DaoException;
import kimweng.cuscapi.com.greendao.db.DaoSession;
import kimweng.cuscapi.com.greendao.db.POSDao;
import kimweng.cuscapi.com.greendao.db.PrinterDao;
import kimweng.cuscapi.com.greendao.db.ShopDao;


/**
 * Created by admin on 2017/7/5.
 */
@Entity
public class Shop {
    @Id
    private  long shopId;
    @Unique
    private long storeId;
    @ToMany(joinProperties = {@JoinProperty(name = "storeId",referencedName = "storeId")})
   private List<Printer> printerList;
    @ToMany(joinProperties = {@JoinProperty(name ="storeId",referencedName = "storeId")})
    private List<POS> posList;
    private static Shop mInstance;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 173397329)
    private transient ShopDao myDao;

    @Generated(hash = 1302738235)
    public Shop(long shopId, long storeId) {
        this.shopId = shopId;
        this.storeId = storeId;
    }

    @Generated(hash = 633476670)
    public Shop() {
    }

//    public List<POS> getPosList() {
//        return posList;
//    }
//
//    public void setPosList(List<POS> posList) {
//        this.posList = posList;
//    }
//
//    public List<Printer> getPrinterList() {
//        return printerList;
//    }
//
//    public void setPrinterList(List<Printer> printerList) {
//        this.printerList = printerList;
//    }

    public long getStoreId() {
        return storeId;
    }

    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }

    public synchronized static Shop getInstance() {
        if (mInstance == null) {
            mInstance = new Shop();
        }
        return mInstance;
    }

    public long getShopId() {
        return this.shopId;
    }

    public void setShopId(long shopId) {
        this.shopId = shopId;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 979863519)
    public List<Printer> getPrinterList() {
        if (printerList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            PrinterDao targetDao = daoSession.getPrinterDao();
            List<Printer> printerListNew = targetDao._queryShop_PrinterList(storeId);
            synchronized (this) {
                if (printerList == null) {
                    printerList = printerListNew;
                }
            }
        }
        return printerList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 338995425)
    public synchronized void resetPrinterList() {
        printerList = null;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 2123165579)
    public List<POS> getPosList() {
        if (posList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            POSDao targetDao = daoSession.getPOSDao();
            List<POS> posListNew = targetDao._queryShop_PosList(storeId);
            synchronized (this) {
                if (posList == null) {
                    posList = posListNew;
                }
            }
        }
        return posList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 782652087)
    public synchronized void resetPosList() {
        posList = null;
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1040006210)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getShopDao() : null;
    }
}
