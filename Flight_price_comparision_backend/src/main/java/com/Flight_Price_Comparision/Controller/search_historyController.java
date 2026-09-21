package com.Flight_Price_Comparision.Controller;
import com.Flight_Price_Comparision.Model.entity.search_history;
import com.Flight_Price_Comparision.Service.search_historyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/search-history")
public class search_historyController {
    private final search_historyService search_historyService;
    public search_historyController(search_historyService search_historyService) {
        this.search_historyService = search_historyService;
    }
    @PostMapping
    public search_history createSearchHistory(
            @RequestBody search_history searchHistory) {
        return search_historyService.createSearchHistory(searchHistory);
    }
    @GetMapping
    public List<search_history> getAllSearchHistory() {

        return search_historyService.getAllSearchHistory();
    }
    @GetMapping("/{id}")
    public ResponseEntity<search_history> getSearchHistoryById(
            @PathVariable Long id) {
        return search_historyService.getSearchHistoryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/user/{userId}")
    public List<search_history> getSearchHistoryByUserId(
            @PathVariable Long userId) {

        return search_historyService.getSearchHistoryByUserId(userId);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSearchHistory(
            @PathVariable Long id) {

        search_historyService.deleteSearchHistory(id);

        return ResponseEntity.noContent().build();
    }
}