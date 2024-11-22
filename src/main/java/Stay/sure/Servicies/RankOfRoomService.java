package Stay.sure.Servicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Stay.sure.Entitys.RankOfRoom;
import Stay.sure.Entitys.DAO.RankOfRoomDao;
import Stay.sure.Entitys.DTO.RankOfRoomDTO;
import Stay.sure.Entitys.Mappers.RankOfRoomMappers;

@Service
public class RankOfRoomService {

    @Autowired
    private RankOfRoomDao rankOfRoomDao;

    public RankOfRoomService(RankOfRoomDao rankOfRoomDao) {
        this.rankOfRoomDao = rankOfRoomDao;
    }

    public boolean delete(Long id) {
        return rankOfRoomDao.delete(id);
    }

    public RankOfRoomDTO save(RankOfRoomDTO rankOfRoom) {
        RankOfRoom new_RankOfRoom = rankOfRoomDao.save(RankOfRoomMappers.mapToEntity(rankOfRoom));
        if (new_RankOfRoom != null) {
            return RankOfRoomMappers.mapToDTO(new_RankOfRoom);
        }
        return null;
    }

    public RankOfRoomDTO update(RankOfRoomDTO rankOfRoom) {
        RankOfRoom new_RankOfRoom = rankOfRoomDao.update(RankOfRoomMappers.mapToEntity(rankOfRoom));
        if (new_RankOfRoom != null) {
            return RankOfRoomMappers.mapToDTO(new_RankOfRoom);
        }
        return null;
    }

    public RankOfRoomDTO findById(Long id) {
        RankOfRoom rankOfRoom = rankOfRoomDao.findById(id);
        if (rankOfRoom != null) {
            return RankOfRoomMappers.mapToDTO(rankOfRoom);
        }
        return null;
    }

    //hacer dao para buscar por id_room, id_rank y idChecker

}
