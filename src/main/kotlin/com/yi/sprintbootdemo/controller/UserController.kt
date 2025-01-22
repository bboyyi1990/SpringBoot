package com.yi.sprintbootdemo.controller

import com.yi.sprintbootdemo.data.ResponseData
import com.yi.sprintbootdemo.data.User
import com.yi.sprintbootdemo.data.UserDTO
import com.yi.sprintbootdemo.exception.CustomException
import com.yi.sprintbootdemo.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user/")
class UserController {
    @Autowired
    lateinit var userService: UserService

    @PostMapping("add")
    fun addUser(@RequestBody user: UserDTO): ResponseData<User?> {
        if (user.userName.isNullOrEmpty()) throw CustomException(message = "User name can't be empty")
        if (user.userId == null) throw CustomException(message = "User id can't be null")
        val exist = userService.get(user.userId)
        return if (exist != null) throw CustomException(message = "Add user failed, user exist")
        else ResponseData.success(userService.add(user))
    }

    @DeleteMapping("delete")
    fun deleteUser(@RequestParam("userId") userId: Long): ResponseData<User?> {
        val result = userService.deleteUser(userId)
        return if (result) ResponseData.success()
        else ResponseData.fail(message = "Delete failed")
    }

    @PutMapping("edit")
    fun editUser(@RequestBody user: UserDTO): ResponseData<User?> {
        val result = userService.edit(user)
        return ResponseData.success(result)
    }

    @GetMapping("get")
    fun getUser(@RequestParam("userId") userId: Long): ResponseData<User?> {
        val result = userService.get(userId) ?: throw CustomException(message = "User not found")
        return ResponseData.success(result)
    }


}
