package Stay.sure.Entitys.DTO;

import java.util.Date;

public class VisitTransitionDTO {
    public Long id;
    public Long id_visit;
    public Long id_visitState;
    public Date date;
    
    public VisitTransitionDTO(Long id, Long id_visit, Long id_visitState, Date date) {
        this.id = id;
        this.id_visit = id_visit;
        this.id_visitState = id_visitState;
        this.date = date;
    }
}
