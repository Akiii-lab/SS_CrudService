package Stay.sure.Servicies;

import java.util.ArrayList;

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
        if (res != null)
            return VisitMapper.mapToDTO(res);
        return null;
    }

    public VisitDTO update(VisitDTO visitDTO) {
        Visit neew = VisitMapper.mapToEntity(visitDTO);
        Visit res = visitDao.update(neew);
        if (res != null)
            return VisitMapper.mapToDTO(res);
        return null;
    }

    public VisitDTO findById(Long id) {
        Visit res = visitDao.findById(id);
        if (res != null)
            return VisitMapper.mapToDTO(res);
        return null;
    }

    public boolean delete(Long id) {
        return visitDao.delete(id);
    }

    public ArrayList<VisitDTO> findByChecker(Long id_checker) {
        ArrayList<Visit> res = visitDao.findByChecker(id_checker);
        if (res != null)
            return new ArrayList<VisitDTO>(res.stream().map(VisitMapper::mapToDTO).toList());
        return null;
    }

    public ArrayList<VisitDTO> findByRoom(Long id_room) {
        ArrayList<Visit> res = visitDao.findByRoom(id_room);
        if (res != null)
            return new ArrayList<VisitDTO>(res.stream().map(VisitMapper::mapToDTO).toList());
        return null;
    }
}
