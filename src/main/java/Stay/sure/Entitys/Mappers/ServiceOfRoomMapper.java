package Stay.sure.Entitys.Mappers;

import Stay.sure.Entitys.ServiceOfRoom;
import Stay.sure.Entitys.DTO.ServiceOfRoomDTO;

public class ServiceOfRoomMapper {

    public static ServiceOfRoomDTO mapToDTO(ServiceOfRoom serviceOfRoom) {
        return new ServiceOfRoomDTO(
            serviceOfRoom.getId(), 
            serviceOfRoom.getName()
        );
    }
    public static ServiceOfRoom mapToEntity(ServiceOfRoomDTO serviceOfRoomDTO) {
        return new ServiceOfRoom(
                serviceOfRoomDTO.id,
                serviceOfRoomDTO.name
        );
    }
}
