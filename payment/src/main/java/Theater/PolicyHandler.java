package Theater;

import Theater.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }


    @Autowired
    PaymentRepository paymentRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverBooked_MakePayment(@Payload Booked booked){

        if(booked.isMe()){
            Payment payment = new Payment();
            payment.setBookId(booked.getBookId());
            payment.setStatus("Booked!!!");

            paymentRepository.save(payment);
            System.out.println("##### listener MakePayment : " + booked.toJson());
        }
    }


}
