package com.sfr.newsprovider

import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.StreamsConfig.APPLICATION_ID_CONFIG
import org.apache.kafka.streams.StreamsConfig.BOOTSTRAP_SERVERS_CONFIG
import org.apache.kafka.streams.StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG
import org.apache.kafka.streams.StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.annotation.EnableKafkaStreams
import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration
import org.springframework.kafka.config.KafkaStreamsConfiguration
import kotlin.io.print

@Configuration
@EnableKafka
@EnableKafkaStreams
class KafkaConfig {
    @Value(value = "\${spring.kafka.bootstrap-servers}")
    private val bootstrapAddress: String = "localhost:9092"

    @Bean(name = [KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME])
    fun kStreamsConfig(): KafkaStreamsConfiguration {
        print(bootstrapAddress)
        val props: MutableMap<String, Any> = HashMap()
        props[APPLICATION_ID_CONFIG] = "news-provider-app"
        props[BOOTSTRAP_SERVERS_CONFIG] = bootstrapAddress
        props[DEFAULT_KEY_SERDE_CLASS_CONFIG] = Serdes.String().javaClass.getName()
        props[DEFAULT_VALUE_SERDE_CLASS_CONFIG] = Serdes.String().javaClass.getName()
        return KafkaStreamsConfiguration(props)
    }
}