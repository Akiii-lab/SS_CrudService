package Stay.sure.Servicies;



import org.springframework.beans.factory.annotation.Autowired;

import Stay.sure.Entitys.State;
import Stay.sure.Entitys.DAO.StateDao;
import Stay.sure.Entitys.DTO.StateDTO;
import Stay.sure.Entitys.Mappers.StateMapper;

public class StateService {

    @Autowired
    private StateDao stateDao;

    public StateService(StateDao stateDao) {
        this.stateDao = stateDao;
    }

    public StateDTO save(StateDTO stateDTO) {
        State neew = StateMapper.mapToEntity(stateDTO);
        State res = stateDao.save(neew);
        if(res != null) return StateMapper.mapToDTO(res);
        return null;
    }

    public StateDTO update(StateDTO stateDTO) {
        State neew = StateMapper.mapToEntity(stateDTO);
        State res = stateDao.update(neew);
        if(res != null) return StateMapper.mapToDTO(res);
        return null;
    }

    public StateDTO findById(Long id) {
        State res = stateDao.findById(id);
        if(res != null) return StateMapper.mapToDTO(res);
        return null;
    }

    public boolean delete(Long id) {
        return stateDao.delete(id);
    }

    public StateDTO findByName(String name) {
        State res = stateDao.findByName(name);
        if(res != null) return StateMapper.mapToDTO(res);
        return null;
    }
}
