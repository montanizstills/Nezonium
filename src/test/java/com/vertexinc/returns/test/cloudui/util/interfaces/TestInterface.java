package com.vertexinc.returns.test.cloudui.util.interfaces;

import com.vertexinc.returns.test.cloudui.util.resources.Environment;


public interface TestInterface<someEnvironment extends Environment> extends PageInterface{

    someEnvironment getEnvironment();

     default void browserWait(int milliseconds) {
         try {
             wait(milliseconds);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }


}
