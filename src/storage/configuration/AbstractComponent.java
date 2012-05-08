/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package storage.configuration;

/**
 *
 * @author Mao
 */
public abstract class AbstractComponent {
    public abstract void init(int code, int capacity);
    public abstract void suspend();
    public abstract void resume();
    public abstract String info();
}
