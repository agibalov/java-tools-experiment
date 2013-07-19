package me.loki2302;

import org.tanukisoftware.wrapper.WrapperListener;
import org.tanukisoftware.wrapper.WrapperManager;

public class ServerDaemon implements WrapperListener {
    public static void main(String[] args) {
        System.out.println("I am server daemon");
        WrapperManager.start(new ServerDaemon(), args);
    }

    public void controlEvent(int arg0) {        
    }

    public Integer start(String[] arg0) {
        return null;
    }

    public int stop(int arg0) {
        return 0;
    }
}
