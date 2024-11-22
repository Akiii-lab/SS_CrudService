package Stay.sure.Entitys;

public class RankOfRoom {
    private Long id;
    private Long id_room;
    private Long id_rank;
    private Long idChecker;
    
    public RankOfRoom(Long id, Long id_room, Long id_rank, Long idChecker) {
        this.id = id;
        this.id_room = id_room;
        this.id_rank = id_rank;
        this.idChecker = idChecker;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId_room() {
        return id_room;
    }
    public void setId_room(Long id_room) {
        this.id_room = id_room;
    }
    public Long getId_rank() {
        return id_rank;
    }
    public void setId_rank(Long id_rank) {
        this.id_rank = id_rank;
    }
    public Long getIdChecker() {
        return idChecker;
    }
    public void setIdChecker(Long idChecker) {
        this.idChecker = idChecker;
    }

    
}
