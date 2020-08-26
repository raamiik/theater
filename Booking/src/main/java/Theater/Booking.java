package Theater;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Booking_table")
public class Booking {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long bookId;
    private String movieName;
    private Long roomNum;
    private Long seatNum;
    private String bookingDate;

    @PostPersist
    public void onPostPersist(){
        Booked booked = new Booked();
        BeanUtils.copyProperties(this, booked);
        booked.publishAfterCommit();


    }

    @PreUpdate
    public void onPreUpdate(){
        Unbooked unbooked = new Unbooked();
        BeanUtils.copyProperties(this, unbooked);
        unbooked.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        unbooked.setBookId(this.getBookId());

        Theater.external.Payment payment = new Theater.external.Payment();
        // mappings goes here
        BookingApplication.applicationContext.getBean(Theater.external.PaymentService.class)
            .cancelPayment(payment);


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
    public Long getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(Long roomNum) {
        this.roomNum = roomNum;
    }
    public Long getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(Long seatNum) {
        this.seatNum = seatNum;
    }
    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }




}
