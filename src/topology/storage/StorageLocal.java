/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package topology.storage;

/**
 *
 * @author Mao
 */
public interface StorageLocal {
    public void insert(Object object);
    public void remove(Object object);
    public Object find(Object object);
    
    public int addItem();
    public int removeItem();
    public int findItem();
    public int getFreeSpace();
    
}
