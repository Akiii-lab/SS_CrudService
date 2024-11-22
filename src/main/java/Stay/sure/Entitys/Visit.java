package Stay.sure.Entitys;

public class Visit {
    private Long id;
    private Long id_checker;
    private Long id_room;

    
    public Visit(Long id, Long id_checker, Long id_room) {
        this.id = id;
        this.id_checker = id_checker;
        this.id_room = id_room;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId_checker() {
        return id_checker;
    }
    public void setId_checker(Long id_checker) {
        this.id_checker = id_checker;
    }
    public Long getId_room() {
        return id_room;
    }
    public void setId_room(Long id_room) {
        this.id_room = id_room;
    }

    
}
