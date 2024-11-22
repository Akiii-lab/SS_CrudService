package Stay.sure.Entitys;

import java.util.Date;

public class StateTransitions {

    private Long id;
    private Long id_State;
    private Long id_StockPile;
    private Date date_transition;

    public StateTransitions(Long id, Long id_State, Long id_StockPile, Date date_transition) {
        this.id = id;
        this.id_State = id_State;
        this.id_StockPile = id_StockPile;
        this.date_transition = date_transition;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId_State() {
        return id_State;
    }
    public void setId_State(Long id_State) {
        this.id_State = id_State;
    }
    public Long getId_StockPile() {
        return id_StockPile;
    }
    public void setId_StockPile(Long id_StockPile) {
        this.id_StockPile = id_StockPile;
    }
    public Date getDate_transition() {
        return date_transition;
    }
    public void setDate_transition(Date date_transition) {
        this.date_transition = date_transition;
    }
}
