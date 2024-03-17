package com.sfr.newsprovider

import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.StreamsBuilder
import org.apache.kafka.streams.kstream.Consumed
import org.apache.kafka.streams.kstream.ValueMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component


@Component
class NewsProcessor(val service: NewsService) {
    @Autowired
    fun buildPipeline(streamsBuilder: StreamsBuilder) {
        val messageStream = streamsBuilder
            .stream("news-input", Consumed.with(STRING_SERDE, STRING_SERDE))
        messageStream
            .mapValues(ValueMapper { obj: String ->
                val news = News()
                news.text = obj
                news.author = "matilda"
                news.date = "16.02.2024"
                news.title = "title"
                service.create(news)
            }) //as ValueMapper<String, String>)
            /*.flatMapValues { value: String ->
                val news = News()
                news.text = value
                news.author = "matilda"
                news.date = "16.02.2024"
                news.title = "title"
                service.create(news)

            }*/
    }

    fun processEvent(){

    }
    companion object {
        private val STRING_SERDE = Serdes.String()
    }
}