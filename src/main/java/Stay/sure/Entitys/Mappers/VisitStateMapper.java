package Stay.sure.Entitys.Mappers;

import Stay.sure.Entitys.VisitState;
import Stay.sure.Entitys.DTO.VisitStateDTO;

public class VisitStateMapper {

    public static VisitState mapToEntity(VisitStateDTO visitStateDTO) {
        return new VisitState(
                visitStateDTO.id,
                visitStateDTO.nombre
        );
    }

    public static VisitStateDTO mapToDTO(VisitState visitState) {
        return new VisitStateDTO(visitState.getId(), visitState.getNombre());
    }
}
