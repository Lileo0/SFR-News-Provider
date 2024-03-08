package com.sfr.newsprovider

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.kafka.test.context.EmbeddedKafka

//@SpringBootTest
@EmbeddedKafka(topics = (["topic"]), partitions = 1)
class NewsProviderApplicationTests {

    @Test
    fun contextLoads() {
    }

}
