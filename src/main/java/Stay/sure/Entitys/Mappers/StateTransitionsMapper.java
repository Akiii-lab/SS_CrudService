package Stay.sure.Entitys.Mappers;

import Stay.sure.Entitys.StateTransitions;
import Stay.sure.Entitys.DTO.StateTransitionsDTO;

public class StateTransitionsMapper {

    public static StateTransitions mapToEntity(StateTransitionsDTO stateTransitionsDTO) {
        return new StateTransitions(
                stateTransitionsDTO.id,
                stateTransitionsDTO.id_State,
                stateTransitionsDTO.id_StockPile,
                stateTransitionsDTO.date_transition
        );
    }

    public static StateTransitionsDTO mapToDTO(StateTransitions stateTransitions) {
        return new StateTransitionsDTO(
                stateTransitions.getId(),
                stateTransitions.getId_State(),
                stateTransitions.getId_StockPile(),
                stateTransitions.getDate_transition()
        );
    }
}
