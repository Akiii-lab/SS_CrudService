package Stay.sure.Entitys.DTO;

public class VisitDTO {
    public Long id;
    public Long id_checker;
    public Long id_room;

    
    public VisitDTO(Long id, Long id_checker, Long id_room) {
        this.id = id;
        this.id_checker = id_checker;
        this.id_room = id_room;
    }
}
