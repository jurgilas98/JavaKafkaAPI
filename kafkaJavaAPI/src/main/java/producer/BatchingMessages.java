package producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class BatchingMessages {

    public static void main(String[] args) {


        String topicName = "Seu Tópico";    //Alterar
        String value = "Value-";


        Properties props = new Properties();
        props.put("bootstrap.servers", "IP Externo e porta do servidor dos brokers");    //Alterar
        props.put("client.id", "IP Externo a porta do servidor onde foi criado o tópico");    //Alterar
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        //Linger up to 100 ms before sending batch if size not met
        props.put("linger.ms", 100);
        //Batch up to 16K buffer sizes.
        props.put("batch.size", 16384);
        //Defines total buffer memory
        props.put("buffer.memory", 33554432);


        KafkaProducer kafkaProducer = new KafkaProducer(props);

        for (int i = 0; i < 100; i++) {

            ProducerRecord<String, String> producerRecord = new ProducerRecord(topicName, value + i);

            kafkaProducer.send(producerRecord);


        }
        kafkaProducer.close();


    }
}

