package api.Controllers;

import api.Controllers.dto.request.GameRequest;
import api.Controllers.dto.request.SberRequest;
import api.Controllers.dto.response.GameResponse;
import api.Controllers.dto.response.SberResponse;
import api.service.impl.v1.Service;
import api.utils.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class ServiceControler {

    @Autowired
    private Map <String, Service> serviceMap;

    private final Validator validator;

    @PostMapping(value = "{version}/service", produces = APPLICATION_JSON_UTF8_VALUE)
    public GameResponse knb (@PathVariable final String version,
                    @Valid @RequestBody GameRequest req)
    {
        if (validator.isValid(req))
            return serviceMap.get(version).playingGame(req);
        else return GameResponse.builder()
                .res("Invalid enter params")
                .build();
    }
    @PostMapping(value = "{version}/sberService", produces = APPLICATION_JSON_UTF8_VALUE)
    public SberResponse sberService (@PathVariable final String version,
                             @Valid @RequestBody SberRequest req)
    {
        if (req != null)
            return serviceMap.get(version).returnWord(req);
        else
        return SberResponse.builder()
                .res("Invalid enter params")
                .build();
    }
}
