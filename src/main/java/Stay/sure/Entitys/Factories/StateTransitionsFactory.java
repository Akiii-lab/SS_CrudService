package Stay.sure.Entitys.Factories;

import java.util.Date;

import Stay.sure.Entitys.StateTransitions;

public class StateTransitionsFactory {

    public static StateTransitions createStateTransitions(Long id, Long id_State, Long id_StockPile, Date date_transition) {
        return new StateTransitions(id, id_State, id_StockPile, date_transition);
    }
}
