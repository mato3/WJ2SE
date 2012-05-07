/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package topology.storage;

import java.util.HashMap;

/**
 *
 * @author Mao
 */
public class Storage implements StorageLocal {
    private HashMap manager;

    public Storage() {
        manager = new HashMap();
    }
   
    @Override
    public void insert(Object object) {
        String hashKey;
        if(object instanceof Aisle) {
            Aisle a = (Aisle)object;
            int code = a.getCode();
            hashKey = "A"+code;
        } else {
            Rack r = (Rack)object;
            int code = r.getCode();
            hashKey = "R"+code;
        }
 
       manager.put(hashKey, object);
    }

    @Override
    public void remove(Object object) {
        manager.remove(object.hashCode());
    } 

    @Override
    public Object find(String hashKey) {
        return manager.get(hashKey);
    }
    
    @Override
    public int addItem() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int removeItem() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int findItem() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getFreeSpace() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
