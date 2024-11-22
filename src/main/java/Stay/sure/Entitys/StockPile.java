package Stay.sure.Entitys;

import java.util.Date;

public class StockPile {

    private Long id;
    private Long id_room;
    private Long id_user;
    private Date date_stockpile;

    
    public StockPile(Long id, Long id_room, Long id_user, Date date_stockpile) {
        this.id = id;
        this.id_room = id_room;
        this.id_user = id_user;
        this.date_stockpile = date_stockpile;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId_room() {
        return id_room;
    }
    public void setId_room(Long id_room) {
        this.id_room = id_room;
    }
    public Long getId_user() {
        return id_user;
    }
    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }
    public Date getDate_stockpile() {
        return date_stockpile;
    }
    public void setDate_stockpile(Date date_stockpile) {
        this.date_stockpile = date_stockpile;
    }

}
