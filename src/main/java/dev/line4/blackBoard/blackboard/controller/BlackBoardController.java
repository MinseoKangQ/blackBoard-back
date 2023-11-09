package dev.line4.blackBoard.blackboard.controller;

import dev.line4.blackBoard.blackboard.dto.BlackBoardCountDto;
import dev.line4.blackBoard.blackboard.dto.BlackBoardOpenResDto;
import dev.line4.blackBoard.blackboard.dto.BlackBoardReqDto;
import dev.line4.blackBoard.blackboard.dto.BlackBoardResDto;
import dev.line4.blackBoard.blackboard.service.BlackBoardService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class BlackBoardController {
    @Autowired
    private final BlackBoardService blackBoardService;
    private final ModelMapper modelMapper;

    @Autowired
    public BlackBoardController(BlackBoardService blackBoardService, ModelMapper modelMapper) {
        this.blackBoardService = blackBoardService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/blackboards")
    public BlackBoardCountDto getTotalRecordCount() {
        return BlackBoardCountDto.builder()
                .blackboard_count(blackBoardService.getTotalRecordCount())
                .build();
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

    @GetMapping("/blackboard")
    public ResponseEntity<BlackBoardOpenResDto> getBlackBoardAndLetter(@RequestParam("id") String blackboardId) {
        BlackBoardOpenResDto blackBoardOpenResDto = blackBoardService.getBlackBoardAndLetter(blackboardId);

        BlackBoardOpenResDto responseDto = modelMapper.map(blackBoardOpenResDto, BlackBoardOpenResDto.class);
        return ResponseEntity.ok(responseDto);
    }
}
