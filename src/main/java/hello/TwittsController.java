package hello;


import hello.Services.StatisticsService;
import hello.data.HashtagsHitsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Controller
@RequestScope
public class TwittsController {


    @Autowired
    private StatisticsService statisticsService;

    @Autowired
    private Map<String, ResponseBodyEmitter> onlineClients;


    @RequestMapping(path = "/bla/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseBodyEmitter handleRequest(@PathVariable(value = "userId") final String id) {

        final ResponseBodyEmitter emitter = new ResponseBodyEmitter(Long.MAX_VALUE);
        ExecutorService service = Executors.newSingleThreadExecutor();
        onlineClients.put(id, emitter);
        Long timeout = emitter.getTimeout();
        service.execute(() -> {
            for (int i = 0; i < 500; i++) {
                try {
                    emitter.send(i + " - ", MediaType.TEXT_PLAIN);

                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                    emitter.completeWithError(e);
                    return;
                }
            }
            emitter.complete();
        });

        return emitter;
    }

    @RequestMapping(path = "/stop/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public String disconnect(@PathVariable(value = "userId") final String id) {
        ResponseBodyEmitter emitter = null;
        try {
            emitter = onlineClients.get(id);
            emitter.complete();
            return "Success";
        } finally {
            onlineClients.remove(emitter);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/HitsStatistics")
    public List<HashtagsHitsDto> getHashTagsStatstics() {
        return statisticsService.getHits();
    }

}