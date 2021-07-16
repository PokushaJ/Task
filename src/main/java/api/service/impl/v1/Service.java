package api.service.impl.v1;

import api.Controllers.dto.request.GameRequest;
import api.Controllers.dto.request.SberRequest;
import api.Controllers.dto.response.GameResponse;
import api.Controllers.dto.response.SberResponse;

public interface Service {
    GameResponse playingGame (GameRequest handCharacter);
    SberResponse returnWord (SberRequest sberWord);
}
