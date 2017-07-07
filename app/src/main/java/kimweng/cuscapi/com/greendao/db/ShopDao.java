package kimweng.cuscapi.com.greendao.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import kimweng.cuscapi.com.greendao.Shop;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "SHOP".
*/
public class ShopDao extends AbstractDao<Shop, Long> {

    public static final String TABLENAME = "SHOP";

    /**
     * Properties of entity Shop.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property ShopId = new Property(0, long.class, "shopId", true, "_id");
        public final static Property StoreId = new Property(1, long.class, "storeId", false, "STORE_ID");
    }

    private DaoSession daoSession;


    public ShopDao(DaoConfig config) {
        super(config);
    }
    
    public ShopDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"SHOP\" (" + //
                "\"_id\" INTEGER PRIMARY KEY NOT NULL ," + // 0: shopId
                "\"STORE_ID\" INTEGER NOT NULL UNIQUE );"); // 1: storeId
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"SHOP\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Shop entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getShopId());
        stmt.bindLong(2, entity.getStoreId());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Shop entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getShopId());
        stmt.bindLong(2, entity.getStoreId());
    }

    @Override
    protected final void attachEntity(Shop entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }    

    @Override
    public Shop readEntity(Cursor cursor, int offset) {
        Shop entity = new Shop( //
            cursor.getLong(offset + 0), // shopId
            cursor.getLong(offset + 1) // storeId
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Shop entity, int offset) {
        entity.setShopId(cursor.getLong(offset + 0));
        entity.setStoreId(cursor.getLong(offset + 1));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Shop entity, long rowId) {
        entity.setShopId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Shop entity) {
        if(entity != null) {
            return entity.getShopId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Shop entity) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
