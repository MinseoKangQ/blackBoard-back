package dev.line4.blackBoard.blackboard.service;

import dev.line4.blackBoard.blackboard.dto.BlackBoardReqDto;
import dev.line4.blackBoard.blackboard.dto.BlackBoardResDto;
import dev.line4.blackBoard.blackboard.entity.BlackBoards;
import dev.line4.blackBoard.blackboard.repository.BlackBoardRepository;
import dev.line4.blackBoard.blackboardsticker.service.BlackBoardStickerService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlackBoardService {
    private final BlackBoardRepository blackBoardRepository;
    @Autowired
    private BlackBoardStickerService blackBoardStickerService;

    @Autowired
    public BlackBoardService(BlackBoardRepository blackBoardRepository) {
        this.blackBoardRepository = blackBoardRepository;
    }

    public long getTotalRecordCount() {
        return blackBoardRepository.count();
    }

    public BlackBoardResDto createBlackBoard(BlackBoardReqDto blackBoardReqDto) {
        String randomUrl = UUID.randomUUID().toString().substring(0, 12);

        BlackBoards blackBoards = BlackBoards.builder()
                .id(randomUrl)
                .title(blackBoardReqDto.getTitle())
                .introduction(blackBoardReqDto.getIntroduction())
                .email(blackBoardReqDto.getEmail())
                .graduateDate(parseGraduateDate(blackBoardReqDto.getGraduateDate()))
                .build();
        BlackBoards savedBlackBoard = blackBoardRepository.save(blackBoards);

        blackBoardStickerService.createBlackBoardStickers(blackBoardReqDto.getStickers(), savedBlackBoard);
        
        return BlackBoardResDto.builder().url(randomUrl).build();
    }

    private LocalDateTime parseGraduateDate(String graduateDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(graduateDate, formatter);
    }


}
