package com.sk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Sk on 07-04-2017.
 */

@RestController
@CrossOrigin
public class SocketRestService {

    @Autowired
    SocketMessageHandler handler;

    @RequestMapping("/api")
    public String receiveMessage(@RequestParam String msg){
        System.out.println("Message received: " + msg);
        handler.sendMessage(msg);
        return msg;
    }
}
