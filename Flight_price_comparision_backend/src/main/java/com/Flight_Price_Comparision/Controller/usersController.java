package com.Flight_Price_Comparision.Controller;
import com.Flight_Price_Comparision.Model.entity.users;
import com.Flight_Price_Comparision.Service.usersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/users")
public class usersController {
    private final usersService usersService;
    public usersController(usersService usersService) {
        this.usersService = usersService;
    }
    @PostMapping
    public users createUser(@RequestBody users user) {
        return usersService.createUser(user);
    }
    @GetMapping
    public List<users> getAllUsers() {
        return usersService.getAllUsers();
    }
    @GetMapping("/{id}")
    public ResponseEntity<users> getUserById(@PathVariable Long id) {
        return usersService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/email/{email}")
    public ResponseEntity<users> getUserByEmail(@PathVariable String email) {
        return usersService.getUserByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        usersService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}