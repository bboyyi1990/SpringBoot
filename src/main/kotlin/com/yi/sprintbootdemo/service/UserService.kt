package com.yi.sprintbootdemo.service

import com.yi.sprintbootdemo.data.User
import com.yi.sprintbootdemo.data.UserDTO
import com.yi.sprintbootdemo.exception.CustomException
import com.yi.sprintbootdemo.logE
import com.yi.sprintbootdemo.repoistory.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.Exception
import kotlin.jvm.optionals.getOrNull


interface UserService {
    fun add(user: UserDTO): User?
    fun get(userId: Long): User?
    fun getUserByName(name: String): List<User>?
    fun deleteUser(userId: Long): Boolean
    fun edit(user: UserDTO): User
}

@Service
class UserServiceImplement : UserService {
    @Autowired
    lateinit var userRepository: UserRepository

    override fun add(user: UserDTO): User? {
        return try {
            userRepository.save(user.convert())
        } catch (e: Exception) {
            e.message?.logE()
            null
        }
    }

    override fun deleteUser(userId: Long): Boolean {
        val exist = userRepository.existsById(userId)
        if (exist) userRepository.deleteById(userId)
        else throw CustomException(message = "User not exist")
        return !userRepository.existsById(userId)
    }

    override fun edit(user: UserDTO): User {
        val result = userRepository.save(user.convert())
        return result
    }

    override fun get(userId: Long): User? {
        return userRepository.findById(userId).getOrNull()
    }

    override fun getUserByName(name: String): List<User>? {
        return userRepository.getUserByName(name)
    }


}
