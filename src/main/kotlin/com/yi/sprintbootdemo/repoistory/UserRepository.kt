package com.yi.sprintbootdemo.repoistory

import com.yi.sprintbootdemo.data.User
import com.yi.sprintbootdemo.data.UserDTO
import org.hibernate.annotations.OnDelete
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<User, Long> {
    @Query("select * from user_info where user_name = :name", nativeQuery = true)
    fun getUserByName(name: String): List<User>
}
