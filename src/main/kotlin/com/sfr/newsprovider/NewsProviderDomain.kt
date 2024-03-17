package com.sfr.newsprovider

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.*
import java.util.Date

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
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

/*
{
    "id": 3,
    "date": "2024-02-18",
    "title": "Technology News",
    "text": "Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.",
    "author": "Alex Johnson"
}

{
    "id": 2,
    "date": "2024-02-17",
    "title": "Sports Update",
    "text": "Nullam eget felis nec urna tincidunt aliquet.",
    "author": "Jane Smith"
}

{
    "id": 1,
    "date": "2024-02-16",
    "title": "Breaking News",
    "text": "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
    "author": "John Doe"
}

{
    "id": 1,
    "date": "2024-02-16",
    "title": "Breaking News",
    "text": "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
    "author": "John Doe",
    "feedback": "test"
}


{
  "schema": {
    "type": "record",
    "name": "NewsArticle",
    "fields": [
        {"name": "title", "type": "string"},
        {"name": "date", "type": "string"},
        {"name": "text", "type": "string"},
        {"name": "author", "type": "string"}
    ]},
  "payload": {
    "title": "Breaking News",
    "date": "2024-02-16",
    "text": "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
    "author": "Jane Doe"
  }
}

 */