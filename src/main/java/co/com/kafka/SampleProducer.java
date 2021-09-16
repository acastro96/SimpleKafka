package co.com.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * Clase que se conecta con kafka y envia los mensajes
 */
public class SampleProducer {

    public SampleProducer() {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        //Producer record with the topic that you've created
        ProducerRecord producerRecord = new ProducerRecord("topicTest"
                                                            , "prueba"
                                                            , "Prueba de kafka producer");
        KafkaProducer kafkaProducer = new KafkaProducer(properties);

        kafkaProducer.send(producerRecord);
        kafkaProducer.close();
    }
}
