package api.service.impl.v1;

import api.Controllers.dto.request.GameRequest;
import api.Controllers.dto.request.SberRequest;
import api.Controllers.dto.response.GameResponse;
import api.Controllers.dto.response.SberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component("v1")
@RequiredArgsConstructor
public class ServiceImpl implements Service {

    private final KnbService knbService;
    private final SberService sberService;

    @Override
    public GameResponse playingGame(GameRequest handCharacter) {return  knbService.call(handCharacter);}

    @Override
    public SberResponse returnWord(SberRequest sberWord) { return sberService.call(sberWord);}
}
