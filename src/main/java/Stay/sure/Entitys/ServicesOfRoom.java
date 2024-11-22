package Stay.sure.Entitys;

public class ServicesOfRoom {
    private Long id;
    private Long id_room;
    private Long id_service;

    public ServicesOfRoom(Long id, Long id_room, Long id_service) {
        this.id = id;
        this.id_room = id_room;
        this.id_service = id_service;
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
    public Long getId_service() {
        return id_service;
    }
    public void setId_service(Long id_service) {
        this.id_service = id_service;
    }

}