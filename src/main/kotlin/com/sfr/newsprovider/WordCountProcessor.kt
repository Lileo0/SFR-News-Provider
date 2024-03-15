package com.sfr.newsprovider

import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.StreamsBuilder
import org.apache.kafka.streams.kstream.Consumed
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component


@Component
class WordCountProcessor {
    /*@Autowired
    fun buildPipeline(streamsBuilder: StreamsBuilder) {
        val messageStream = streamsBuilder
            .stream("news-input", Consumed.with(STRING_SERDE, STRING_SERDE))
        val wordCounts = messageStream
            .mapValues(ValueMapper { obj: String ->
                obj.lowercase(
                    Locale.getDefault()
                )
            } as ValueMapper<String, String>)
            .flatMapValues { value: String ->
                Arrays.asList(*value.split("\\W+".toRegex()).dropLastWhile { it.isEmpty() }
                    .toTypedArray())
            }
            .groupBy({ key: String?, word: String -> word }, Grouped.with(STRING_SERDE, STRING_SERDE))
            .count()
        wordCounts.toStream().to("news-output")
    }*/

    @Autowired
    fun buildPipeline(streamsBuilder: StreamsBuilder) {
        val messageStream = streamsBuilder
            .stream("news-input", Consumed.with(STRING_SERDE, STRING_SERDE))
    }

    fun processEvent(){

    }
    companion object {
        private val STRING_SERDE = Serdes.String()
    }
}