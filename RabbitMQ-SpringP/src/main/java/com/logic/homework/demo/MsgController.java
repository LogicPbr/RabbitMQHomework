package com.logic.homework.demo;

import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * CopyRright(c)2017-2020 Logic  <p>
 * Package com.logic.homework.demo
 * FileName  MsgController <p>
 * Describe  <p>
 * author   logic <p>
 * version  v1.0 <p>
 * CreateDate  2020-12-31 17:59 <p>
 */
@Controller
@RequestMapping("/msg")
public class MsgController {

    @Autowired
    private IMsgService msgService;

    @GetMapping("/directSend")
    public void directSend(String msg) {
        System.out.println("准备发送消息："+msg);
        msgService.directSend(msg);
    }

    @GetMapping("/topicSend")
    public void topicSend(String msg) {
        System.out.println("准备发送消息："+msg);
        msgService.topicSend(msg);
    }

    @GetMapping("/fanoutSend")
    public void fanoutSend(String msg) {
        System.out.println("准备发送消息："+msg);
        msgService.fanoutSend(msg);
    }

}
