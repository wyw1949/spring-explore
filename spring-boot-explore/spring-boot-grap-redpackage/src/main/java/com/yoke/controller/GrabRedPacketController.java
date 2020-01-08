package com.yoke.controller;

import com.yoke.service.IUserRedPacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("red-packet")
public class GrabRedPacketController {

    @Autowired
    private IUserRedPacketService iUserRedPacketService;

    @PostMapping("grab")
    public Map<String, Object> grabRedPacket(@RequestParam("rpId") Integer rpId, @RequestParam("userId") Integer userId){
        Map<String, Object> result = new HashMap<>();
        boolean res = iUserRedPacketService.grabRedPacket(rpId, userId);
        if (res){
            result.put("code", "200");
            result.put("message", "success");
        }else {
            result.put("code", "500");
            result.put("message", "fail");
        }
        return result;
    }
}
