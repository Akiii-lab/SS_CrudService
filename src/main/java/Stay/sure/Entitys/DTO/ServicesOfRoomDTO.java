package Stay.sure.Entitys.DTO;

public class ServicesOfRoomDTO {
    public Long id;
    public Long id_room;
    public Long id_service;

    public ServicesOfRoomDTO(Long id, Long id_room, Long id_service) {
        this.id = id;
        this.id_room = id_room;
        this.id_service = id_service;
    }
}