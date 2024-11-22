package Stay.sure.Servicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Stay.sure.Entitys.Rank;
import Stay.sure.Entitys.DAO.RankDao;
import Stay.sure.Entitys.DTO.RankDTO;
import Stay.sure.Entitys.Mappers.RankMapper;

@Service
public class RankService {

    @Autowired
    private RankDao rankDao;
    
    public RankService(RankDao rankDao) {
        this.rankDao = rankDao;
    }

    public RankDTO save(RankDTO rank) {
        Rank newRank = RankMapper.mapToEntity(rank);
        Rank saveRank = rankDao.save(newRank);
        if(saveRank != null) {
            return RankMapper.mapToDTO(saveRank);
        }
        return null;
    }

    public RankDTO update(RankDTO rank) {
        Rank newRank = RankMapper.mapToEntity(rank);
        Rank saveRank = rankDao.update(newRank);
        if(saveRank != null) {
            return RankMapper.mapToDTO(saveRank);
        }
        return null;
    }

    public boolean delete(Long id) {
        return rankDao.delete(id);
    }

    public RankDTO findById(Long id) {
        Rank rank = rankDao.findById(id);
        if(rank != null) {
            return RankMapper.mapToDTO(rank);
        }
        return null;
    }

    public RankDTO findByName(String name) {
        Rank rank = rankDao.findByName(name);
        if(rank != null) {
            return RankMapper.mapToDTO(rank);
        }
        return null;
    }
}
