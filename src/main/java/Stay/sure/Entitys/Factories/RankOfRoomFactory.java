package Stay.sure.Entitys.Factories;

import Stay.sure.Entitys.RankOfRoom;

public class RankOfRoomFactory {

    public static RankOfRoom createRankOfRoom(Long id, Long id_room, Long id_rank, Long idChecker) {
        return new RankOfRoom(id, id_room, id_rank, idChecker);
    }
}
