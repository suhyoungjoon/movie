package local;

import local.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{

    @Autowired
    MovieRepository movieRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverRated_ScoreUpdate(@Payload Rated rated){

        if(rated.isMe()){
            System.out.println("##### listener ScoreUpdate : " + rated.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPurchased_PurchaseUpdate(@Payload Purchased purchased){

        if(purchased.isMe()){
            System.out.println("##### listener PurchaseUpdate : " + purchased.toJson());
            System.out.println("##### /purchasingSystem/purchase  called #####");

            Movie movie = new Movie();
            movie.setMovieId(purchased.getMovieId());
            movie.setMovieName(purchased.getMovieName());
            movie.setCountPurchase(1);
            movieRepository.save(movie);
        }

    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverCanceled_PurchaseUpdate(@Payload Canceled canceled){

        if(canceled.isMe()){
            System.out.println("##### listener PurchaseUpdate : " + canceled.toJson());
        }
    }

}
