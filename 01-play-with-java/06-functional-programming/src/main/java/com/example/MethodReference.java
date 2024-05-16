package com.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//FoodLib From third-party..
class FoodLib {
    private static List<String> nonVegItems = List.of(
            "chicken",
            "fish",
            "egg"
    );

    public boolean isNonVegItem(String item) {
        return nonVegItems.contains(item);
    }

}

// Am i audible.......

public class MethodReference {
    public static void main(String[] args) {

        List<String> menu = new ArrayList<>();
        menu.add("idly");
        menu.add("vada");
        menu.add("poori");
        menu.add("chicken");
        menu.add("fish");
        menu.add("egg");
        menu.add("fruits");

        // remove all non-veg items from above list

        // way-1: imperative style
//        Iterator<String> iterator=menu.iterator();
//        while (iterator.hasNext()){
//            String item=iterator.next();
//            if(FoodLib.isNonVegItem(item))
//                iterator.remove();
//        }
        // way-2: declarative style

//        // way-1
//        menu.removeIf(menuItem->{
//            return FoodLib.isNonVegItem(menuItem);
//        });

        // way-2
        // menu.removeIf(menuItem-> FoodLib.isNonVegItem(menuItem));

        // way-3 : Method Reference
        FoodLib foodLib = new FoodLib();
        menu.removeIf(foodLib::isNonVegItem);

        System.out.println(menu);


    }
}
