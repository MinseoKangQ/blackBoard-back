package dev.line4.blackBoard.blackboard.controller;

import dev.line4.blackBoard.blackboard.service.BlackBoardService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class BlackBoardController {
    private final BlackBoardService blackBoardService;

    @Autowired
    public BlackBoardController(BlackBoardService blackBoardService) {
        this.blackBoardService = blackBoardService;
    }

    @GetMapping("blackboard")
    public Map<String, Integer> getTotalRecordCount() {
        Map<String, Integer> response = new HashMap<>();
        response.put("blackboard_count", (int) blackBoardService.getTotalRecordCount());
        return response;
    }
}
