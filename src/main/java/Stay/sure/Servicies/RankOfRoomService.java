package Stay.sure.Servicies;

import java.util.ArrayList;

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

    public ArrayList<RankOfRoomDTO> findByIds(Long id_room, Long id_checker, Long id_rank) {
        ArrayList<RankOfRoom> res = rankOfRoomDao.findByIds(id_room, id_checker, id_rank);
        if (res != null)
            return new ArrayList<RankOfRoomDTO>(res.stream().map(RankOfRoomMappers::mapToDTO).toList());
        return null;
    }

    public ArrayList<RankOfRoomDTO> findByIdRoom(Long id_room) {
        ArrayList<RankOfRoom> res = rankOfRoomDao.findByIdRoom(id_room);
        if (res != null)
            return new ArrayList<RankOfRoomDTO>(res.stream().map(RankOfRoomMappers::mapToDTO).toList());
        return null;
    }

    public ArrayList<RankOfRoomDTO> findByIdChecker(Long id_checker) {
        ArrayList<RankOfRoom> res = rankOfRoomDao.findByIdChecker(id_checker);
        if (res != null)
            return new ArrayList<RankOfRoomDTO>(res.stream().map(RankOfRoomMappers::mapToDTO).toList());
        return null;
    }

    public ArrayList<RankOfRoomDTO> findByIdRank(Long id_rank) {
        ArrayList<RankOfRoom> res = rankOfRoomDao.findByIdRank(id_rank);
        if (res != null)
            return new ArrayList<RankOfRoomDTO>(res.stream().map(RankOfRoomMappers::mapToDTO).toList());
        return null;
    }

}
