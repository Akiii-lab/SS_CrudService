package Stay.sure.Servicies;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

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
        if (res != null)
            return StockPileMapper.mapToDTO(res);
        return null;
    }

    public StockPileDTO update(StockPileDTO stockPileDTO) {
        StockPile neew = StockPileMapper.mapToEntity(stockPileDTO);
        StockPile res = stockPileDao.update(neew);
        if (res != null)
            return StockPileMapper.mapToDTO(res);
        return null;
    }

    public StockPileDTO findById(Long id) {
        StockPile res = stockPileDao.findById(id);
        if (res != null)
            return StockPileMapper.mapToDTO(res);
        return null;
    }

    public boolean delete(Long id) {
        return stockPileDao.delete(id);
    }

    public ArrayList<StockPileDTO> findByIdRoom(Long id_room) {
        ArrayList<StockPile> res = stockPileDao.findByIdRoom(id_room);
        if (res != null)
            return new ArrayList<StockPileDTO>(res.stream().map(StockPileMapper::mapToDTO).toList());
        return null;
    }

    public ArrayList<StockPileDTO> findByUser(Long id_user) {
        ArrayList<StockPile> res = stockPileDao.findByUser(id_user);
        if (res != null)
            return new ArrayList<StockPileDTO>(res.stream().map(StockPileMapper::mapToDTO).toList());
        return null;
    }

    public ArrayList<StockPileDTO> findByDate(String date) {
        try {
            ArrayList<StockPile> res = stockPileDao.findByDate(DateFormat.getDateInstance().parse(date));
            if (res != null)
                return new ArrayList<StockPileDTO>(res.stream().map(StockPileMapper::mapToDTO).toList());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
