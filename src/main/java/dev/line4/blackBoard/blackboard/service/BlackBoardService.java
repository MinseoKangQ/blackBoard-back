package dev.line4.blackBoard.blackboard.service;

import dev.line4.blackBoard.blackboard.dto.BlackBoardReqDto;
import dev.line4.blackBoard.blackboard.dto.BlackBoardResDto;
import dev.line4.blackBoard.blackboard.entity.BlackBoards;
import dev.line4.blackBoard.blackboard.repository.BlackBoardRepository;
import dev.line4.blackBoard.blackboardsticker.dto.BlackBoardStickerDto;
import dev.line4.blackBoard.blackboardsticker.entity.BlackBoardStickers;
import dev.line4.blackBoard.blackboardsticker.service.BlackBoardStickerService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
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

        BlackBoards blackBoards = BlackBoards.builder()
                .title(blackBoardReqDto.getTitle())
                .introduction(blackBoardReqDto.getIntroduction())
                .email(blackBoardReqDto.getEmail())
                .graduateDate(parseGraduateDate(blackBoardReqDto.getGraduateDate()))
                .blackBoardStickers(
                        mapToBlackBoardStickers(blackBoardReqDto.getStickers())) // BlackBoardSticker record도 생성
                .build();
        blackBoardRepository.save(blackBoards);

        String randomUrl = UUID.randomUUID().toString().substring(0, 12);
        return BlackBoardResDto.builder().url(randomUrl).build();
    }

    // 졸업날짜 yyyy-mm-dd 형식
    private LocalDateTime parseGraduateDate(String graduateDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDateTime.parse(graduateDate, formatter);
    }

    private Set<BlackBoardStickers> mapToBlackBoardStickers(List<BlackBoardStickerDto> stickerDtos) {
        return stickerDtos.stream()
                .map(this::mapToBlackBoardSticker)
                .collect(Collectors.toSet());
    }

    private BlackBoardStickers mapToBlackBoardSticker(BlackBoardStickerDto stickerDto) {
        return blackBoardStickerService.createBlackBoardStickers(stickerDto);
    }

}
