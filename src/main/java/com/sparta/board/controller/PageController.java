package com.sparta.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping(value = "/")
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/post")
    public String post() {
        return "post";
    }

    @RequestMapping(value = "/create")
    public String create() {
        return "create";
    }
}
