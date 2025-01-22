package com.yi.sprintbootdemo.service

import com.yi.sprintbootdemo.logE
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserServiceImplementTest {
    @Autowired
    val service: UserService? = null

    @Test
    fun queryTest() {
        val result = service?.getUserByName("Zero")
        "$result".logE()
    }
}
