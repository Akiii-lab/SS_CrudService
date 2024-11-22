package Stay.sure.Entitys.Mappers;

import Stay.sure.Entitys.RankOfRoom;
import Stay.sure.Entitys.DTO.RankOfRoomDTO;

public class RankOfRoomMappers {

    public static RankOfRoomDTO mapToDTO(RankOfRoom rankOfRoom) {
        return new RankOfRoomDTO(
                rankOfRoom.getId(),
                rankOfRoom.getId_room(),
                rankOfRoom.getId_rank(),
                rankOfRoom.getIdChecker()
        );
    }

    public static RankOfRoom mapToEntity(RankOfRoomDTO rankOfRoomDTO) {
        return new RankOfRoom(
                rankOfRoomDTO.id,
                rankOfRoomDTO.id_room,
                rankOfRoomDTO.id_rank,
                rankOfRoomDTO.idChecker
        );
    }
}
