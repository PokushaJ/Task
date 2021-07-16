package api.service.impl.v1;

import api.Controllers.dto.request.SberRequest;
import api.Controllers.dto.response.SberResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component("Sber")
@Slf4j
@RequiredArgsConstructor
public class SberService {
    public SberResponse call (SberRequest req){
        String requestId = UUID.randomUUID().toString();
        log.info("Start SberService with processId {}", requestId);
        SberResponse res = SberResponse.builder()
                .build();
        try {
            res.setRes("SBER " + req.getSberWord());
        }
        catch (NullPointerException e){
            log.error("NullPointerException {}", ExceptionUtils.getStackTrace(e));
        }
        log.info("End SberService service with processId {}", requestId );
        return res;
    }
}
