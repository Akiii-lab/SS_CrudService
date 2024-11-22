package Stay.sure.Entitys.DTO;

public class RankOfRoomDTO {
    public Long id;
    public Long id_room;
    public Long id_rank;
    public Long idChecker;
    
    public RankOfRoomDTO(Long id, Long id_room, Long id_rank, Long idChecker) {
        this.id = id;
        this.id_room = id_room;
        this.id_rank = id_rank;
        this.idChecker = idChecker;
    }
}
