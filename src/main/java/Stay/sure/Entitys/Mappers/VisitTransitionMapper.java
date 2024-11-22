package Stay.sure.Entitys.Mappers;

import Stay.sure.Entitys.VisitTransition;
import Stay.sure.Entitys.DTO.VisitTransitionDTO;

public class VisitTransitionMapper {

    public static VisitTransition mapToEntity(VisitTransitionDTO visitTransitionDTO) {
        return new VisitTransition(
                visitTransitionDTO.id,
                visitTransitionDTO.id_visit,
                visitTransitionDTO.id_visitState,
                visitTransitionDTO.date
        );
    }

    public static VisitTransitionDTO mapToDTO(VisitTransition visitTransition) {
        return new VisitTransitionDTO(
                visitTransition.getId(),
                visitTransition.getId_visit(),
                visitTransition.getId_visitState(),
                visitTransition.getDate()
        );
    }
}
