package dev.line4.blackBoard.blackboard.controller;

import dev.line4.blackBoard.blackboard.dto.BlackBoardReqDto;
import dev.line4.blackBoard.blackboard.dto.BlackBoardResDto;
import dev.line4.blackBoard.blackboard.service.BlackBoardService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class BlackBoardController {
    @Autowired
    private final BlackBoardService blackBoardService;

    @Autowired
    public BlackBoardController(BlackBoardService blackBoardService) {
        this.blackBoardService = blackBoardService;
    }

    @GetMapping("/blackboard")
    public Map<String, Integer> getTotalRecordCount() {
        Map<String, Integer> response = new HashMap<>();
        response.put("blackboard_count", (int) blackBoardService.getTotalRecordCount());
        return response;
    }

    @PostMapping("/blackboard")
    public ResponseEntity<BlackBoardResDto> createBlackBoard(@RequestBody BlackBoardReqDto blackBoardReqDto) {
        BlackBoardResDto responseDto = blackBoardService.createBlackBoard(blackBoardReqDto);

        if (responseDto.getUrl() == null) {
            // 이미 생성한 경우, 실패 응답
            return new ResponseEntity<>(responseDto, HttpStatus.CONFLICT);
        }

        // 생성 성공 응답
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);

    }
}
