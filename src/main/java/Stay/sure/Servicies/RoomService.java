package Stay.sure.Servicies;

import org.springframework.beans.factory.annotation.Autowired;

import Stay.sure.Entitys.Room;
import Stay.sure.Entitys.DAO.RoomDao;
import Stay.sure.Entitys.DTO.RoomDTO;
import Stay.sure.Entitys.Mappers.RoomMapper;

public class RoomService {

    @Autowired
    private RoomDao roomDao;
    
    public RoomService(RoomDao roomDao){
        this.roomDao = roomDao;
    }

    public RoomDTO findById(Long id) {
        Room room = roomDao.findById(id);
        if(room != null) {
            return RoomMapper.mapToDTO(room);
        }
        return null;
    }

    public RoomDTO save(RoomDTO room) {
        Room newRoom = RoomMapper.mapToEntity(room);
        Room saveRoom = roomDao.save(newRoom);
        if(saveRoom != null) {
            return RoomMapper.mapToDTO(saveRoom);
        }
        return null;
    }

    public RoomDTO update(RoomDTO room) {
        Room newRoom = RoomMapper.mapToEntity(room);
        Room saveRoom = roomDao.update(newRoom);
        if(saveRoom != null) {
            return RoomMapper.mapToDTO(saveRoom);
        }
        return null;
    }

    public RoomDTO delete(Long id) {
        return delete(id);
    }

    //cambiar dao para buscar por lugar tamañp e id_lessee

}
