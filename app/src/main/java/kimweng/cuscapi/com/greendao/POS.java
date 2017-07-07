package kimweng.cuscapi.com.greendao;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinProperty;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.Unique;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import kimweng.cuscapi.com.greendao.db.DaoSession;
import kimweng.cuscapi.com.greendao.db.PrinterDao;
import kimweng.cuscapi.com.greendao.db.POSDao;

/**
 * Created by admin on 2017/7/5.
 */
@Entity
public class POS {
    @NotNull
    private  long storeId;
    @Unique
    private String posIp;
    @NotNull
    private  String posType;
//    @Convert(columnType = String.class,converter = ObjectConverter.class)
    @ToMany(joinProperties = {@JoinProperty(name = "posIp",referencedName = "printerIp")})
    private List<Printer> printerList;


    public long getStoreId() {
        return storeId;
    }

    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 531035640)
    private transient POSDao myDao;

    @Generated(hash = 991172100)
    public POS() {
    }

    @Generated(hash = 2072466436)
    public POS(long storeId, String posIp, @NotNull String posType) {
        this.storeId = storeId;
        this.posIp = posIp;
        this.posType = posType;
    }

    public String getPosIp() {
        return this.posIp;
    }
    public void setPosIp(String posIp) {
        this.posIp = posIp;
    }
    public String getPosType() {
        return this.posType;
    }
    public void setPosType(String posType) {
        this.posType = posType;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 338995425)
    public synchronized void resetPrinterList() {
        printerList = null;
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
    @Generated(hash = 561546437)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getPOSDao() : null;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 104673480)
    public List<Printer> getPrinterList() {
        if (printerList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            PrinterDao targetDao = daoSession.getPrinterDao();
            List<Printer> printerListNew = targetDao._queryPOS_PrinterList(posIp);
            synchronized (this) {
                if (printerList == null) {
                    printerList = printerListNew;
                }
            }
        }
        return printerList;
    }
}
