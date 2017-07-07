package kimweng.cuscapi.com.greendao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static java.lang.Math.E;


/**
 * Created by admin on 2017/7/6.
 */

public class ObjectConverter implements PropertyConverter<List<String>, String> {
    private Gson gson = new Gson();

    @Override
    public List<String> convertToEntityProperty(String databaseValue) {
        if (databaseValue == null)
            return null;

        Type type = new TypeToken<List<String>>() {
        }.getType();
        List<String> list = gson.fromJson(databaseValue, type);
        if (list != null)
            return list;
        return null;
    }

    @Override
    public String convertToDatabaseValue(List<String> entityProperty) {
        String databaseValue = "";
        if (entityProperty != null) {
            databaseValue = gson.toJson(entityProperty);
        }
        return databaseValue;
    }

}
