package local;

public class Registered extends AbstractEvent {

    private Long id;
    private Integer movieId;
    private String movieName;
    private Integer countPurchase;
    private Float ratingValue;

    public Registered(){
        super();
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
