package Stay.sure.Controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import Stay.sure.Entitys.DTO.RankDTO;
import Stay.sure.Servicies.RankService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/api/rank")
public class RankController {
    @Autowired
    RankService rankService;
    
    @PostMapping("/save")
    public ResponseEntity<HashMap<String, Object>> save(@RequestBody RankDTO rank) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        RankDTO savedRank =  rankService.save(rank);
        if(savedRank != null) {
            result.put("rank", savedRank);
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/update")
    public ResponseEntity<HashMap<String, Object>> update(@RequestBody RankDTO rank) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        RankDTO updatedRank =  rankService.update(rank);
        if(updatedRank != null) {
            result.put("rank", updatedRank);
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/find/{name}")
    public ResponseEntity<HashMap<String, Object>> findByName(@PathVariable String name) {
    HashMap<String, Object> result = new HashMap<String, Object>();
    RankDTO foundRank =  rankService.findByName(name);
    if(foundRank != null) {
        result.put("rank", foundRank);
        return ResponseEntity.ok(result);
    }
    return ResponseEntity.badRequest().body(result);
    }
}
