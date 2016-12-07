package orm;

import orm.interfaces.DBContext;
import persistance.Column;
import persistance.Entity;
import persistance.Id;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;

/**
 * Created by cefothe on 07.12.16.
 */
public class EntityManager implements DBContext {

    private Connection connection;

    private PreparedStatement preparedStatement;

    private ResultSet resultSet;

    public EntityManager(Connection connection) {
        this.connection = connection;
    }

    @Override
    public <E> boolean persist(E entity) throws SQLException, IllegalAccessException {
        Field primary = getId(entity.getClass());
        doCreate(entity,primary);
        this.doUpdate(entity,primary);
        this.doInsert(entity, primary);
        return false;
    }

    private <E> boolean doInsert(E entity, Field primary) throws IllegalAccessException, SQLException {
        String sqlInsert ="INSERT INTO " + getTableName(entity.getClass()) + "(";

        String columns = "";
        String values = "";
        Field[] fields = entity.getClass().getDeclaredFields();
        for(int i =0 ; i<fields.length; i++){
            Field field = fields[i];
            field.setAccessible(true);
            if(!field.getName().equals(primary.getName())){
                columns +="`" + this.getFieldName(field)+ "`" ;

                Object value =field.get(entity);
                if(value instanceof Date){
                    values += "'" +  new SimpleDateFormat("yyyy-MM-dd").format((Date)value)+ "'";
                }else {
                    values += "'" + field.get(entity) + "'";
                }
                if(i< fields.length-1){
                    columns += " , ";
                    values += " , ";
                }
            }
        }

        sqlInsert += columns + " ) " + "VALUES ("+ values+" )";
        return connection.prepareStatement(sqlInsert).execute();

    }

    private <E> void doUpdate(E entity, Field primary) throws SQLException, IllegalAccessException {
        String sqlUpdate ="UPDATE " + getTableName(entity.getClass()) + " SET ";


        String columns = "";
        Field[] fields = entity.getClass().getDeclaredFields();
        for(int i =0 ; i<fields.length; i++){
            Field field = fields[i];
            field.setAccessible(true);

            if(!field.getName().equals(primary.getName())){
                columns +="`" + this.getFieldName(field)+ "` = " ;

                Object value =field.get(entity);
                if(value instanceof Date){
                    columns += "'" +  new SimpleDateFormat("yyyy-MM-dd").format((Date)value)+ "'";
                }else {
                    columns += "'" + field.get(entity) + "'";
                }
                if(i< fields.length-1){
                    columns += " , ";
                }
            }
        }

        primary.setAccessible(true);
        Integer value = (Integer)primary.get(entity);

        sqlUpdate += columns + "  " + "WHERE `"+ getId(entity.getClass()).getName()+"` = "+ value;

        connection.prepareStatement(sqlUpdate).execute();

    }

    @Override
    public <E> Iterator<E> find(Class<E> table) {
        return null;
    }

    @Override
    public <E> Iterator<E> find(Class<E> table, String where) {
        return null;
    }

    @Override
    public <E> E findFirst(Class<E> table) {
        return null;
    }

    @Override
    public <E> E findFirst(Class<E> table, String where) {
        return null;
    }

    private  <E> String getTableName(Class<E> entity){
        if(entity.isAnnotationPresent(Entity.class)){
            return entity.getAnnotation(Entity.class).name();
        }
        return entity.getSimpleName();
    }

    private String getFieldName(Field field){
        if(field.isAnnotationPresent(Column.class)){
            return field.getAnnotation(Column.class).name();
        }
        return field.getName();
    }

    private Field getId(Class c){
        return Arrays.stream(c.getDeclaredFields()).filter(f-> f.isAnnotationPresent(Id.class))
                .findFirst().orElseThrow(() -> new IllegalArgumentException());
    }

    private <E> boolean doCreate (E entity, Field primary) throws SQLException {
        String tableName = getTableName(entity.getClass());
        String sqlCreate ="CREATE TABLE IF NOT EXISTS "+ tableName +"( ";

        String columns= "";
        String databaseTypes = "";

        Field [] fields = entity.getClass().getDeclaredFields();
        for( int i=0 ; i< fields.length; i++){
            Field field = fields[i];
            field.setAccessible(true);



            columns += " `" + getFieldName(field) + "` "
                    + this.getDatabaseType(field);

            if(field.getName().equals(primary.getName())){
                columns += " PRIMARY KEY AUTO_INCREMENT ";
            }

            if(i< fields.length -1){
                columns+=",";
            }
        }
        sqlCreate += columns + " )";

        return connection.prepareStatement(sqlCreate).execute();
    }

    private String getDatabaseType(Field field) {
        switch (field.getType().getSimpleName().toString().toLowerCase()){
            case "int" :
                return "INT";
            case "string":
                return "VARCHAR(50)";
            case "long":
                return "LONG";
            case "date":
                return  "DATE";
        }
        return null;
    }

}
