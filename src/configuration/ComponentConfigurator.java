/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package configuration;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import topology.storage.Aisle;
import topology.storage.Storage;

/**
 *
 * @author Mao
 */
public class ComponentConfigurator {

    File config;
    Storage storage;

    public ComponentConfigurator(String script) {
        config = new File(script);
        storage = new Storage();
    }

    // Configure components from script at start of system.
    public void configure(String task) {
      
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        DataInputStream dis = null;

        try {
            fis = new FileInputStream(config);
            // Here BufferedInputStream is added for fast reading.
            bis = new BufferedInputStream(fis);
            dis = new DataInputStream(bis);
            // dis.available() returns 0 if the file does not have more lines.
            while (dis.available() != 0) {
                String delims = "[ ]";
                String[] tokens = dis.readLine().split(delims);
               
                Object instance = loadClass(tokens[0]);
 
                Method myMethod = instance.getClass().getMethod("init",int.class,int.class);
                
 
             // Step 6:
             // Calling the real method. Passing methodParameter as
             // parameter. You can pass multiple parameters based on
             // the signature of the method you are calling. Hence
             // there is an array.
               int param1 = Integer.valueOf(tokens[1]);
               int param2 = Integer.valueOf(tokens[2]);
               myMethod.invoke(instance,param1,param2);
                
               storage.insert(instance);
                System.out.println("OK");
            }
            // dispose all the resources after using them.
            fis.close();
            bis.close();
            dis.close();

        } catch (IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
             
            Logger.getLogger(ComponentConfigurator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("IO Error!");
        }
    }

    // Configure component at runtime from admin command.
    public void processTask(String task) {
    }

    private Object loadClass(String classToLoad) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        Class classLoaded = loader.loadClass(classToLoad);
        Object instance = classLoaded.newInstance();
        return instance;
    }
}
