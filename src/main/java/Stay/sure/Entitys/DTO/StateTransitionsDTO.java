package Stay.sure.Entitys.DTO;

import java.util.Date;

public class StateTransitionsDTO {

    public Long id;
    public Long id_State;
    public Long id_StockPile;
    public Date date_transition;

    public StateTransitionsDTO(Long id, Long id_State, Long id_StockPile, Date date_transition) {
        this.id = id;
        this.id_State = id_State;
        this.id_StockPile = id_StockPile;
        this.date_transition = date_transition;
    }
}
