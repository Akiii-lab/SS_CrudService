package Stay.sure.Controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Stay.sure.Entitys.DTO.StateDTO;
import Stay.sure.Servicies.StateService;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api/state")
public class StateController {

    @Autowired
    private StateService stateService;

    @PostMapping("/save")
    public ResponseEntity<HashMap<String, Object>> save(StateDTO state) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        StateDTO savedState = stateService.save(state);
        if (savedState != null) {
            result.put("state", savedState);
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/update")
    public ResponseEntity<HashMap<String, Object>> update(StateDTO state) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        StateDTO updatedState = stateService.update(state);
        if (updatedState != null) {
            result.put("state", updatedState);
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/find/{id}")
    public ResponseEntity<HashMap<String, Object>> findById(Long id) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        StateDTO foundState = stateService.findById(id);
        if (foundState != null) {
            result.put("state", foundState);
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/find/{name}")
    public ResponseEntity<HashMap<String, Object>> findByName(String name) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        StateDTO foundState = stateService.findByName(name);
        if (foundState != null) {
            result.put("state", foundState);
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

}
