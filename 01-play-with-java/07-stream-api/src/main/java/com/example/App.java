package com.example;

import com.example.model.Dish;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
        List<Dish> menu = Dish.menu;
        // Req1: get dish names where cal < 400, ordered by cal
        System.out.println(
                getLowCalDishNamesV2(menu)
        );
    }

    private static List<String> getLowCalDishNamesV1(List<Dish> menu) {

        // data processing pipeline
        // Limitation:
        // - imperative style
        // - sequential processing ( complete process done by single-thread )
        // - too many mutable variables ( not good concurrent world )
        // - too much code
        // -
        // solution: streams api => simplify to write data processing pipelines with LAMBDA(s);

        //stage-1: Filter
        List<Dish> lowCalDishList = new ArrayList<>();
        for (Dish dish : menu) {
            if (dish.getCalories() < 400)
                lowCalDishList.add(dish);
        }
        //stage-2: Sorting
        lowCalDishList.sort(new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(), o2.getCalories());
            }
        });
        // stage-3: Transform : Dish -> String
        List<String> lowCalDishNameList = new ArrayList<>();
        for (Dish dish : lowCalDishList) {
            lowCalDishNameList.add(dish.getName());
        }
        return lowCalDishNameList;
    }


    private static List<?> getLowCalDishNamesV2(List<Dish> menu) {
        return menu
                .stream() // build
                .filter(Dish::isVegetarian)
                .filter(d->d.getCalories()<400)
                .sorted((Comparator.comparing(Dish::getCalories)))
                .map(Dish::getName)
                .collect(Collectors.toList()); // terminal
    }

}
