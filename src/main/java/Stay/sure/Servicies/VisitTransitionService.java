package Stay.sure.Servicies;

import java.util.ArrayList;
import java.util.Date;

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

    public ArrayList<VisitTransitionDTO> findById_visit(Long id_visit) {
        ArrayList<VisitTransition> visitTransitions = visitTransitionDao.findByIdVisit(id_visit);
        if(visitTransitions != null) {
            return new ArrayList<VisitTransitionDTO>(visitTransitions.stream().map(VisitTransitionMapper::mapToDTO).toList());
        }
        return null;
    }

    public ArrayList<VisitTransitionDTO> findById_visitState(Long id_visitState) {
        ArrayList<VisitTransition> visitTransitions = visitTransitionDao.findByIdVisitState(id_visitState);
        if(visitTransitions != null) {
            return new ArrayList<VisitTransitionDTO>(visitTransitions.stream().map(VisitTransitionMapper::mapToDTO).toList());
        }
        return null;
    }

    public ArrayList<VisitTransitionDTO> findByDate(Date date) {
        ArrayList<VisitTransition> visitTransitions = visitTransitionDao.findByDate(date);
        if(visitTransitions != null) {
            return new ArrayList<VisitTransitionDTO>(visitTransitions.stream().map(VisitTransitionMapper::mapToDTO).toList());
        }
        return null;
    }
}
