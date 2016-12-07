package orm.interfaces;

import java.sql.SQLException;
import java.util.Iterator;

/**
 * Created by cefothe on 07.12.16.
 */
public interface DBContext {

    <E> boolean persist(E entity) throws SQLException, IllegalAccessException;

    <E> Iterator<E> find(Class<E> table);

    <E> Iterator<E> find(Class<E> table, String where);

    <E> E findFirst(Class<E> table);

    <E> E findFirst(Class<E> table, String where);
}
