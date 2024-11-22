package Stay.sure.Servicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Stay.sure.Entitys.StockPile;
import Stay.sure.Entitys.DAO.StockPileDao;
import Stay.sure.Entitys.DTO.StockPileDTO;
import Stay.sure.Entitys.Mappers.StockPileMapper;
@Service
public class StockPileService {

    @Autowired
    private StockPileDao stockPileDao;

    public StockPileService(StockPileDao stockPileDao) {
        this.stockPileDao = stockPileDao;
    }

    public StockPileDTO save(StockPileDTO stockPileDTO) {
        StockPile neew = StockPileMapper.mapToEntity(stockPileDTO);
        StockPile res = stockPileDao.save(neew);
        if(res != null) return StockPileMapper.mapToDTO(res);
        return null;        
    }

    public StockPileDTO update(StockPileDTO stockPileDTO) {
        StockPile neew = StockPileMapper.mapToEntity(stockPileDTO);
        StockPile res = stockPileDao.update(neew);
        if(res != null) return StockPileMapper.mapToDTO(res);
        return null;        
    }

    public StockPileDTO findById(Long id) {
        StockPile res = stockPileDao.findById(id);
        if(res != null) return StockPileMapper.mapToDTO(res);
        return null;        
    }

    public boolean delete(Long id) {
        return stockPileDao.delete(id);
    }

    // cambiar dao para id_room , user, y date_stockpile
}
