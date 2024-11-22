package Stay.sure.Servicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Stay.sure.Entitys.Visit;
import Stay.sure.Entitys.DAO.VisitDao;
import Stay.sure.Entitys.DTO.VisitDTO;
import Stay.sure.Entitys.Mappers.VisitMapper;

@Service
public class VisitService {

    @Autowired
    private VisitDao visitDao;

    public VisitService(VisitDao visitDao) {
        this.visitDao = visitDao;
    }

    public VisitDTO save(VisitDTO visitDTO) {
        Visit neew = VisitMapper.mapToEntity(visitDTO);
        Visit res = visitDao.save(neew);        
        if(res != null) return VisitMapper.mapToDTO(res);
        return null;        
    }

    public VisitDTO update(VisitDTO visitDTO) {
        Visit neew = VisitMapper.mapToEntity(visitDTO);
        Visit res = visitDao.update(neew);        
        if(res != null) return VisitMapper.mapToDTO(res);
        return null;        
    }

    public VisitDTO findById(Long id) {
        Visit res = visitDao.findById(id);        
        if(res != null) return VisitMapper.mapToDTO(res);
        return null;        
    }

    public boolean delete(Long id) {
        return visitDao.delete(id);        
    }

    // cambiar dao para id_checker y id_room
}
