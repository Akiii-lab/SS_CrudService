package Stay.sure.Entitys.Mappers;

import Stay.sure.Entitys.Room;
import Stay.sure.Entitys.DTO.RoomDTO;

public class RoomMapper {


    public static RoomDTO mapToDTO(Room room) {
        return new RoomDTO(
                room.getId(),
                room.getLugar(),
                room.getTamaño(),    
                room.getId_Lesse()
        );
    }

    public static Room mapToEntity(RoomDTO roomDTO) {
        return new Room(
                roomDTO.id,
                roomDTO.lugar,
                roomDTO.tamaño,
                roomDTO.id_Lesse
        );
    }
}
