package Stay.sure.Controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Stay.sure.Entitys.DTO.StockPileDTO;
import Stay.sure.Servicies.StockPileService;

@RestController
@RequestMapping("/api/stockpile")
public class StockPileController {

    @Autowired
    private StockPileService stockPileService;

    @PostMapping("/save")
    public ResponseEntity<HashMap<String, Object>> save( StockPileDTO stockPile) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        StockPileDTO savedStockPile = stockPileService.save(stockPile);
        if (savedStockPile != null) {
            result.put("stockPile", savedStockPile);
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/update")
    public ResponseEntity<HashMap<String, Object>> update(StockPileDTO stockPile) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        StockPileDTO updatedStockPile = stockPileService.update(stockPile);
        if (updatedStockPile != null) {
            result.put("stockPile", updatedStockPile);
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<HashMap<String, Object>> findById(Long id) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        StockPileDTO foundStockPile = stockPileService.findById(id);
        if (foundStockPile != null) {
            result.put("stockPile", foundStockPile);
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
}
