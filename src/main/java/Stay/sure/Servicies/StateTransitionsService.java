package Stay.sure.Servicies;

import java.util.ArrayList;
import java.util.Date;

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
        if (res != null)
            return StateTransitionsMapper.mapToDTO(res);
        return null;
    }

    public StateTransitionsDTO update(StateTransitionsDTO stateTransitionsDTO) {
        StateTransitions neew = StateTransitionsMapper.mapToEntity(stateTransitionsDTO);
        StateTransitions res = stateTransitionsDao.update(neew);
        if (res != null)
            return StateTransitionsMapper.mapToDTO(res);
        return null;
    }

    public StateTransitionsDTO findById(Long id) {
        StateTransitions res = stateTransitionsDao.findById(id);
        if (res != null)
            return StateTransitionsMapper.mapToDTO(res);
        return null;
    }

    public boolean delete(Long id) {
        return stateTransitionsDao.delete(id);
    }

    public ArrayList<StateTransitionsDTO> findByState(Long id) {
        ArrayList<StateTransitions> res = stateTransitionsDao.findByIdState(id);
        if (res != null)
            return new ArrayList<StateTransitionsDTO>(res.stream().map(StateTransitionsMapper::mapToDTO).toList());
        return null;
    }

    public ArrayList<StateTransitionsDTO> findByStockpile(Long id) {
        ArrayList<StateTransitions> res = stateTransitionsDao.findByIdStockpile(id);
        if (res != null)
            return new ArrayList<StateTransitionsDTO>(res.stream().map(StateTransitionsMapper::mapToDTO).toList());
        return null;
    }

    public ArrayList<StateTransitionsDTO> findByDate(Date date) {
        ArrayList<StateTransitions> res = stateTransitionsDao.findByDate(date);
        if (res != null)
            return new ArrayList<StateTransitionsDTO>(res.stream().map(StateTransitionsMapper::mapToDTO).toList());
        return null;
    }
}
