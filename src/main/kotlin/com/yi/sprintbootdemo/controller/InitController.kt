package com.yi.sprintbootdemo.controller

import com.yi.sprintbootdemo.service.InitService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/init/")
class InitController {
    @Autowired
    val initService: InitService? = null

    @GetMapping("start")
    fun getInit(): String {
        return initService!!.start()
    }
}
