package com.sfr.newsprovider

import io.confluent.kafka.serializers.KafkaAvroDeserializer
import io.confluent.kafka.serializers.KafkaAvroSerializer
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
        val STRING_SERDE = Serdes.String()
        val KAFKA_DE = KafkaAvroDeserializer()
        KAFKA_DE.configure(
            mapOf("schema.registry.url" to "http://localhost:8090"),false
        )
        val KAFKA_SER = KafkaAvroSerializer()
        KAFKA_SER.configure(
            mapOf("schema.registry.url" to "http://localhost:8090"),false
        )
        val messageStream = streamsBuilder
            .stream("news-input", Consumed.with(STRING_SERDE, Serdes.serdeFrom(KAFKA_SER,KAFKA_DE)))
        //KAFKA_DE.configure(mapOf("schema.registry.url" to "http://localhost:8090"),false)
        messageStream.foreach { key, value -> println(value); println("HELLOOOOO")}

    }

    fun processEvent(){

    }
    companion object {
        private val STRING_SERDE = Serdes.String()
        private val KAFKA_DE = KafkaAvroSerializer()
        private val KAFKA_SERDE = Serdes.serdeFrom(KafkaAvroSerializer(),KafkaAvroDeserializer())
        private val BYTEARRAY_SERDE = Serdes.ByteArray()
    }
}