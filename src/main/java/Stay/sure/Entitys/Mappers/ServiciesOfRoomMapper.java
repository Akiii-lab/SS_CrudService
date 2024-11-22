package Stay.sure.Entitys.Mappers;

import Stay.sure.Entitys.ServicesOfRoom;
import Stay.sure.Entitys.DTO.ServicesOfRoomDTO;

public class ServiciesOfRoomMapper {

    public static ServicesOfRoomDTO mapToDTO(Stay.sure.Entitys.ServicesOfRoom servicesOfRoom) {
        return new ServicesOfRoomDTO(
                servicesOfRoom.getId(),
                servicesOfRoom.getId_room(),
                servicesOfRoom.getId_service()
        );
    }

    public static ServicesOfRoom mapToEntity(ServicesOfRoomDTO servicesOfRoomDTO) {
        return new ServicesOfRoom(
                servicesOfRoomDTO.id,
                servicesOfRoomDTO.id_room,
                servicesOfRoomDTO.id_service
        );
    }
}
