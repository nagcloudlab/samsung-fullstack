package com.example.component;

import com.example.container.RequestMapping;
import com.example.container.RequestMethod;

public class ProfileComponent {

    // path: /profile
    // method: GET
    @RequestMapping(
            path = "/profile",
            method = RequestMethod.GET
    )
    public String xxxxx(){
        System.out.println("handling profile req..");
        return  "PROFILE";
    }

}
