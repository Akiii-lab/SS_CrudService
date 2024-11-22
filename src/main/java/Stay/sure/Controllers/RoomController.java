package Stay.sure.Controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Stay.sure.Entitys.DTO.RoomDTO;
import Stay.sure.Servicies.RoomService;

@RestController
@RequestMapping("/api/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping("/save")
    public ResponseEntity<HashMap<String, Object>> save(RoomDTO room) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        RoomDTO savedRoom = roomService.save(room);
        if (savedRoom != null) {
            result.put("room", savedRoom);
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/update")
    public ResponseEntity<HashMap<String, Object>> update(RoomDTO room) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        RoomDTO updatedRoom = roomService.update(room);
        if (updatedRoom != null) {
            result.put("room", updatedRoom);
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<HashMap<String, Object>> findById(Long id) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        RoomDTO foundRoom = roomService.findById(id);
        if (foundRoom != null) {
            result.put("room", foundRoom);
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
}
