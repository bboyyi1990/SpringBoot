package com.yi.sprintbootdemo.service

import org.springframework.stereotype.Service

interface InitService {
    fun start(): String
}

@Service
class InitServiceImplement : InitService {
    override fun start(): String = "Initialize Success!"
}
