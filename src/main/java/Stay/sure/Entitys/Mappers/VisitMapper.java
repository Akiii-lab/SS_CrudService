package Stay.sure.Entitys.Mappers;

import Stay.sure.Entitys.Visit;
import Stay.sure.Entitys.DTO.VisitDTO;

public class VisitMapper {
    
    public static VisitDTO mapToDTO(Visit visit) {
        return new VisitDTO(visit.getId(), visit.getId_checker(), visit.getId_room());
    }

    public static Visit mapToEntity(VisitDTO visitDTO) {
        return new Visit(
            visitDTO.id, 
            visitDTO.id_checker, 
            visitDTO.id_room);
    }
}
