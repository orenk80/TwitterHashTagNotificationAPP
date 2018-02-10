package hello.Services;


import hello.data.HashtagsHitsDto;
import hello.data.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class StatisticsService {


    @Autowired
    StatisticsRepository repository;

    public List<HashtagsHitsDto> getHits(){
        List<HashtagsHitsDto> hashtagsHitsDtos = new ArrayList<>();
        repository.findAll().forEach((row)->
        {
            hashtagsHitsDtos.add(new HashtagsHitsDto(row.getHashTag(), row.getHits()));
        });
        return hashtagsHitsDtos;
    }


}
