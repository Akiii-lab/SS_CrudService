package Stay.sure.Servicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Stay.sure.Entitys.VisitState;
import Stay.sure.Entitys.DAO.VisitStateDao;
import Stay.sure.Entitys.DTO.VisitStateDTO;
import Stay.sure.Entitys.Mappers.VisitStateMapper;

@Service
public class VisitStateService {
    @Autowired
    private VisitStateDao visitStateDao;
    
    public VisitStateService(VisitStateDao visitStateDao) {
        this.visitStateDao = visitStateDao;
    }
    
    public VisitStateDTO save(VisitStateDTO visitState) {
        VisitState visitStateEntity = VisitStateMapper.mapToEntity(visitState);
        VisitState savedVisitState = visitStateDao.save(visitStateEntity);
        if(savedVisitState != null) {
            return VisitStateMapper.mapToDTO(savedVisitState);
        }
        return null;
    }

    public VisitStateDTO update(VisitStateDTO visitState) {
        VisitState visitStateEntity = VisitStateMapper.mapToEntity(visitState);
        VisitState updatedVisitState = visitStateDao.update(visitStateEntity);
        if(updatedVisitState != null) {
            return VisitStateMapper.mapToDTO(updatedVisitState);
        }
        return null;
    }

    public VisitStateDTO findById(Long id) {
        VisitState visitState = visitStateDao.findById(id);
        if(visitState != null) {
            return VisitStateMapper.mapToDTO(visitState);
        }
        return null;
    }

    public boolean delete(Long id) {
        return visitStateDao.delete(id);
    }

    public VisitStateDTO findByName(String name) {
        VisitState visitState = visitStateDao.findByName(name);
        if(visitState != null) {
            return VisitStateMapper.mapToDTO(visitState);
        }
        return null;
    }
}
