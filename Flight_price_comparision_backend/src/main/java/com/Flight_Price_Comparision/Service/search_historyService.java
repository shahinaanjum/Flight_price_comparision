package com.Flight_Price_Comparision.Service;
import com.Flight_Price_Comparision.Model.entity.search_history;
import com.Flight_Price_Comparision.Repository.search_historyRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class search_historyService {
    private final search_historyRepository search_historyRepository;
    public search_historyService(search_historyRepository search_historyRepository) {
        this.search_historyRepository = search_historyRepository;
    }
    public search_history createSearchHistory(search_history searchHistory) {
        return search_historyRepository.save(searchHistory);
    }
    public List<search_history> getAllSearchHistory() {
        return search_historyRepository.findAll();
    }
    public Optional<search_history> getSearchHistoryById(Long id) {
        return search_historyRepository.findById(id);
    }
    public List<search_history> getSearchHistoryByUserId(Long userId) {
        return search_historyRepository.findByUserId(userId);
    }
    public void deleteSearchHistory(Long id) {
        search_historyRepository.deleteById(id);
    }
}