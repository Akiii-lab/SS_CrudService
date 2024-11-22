package Stay.sure.Servicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Stay.sure.Entitys.VisitTransition;
import Stay.sure.Entitys.DAO.VisitTransitionDao;
import Stay.sure.Entitys.DTO.VisitTransitionDTO;
import Stay.sure.Entitys.Mappers.VisitTransitionMapper;

@Service
public class VisitTransitionService {

    @Autowired
    VisitTransitionDao visitTransitionDao;

    public VisitTransitionService(VisitTransitionDao visitTransitionDao) {
        this.visitTransitionDao = visitTransitionDao;
    }

    public VisitTransitionDTO save(VisitTransitionDTO visitTransitionDTO) {
        VisitTransition visitTransition = VisitTransitionMapper.mapToEntity(visitTransitionDTO);
        VisitTransition savedVisitTransition = visitTransitionDao.save(visitTransition);
        if(savedVisitTransition != null) {
            return VisitTransitionMapper.mapToDTO(savedVisitTransition);
        }
        return null;
    }

    public VisitTransitionDTO findById(Long id) {
        VisitTransition visitTransition = visitTransitionDao.findById(id);
        if(visitTransition != null) {
            return VisitTransitionMapper.mapToDTO(visitTransition);
        }
        return null;
    }

    public VisitTransitionDTO update(VisitTransitionDTO visitTransitionDTO) {
        VisitTransition visitTransition = VisitTransitionMapper.mapToEntity(visitTransitionDTO);
        VisitTransition savedVisitTransition = visitTransitionDao.update(visitTransition);
        if(savedVisitTransition != null) {
            return VisitTransitionMapper.mapToDTO(savedVisitTransition);
        }
        return null;
    }

    public boolean delete(Long id) {
        return visitTransitionDao.delete(id);
    }

    //cambiar dao para id_visit, id_visitstate y date
}
