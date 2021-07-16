package api.Controllers.dto.request;

import api.Controllers.dto.ValuesEnum;
import lombok.Data;

@Data
public class GameRequest {
    private ValuesEnum handCharacter;
    private Boolean isCheat;
}
