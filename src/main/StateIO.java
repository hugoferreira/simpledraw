package main;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public final class StateIO {
public static Document load(String path){
        try {
                FileInputStream fis = new FileInputStream(path);
                ObjectInputStream ois = new ObjectInputStream(fis);
                return (Document) ois.readObject();
        }
        catch(Exception e) {
                return null;
        }
}

public static boolean save(Document d, String path){
        try{
                FileOutputStream fos = new FileOutputStream(path);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(d);
                oos.close();
        }
        catch(Exception e) {
                return false;
        }
        return true;
}
}
