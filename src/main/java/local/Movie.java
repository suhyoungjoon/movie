package local;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Movie_table")
public class Movie {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Integer movieId;
    private String movieName;
    private Integer countPurchase;
    private Float ratingValue;

    @PrePersist
    public void onPrePersist(){
        Registered registered = new Registered();
        BeanUtils.copyProperties(this, registered);
        registered.publish();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }
    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
    public Integer getCountPurchase() {
        return countPurchase;
    }

    public void setCountPurchase(Integer countPurchase) {
        this.countPurchase = countPurchase;
    }
    public Float getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(Float ratingValue) {
        this.ratingValue = ratingValue;
    }




}
