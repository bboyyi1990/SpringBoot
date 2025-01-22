package com.yi.sprintbootdemo.data

import jakarta.persistence.*

@Table(name = "user_info")
@Entity(name = "UserInfo")
data class User(
    @Id
    @Column(name = "user_id")
    val userId: Long,
    @Column(name = "user_name")
    val userName: String,
)


data class UserDTO(val userId: Long?, val userName: String?) {
    fun convert() = User(userId!!, userName!!)
}
