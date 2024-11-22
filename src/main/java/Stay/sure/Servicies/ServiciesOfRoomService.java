package Stay.sure.Servicies;

import org.springframework.beans.factory.annotation.Autowired;

import Stay.sure.Entitys.ServicesOfRoom;
import Stay.sure.Entitys.DAO.ServicesOfRoomDao;
import Stay.sure.Entitys.DTO.ServicesOfRoomDTO;
import Stay.sure.Entitys.Mappers.ServiciesOfRoomMapper;

public class ServiciesOfRoomService {
    
    @Autowired
    private ServicesOfRoomDao servicesOfRoomDao;

    public ServiciesOfRoomService(ServicesOfRoomDao servicesOfRoomDao) {
        this.servicesOfRoomDao = servicesOfRoomDao;
    }

    public ServicesOfRoomDTO save(ServicesOfRoomDTO data) {
        ServicesOfRoom neew = ServiciesOfRoomMapper.mapToEntity(data);
        ServicesOfRoom res = servicesOfRoomDao.save(neew);
        if(res != null) return ServiciesOfRoomMapper.mapToDTO(res);
        return null;
    }

    public ServicesOfRoomDTO update(ServicesOfRoomDTO data) {
        ServicesOfRoom neew = ServiciesOfRoomMapper.mapToEntity(data);
        ServicesOfRoom res = servicesOfRoomDao.update(neew);
        if(res != null) return ServiciesOfRoomMapper.mapToDTO(res);
        return null;
    }

    public ServicesOfRoomDTO findById(Long id) {
        ServicesOfRoom res = servicesOfRoomDao.findById(id);
        if(res != null) return ServiciesOfRoomMapper.mapToDTO(res);
        return null;
    }

    public boolean delete(Long id) {
        return servicesOfRoomDao.delete(id);
    }

    //falta service por id room y service
}
