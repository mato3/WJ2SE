/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package topology.storage;

import configuration.AbstractComponent;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mao
 */
public class Aisle extends AbstractComponent {
     private int code;
    private int capacity;
    private List<Rack> racks;
    private Boolean isReady;
   
    public Aisle() {
    }
    
    public Aisle(int code, int capacity) {
        this.code = code;
        this.capacity = capacity;
        racks = new ArrayList();
        isReady = false;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCode() {
        return code;
    }

    public List<Rack> getRacks() throws Exception {
        if (isReady) {
            return racks;
        } else {
            throw new Exception("Aisle is not inicialized!");
        }        
    }
    
    @Override
    public void init(int code, int capacity) {
        this.code = code;
        this.capacity = capacity;
        racks = new ArrayList();
        isReady = true;
    }

    @Override
    public void suspend() {
        isReady = false;
    }

    @Override
    public void resume() {
        isReady = true;
    }

    @Override
    public String info() {
        return "This is an Aisle for Racks.\nCode: " + code + "\n" + "Capacity: " + capacity;
    }
 public void m() {
        System.out.println("ahooj");
    }
}
