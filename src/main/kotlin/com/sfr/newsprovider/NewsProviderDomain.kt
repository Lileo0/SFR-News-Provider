package com.sfr.newsprovider

import jakarta.persistence.*
import java.util.Date

@Entity
open class News() {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Column(nullable = false)
    open  var date: String? = null

    @Column(nullable = false)
    open  var title: String? = null

    @Column(nullable = false)
    open  var text: String? = null

    @Column(nullable = false)
    open  var author: String? = null
}