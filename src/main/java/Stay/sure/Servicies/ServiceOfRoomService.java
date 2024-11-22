package Stay.sure.Servicies;

import org.springframework.beans.factory.annotation.Autowired;

import Stay.sure.Entitys.ServiceOfRoom;
import Stay.sure.Entitys.DAO.ServiceOfRoomDao;
import Stay.sure.Entitys.DTO.ServiceOfRoomDTO;
import Stay.sure.Entitys.Mappers.ServiceOfRoomMapper;

public class ServiceOfRoomService {

    @Autowired
    private ServiceOfRoomDao serviceOfRoomDao;
    
    public ServiceOfRoomService(ServiceOfRoomDao serviceOfRoomDao) {
        this.serviceOfRoomDao = serviceOfRoomDao;
    }

    public ServiceOfRoomDTO save(ServiceOfRoomDTO data) {
        ServiceOfRoom neew = ServiceOfRoomMapper.mapToEntity(data);
        ServiceOfRoom res = serviceOfRoomDao.save(neew);
        if(res != null) return ServiceOfRoomMapper.mapToDTO(res);
        return null;
    }

    public ServiceOfRoomDTO update(ServiceOfRoomDTO data) {
        ServiceOfRoom neew = ServiceOfRoomMapper.mapToEntity(data);
        ServiceOfRoom res = serviceOfRoomDao.update(neew);
        if(res != null) return ServiceOfRoomMapper.mapToDTO(res);
        return null;
    }

    public boolean delete(Long id) {
        return serviceOfRoomDao.delete(id);
    }

    public ServiceOfRoomDTO findById(Long id) {
        ServiceOfRoom res = serviceOfRoomDao.findById(id);
        if(res != null) return ServiceOfRoomMapper.mapToDTO(res);
        return null;
    }

    public ServiceOfRoomDTO findByName(String name) {
        ServiceOfRoom res = serviceOfRoomDao.findByName(name);
        if(res != null) return ServiceOfRoomMapper.mapToDTO(res);
        return null;
    }
}
