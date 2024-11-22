package Stay.sure.Servicies;

import java.util.ArrayList;

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


    public ArrayList<ServicesOfRoomDTO> findByIdRoom(Long id) {
        ArrayList<ServicesOfRoom> res = servicesOfRoomDao.findByIdRoom(id);
        if(res != null) return new ArrayList<ServicesOfRoomDTO>(res.stream().map(ServiciesOfRoomMapper::mapToDTO).toList());
        return null;
    }

    public ArrayList<ServicesOfRoomDTO> findByIDService(Long id) {
        ArrayList<ServicesOfRoom> res = servicesOfRoomDao.findByIDService(id);
        if(res != null) return new ArrayList<ServicesOfRoomDTO>(res.stream().map(ServiciesOfRoomMapper::mapToDTO).toList());
        return null;
    }
}
