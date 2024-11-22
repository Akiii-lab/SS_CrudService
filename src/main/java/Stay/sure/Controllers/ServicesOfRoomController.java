package Stay.sure.Controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Stay.sure.Entitys.DTO.ServicesOfRoomDTO;
import Stay.sure.Servicies.ServiciesOfRoomService;

@RestController
@RequestMapping("/api/ServicesOfRoom")
public class ServicesOfRoomController {

    @Autowired
    private ServiciesOfRoomService servicesOfRoomService;

    @PostMapping("/save")
    public ResponseEntity<HashMap<String, Object>> save( ServicesOfRoomDTO data) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        ServicesOfRoomDTO savedServiceOfRoom = servicesOfRoomService.save(data);
        if (savedServiceOfRoom != null) {
            result.put("serviceOfRoom", savedServiceOfRoom);
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/update")
    public ResponseEntity<HashMap<String, Object>> update(ServicesOfRoomDTO data) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        ServicesOfRoomDTO updatedServiceOfRoom = servicesOfRoomService.update(data);
        if (updatedServiceOfRoom != null) {
            result.put("serviceOfRoom", updatedServiceOfRoom);
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/find/{id}")
    public ResponseEntity<HashMap<String, Object>> findById(Long id) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        ServicesOfRoomDTO foundServiceOfRoom = servicesOfRoomService.findById(id);
        if (foundServiceOfRoom != null) {
            result.put("serviceOfRoom", foundServiceOfRoom);
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
}
