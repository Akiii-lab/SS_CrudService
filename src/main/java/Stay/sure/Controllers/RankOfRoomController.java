package Stay.sure.Controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Stay.sure.Entitys.DTO.RankOfRoomDTO;
import Stay.sure.Servicies.RankOfRoomService;

@RestController
@RequestMapping("/api/rankOfRoom")
public class RankOfRoomController {

    @Autowired
    private RankOfRoomService rankOfRoomService;

    @PostMapping("/save")
    public ResponseEntity<HashMap<String, Object>> save(RankOfRoomDTO rankOfRoom) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        RankOfRoomDTO savedRankOfRoom = rankOfRoomService.save(rankOfRoom);
        if (savedRankOfRoom != null) {
            result.put("rankOfRoom", savedRankOfRoom);
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/update")
    public ResponseEntity<HashMap<String, Object>> update(RankOfRoomDTO rankOfRoom) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        RankOfRoomDTO updatedRankOfRoom = rankOfRoomService.update(rankOfRoom);
        if (updatedRankOfRoom != null) {
            result.put("rankOfRoom", updatedRankOfRoom);
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<HashMap<String, Object>> findById(Long id) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        RankOfRoomDTO foundRankOfRoom = rankOfRoomService.findById(id);
        if (foundRankOfRoom != null) {
            result.put("rankOfRoom", foundRankOfRoom);
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
}
