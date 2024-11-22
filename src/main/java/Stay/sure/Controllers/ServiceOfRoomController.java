package Stay.sure.Controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Stay.sure.Entitys.DTO.ServiceOfRoomDTO;
import Stay.sure.Servicies.ServiceOfRoomService;

@RestController
@RequestMapping("/api/serviceOfRoom")
public class ServiceOfRoomController {

    @Autowired
    ServiceOfRoomService serviceOfRoomService;

    @PostMapping("/save")
    public ResponseEntity<HashMap<String, Object>> save(ServiceOfRoomDTO data) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        ServiceOfRoomDTO savedServiceOfRoom = serviceOfRoomService.save(data);
        if (savedServiceOfRoom != null) {
            result.put("serviceOfRoom", savedServiceOfRoom);
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/update")
    public ResponseEntity<HashMap<String, Object>> update(ServiceOfRoomDTO data) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        ServiceOfRoomDTO updatedServiceOfRoom = serviceOfRoomService.update(data);
        if (updatedServiceOfRoom != null) {
            result.put("serviceOfRoom", updatedServiceOfRoom);
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<HashMap<String, Object>> findById(Long id) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        ServiceOfRoomDTO foundServiceOfRoom = serviceOfRoomService.findById(id);
        if (foundServiceOfRoom != null) {
            result.put("serviceOfRoom", foundServiceOfRoom);
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/find/{name}")
    public ResponseEntity<HashMap<String, Object>> findByName(String name) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        ServiceOfRoomDTO foundServiceOfRoom = serviceOfRoomService.findByName(name);
        if (foundServiceOfRoom != null) {
            result.put("serviceOfRoom", foundServiceOfRoom);
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
}
