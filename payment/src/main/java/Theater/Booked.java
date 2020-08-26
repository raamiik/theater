
package Theater;

public class Booked extends AbstractEvent {

    private Long id;
    private Long bookId;
    private String movieName;
    private Long roomNum;
    private Long seatNum;
    private String bookingDate;

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
