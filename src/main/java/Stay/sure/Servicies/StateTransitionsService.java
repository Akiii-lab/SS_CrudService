package Stay.sure.Servicies;

import org.springframework.beans.factory.annotation.Autowired;

import Stay.sure.Entitys.StateTransitions;
import Stay.sure.Entitys.DAO.StateTransitionsDao;
import Stay.sure.Entitys.DTO.StateTransitionsDTO;
import Stay.sure.Entitys.Mappers.StateTransitionsMapper;

public class StateTransitionsService {

    @Autowired
    private StateTransitionsDao stateTransitionsDao;

    public StateTransitionsService(StateTransitionsDao stateTransitionsDao) {
        this.stateTransitionsDao = stateTransitionsDao;
    }

    public StateTransitionsDTO save(StateTransitionsDTO stateTransitionsDTO) {
        StateTransitions neew = StateTransitionsMapper.mapToEntity(stateTransitionsDTO);
        StateTransitions res = stateTransitionsDao.save(neew);
        if(res != null) return StateTransitionsMapper.mapToDTO(res);
        return null;        
    }

    public StateTransitionsDTO update(StateTransitionsDTO stateTransitionsDTO) {
        StateTransitions neew = StateTransitionsMapper.mapToEntity(stateTransitionsDTO);
        StateTransitions res = stateTransitionsDao.update(neew);
        if(res != null) return StateTransitionsMapper.mapToDTO(res);
        return null;        
    }

    public StateTransitionsDTO findById(Long id) {
        StateTransitions res = stateTransitionsDao.findById(id);
        if(res != null) return StateTransitionsMapper.mapToDTO(res);
        return null;        
    }

    public boolean delete(Long id) {
        return stateTransitionsDao.delete(id);
    }

    //cambiar dao or id_state , id_stockpile y date
}
