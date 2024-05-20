package org.example;

public class Ex5 {
    public static void main(String[] args) {
        // Nashorn JavaScript Engine: introduced in Java 8
        // It is used to execute JavaScript code in Java
        // It is a part of Java SE since 8
        // It is used to provide standards-based scripting engine

        // code

        // create a script engine manager
        javax.script.ScriptEngineManager factory = new javax.script.ScriptEngineManager();

        // create a JavaScript engine
        javax.script.ScriptEngine engine = factory.getEngineByName("nashorn");

        // evaluate JavaScript code
        try
        {
            engine.eval("print('Hello, World!')");
        }
        catch(javax.script.ScriptException e)
        {
            System.out.println(e);
        }

    }
}
