package com.sist.webchat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatController {
    @RequestMapping("webchat.do")
    public String webchat()
    {
    	return "webchat";
    }
}
