package com.example.blog

import com.example.blog.util.toSlug
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Article(

    var title:String,
    var headline: String,
    var content: String,

    @ManyToOne @JoinColumn
    var author: User,
    var slug: String = title.toSlug(),
    var addedAt: LocalDateTime = LocalDateTime.now(),

    @Id @GeneratedValue
    var id: Long? = null)




@Entity
data class User(
    var login: String,
    var firstName: String,
    var lastName: String,
    var description: String? = null,

    @Id @GeneratedValue
    var id: Long? = null)