package ro.sdacademy.javaremote12.generics;

import java.util.List;

public interface Repository<T> {
        void  createObject(T o);


         void updateObject(T o);

         List<T> getAllObjects(String string, T o);

         Object getObjectById(T o,Integer id,String string) throws Exception;

         void deleteObject(T o);

}
