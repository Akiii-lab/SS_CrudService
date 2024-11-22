package Stay.sure.Entitys.DTO;

import java.util.Date;

public class StockPileDTO {
    public Long id;
    public Long id_room;
    public Long id_user;
    public Date date_stockpile;

    
    public StockPileDTO(Long id, Long id_room, Long id_user, Date date_stockpile) {
        this.id = id;
        this.id_room = id_room;
        this.id_user = id_user;
        this.date_stockpile = date_stockpile;
    }

}
