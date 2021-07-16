package api.utils;

import api.Controllers.dto.ValuesEnum;
import api.Controllers.dto.request.GameRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class Validator {
    public boolean isValid (GameRequest gameRequest){
        return gameRequest != null && StringUtils.hasText(String.valueOf(gameRequest.getHandCharacter()))
                && (gameRequest.getHandCharacter().equals(ValuesEnum.STONE)
                || gameRequest.getHandCharacter().equals(ValuesEnum.PAPER)
                || gameRequest.getHandCharacter().equals(ValuesEnum.SCISSORS));
    }
}
