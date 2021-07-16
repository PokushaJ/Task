package api.service.impl.v1;

import api.Controllers.dto.ValuesEnum;
import api.Controllers.dto.request.GameRequest;
import api.Controllers.dto.response.GameResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component("KNB")
@Slf4j
@RequiredArgsConstructor
public class KnbService {

    public GameResponse call (GameRequest req){
        String requestId = UUID.randomUUID().toString();
        log.info("Start knb service with processId {}",requestId);
        GameResponse res = GameResponse.builder()
                .build();

        try {
            ValuesEnum randomValues = ValuesEnum.values()[(int)(Math.random()*2)];
            if (req.getIsCheat()){
                res.setCheaterText("I'm sorry, against cheater you permanently loose (выше фака нету знака)");
            }
            else {
                String result;
                if (req.getHandCharacter().equals(randomValues)){
                    res.setRes("Ничья, переиграем?");
                }  // Stone = Stone
                else if (req.getHandCharacter().equals(ValuesEnum.STONE)){
                   result = randomValues.equals(ValuesEnum.PAPER) ? "А у меня бумага! Ты проиграл! Ха!" : "Ножницы! Черт, я проиграл!";
                   res.setRes(result);
                } else if (req.getHandCharacter().equals(ValuesEnum.SCISSORS)){
                    result = randomValues.equals(ValuesEnum.STONE) ? "А у меня камень! Ты проиграл! Ха!" : "Бумага! Черт, я проиграл!";
                    res.setRes(result);
                } else if (req.getHandCharacter().equals(ValuesEnum.PAPER)){
                    result = randomValues.equals(ValuesEnum.SCISSORS) ? "А у меня ножницы! Ты проиграл! Ха!" : "Камень! Черт, я проиграл!";
                    res.setRes(result);
                }
            }
        }
        catch (NullPointerException e){
            log.error("NullPointerException {}", ExceptionUtils.getStackTrace(e));
        }
        log.info("End knb service with processId {}", requestId );
        return res;
    }
}
