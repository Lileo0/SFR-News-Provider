package com.sfr.newsprovider

import org.springframework.stereotype.Service

@Service
class NewsService(val db: NewsRepository) {
    fun create(news: News) : News {
        return db.save(news)
    }
}