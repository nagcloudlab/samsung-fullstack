package com.example.container;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class WebContainer {

    public void handleHttpRequest(String path){

        // reflect .class file, for annotations
        try {

            Class<?> clazz=Class.forName("com.example.component.ProfileComponent");
            Object profileCompInstance=clazz.newInstance();

            Method[] methods=clazz.getMethods();
            for(Method method:methods){
               RequestMapping rm= method.getAnnotation(RequestMapping.class);
               if(rm!=null){
                   String givenPath=rm.path();
                   if(path.equals(givenPath)){
                       method.invoke(profileCompInstance,new Object[]{});
                   }
               }
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

    }

}
