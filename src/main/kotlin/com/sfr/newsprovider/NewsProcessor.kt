package com.sfr.newsprovider

import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.StreamsBuilder
import org.apache.kafka.streams.kstream.Consumed
import org.apache.kafka.streams.kstream.ValueMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import com.fasterxml.jackson.databind.ObjectMapper

@Component
class NewsProcessor(val service: NewsService) {

    val objectMapper = ObjectMapper()

    @Autowired
    fun buildPipeline(streamsBuilder: StreamsBuilder) {
        val messageStream = streamsBuilder
            .stream("news-input", Consumed.with(STRING_SERDE, STRING_SERDE))
        messageStream
            .mapValues(ValueMapper { obj: String ->
                val news: News = objectMapper.readValue(obj, News::class.java)
                // todo what if field missing
                /*println("Deserialized News:")
                println("ID: ${news.id}")
                println("Date: ${news.date}")
                println("Title: ${news.title}")
                println("Text: ${news.text}")
                println("Author: ${news.author}")*/

                service.create(news)
            })
    }

    fun processEvent(){

    }
    companion object {
        private val STRING_SERDE = Serdes.String()
    }
}