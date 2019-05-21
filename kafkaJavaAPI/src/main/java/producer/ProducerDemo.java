package producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.List;
import java.util.Map;

public class ProducerDemo {

    public static void main(String[] args) {

        String topicName = "Seu Tópico";    //Alterar
        String key = "Key1";
        String value = "Value";

        Properties props = new Properties();
        props.put("bootstrap.servers", "IP Externo e porta do servidor dos brokers");    //Alterar
        props.put("client.id", "IP Externo a porta do servidor onde foi criado o tópico");    //Alterar
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");


        KafkaProducer kafkaProducer = new KafkaProducer(props);


        ProducerRecord<String, String> producerRecord = new ProducerRecord(topicName, key, value);

        kafkaProducer.send(producerRecord);


        List partitionInfoList = kafkaProducer.partitionsFor(topicName);


        Map metrics = kafkaProducer.metrics();


        kafkaProducer.close();


    }


}