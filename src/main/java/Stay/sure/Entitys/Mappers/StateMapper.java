package Stay.sure.Entitys.Mappers;

import Stay.sure.Entitys.State;
import Stay.sure.Entitys.DTO.StateDTO;

public class StateMapper {

    public static StateDTO mapToDTO(State state) {
        return new StateDTO(
                state.getId(),
                state.getState()
        );
    }

    public static State mapToEntity(StateDTO stateDTO) {
        return new State(
                stateDTO.id,
                stateDTO.state
        );
    }
}
