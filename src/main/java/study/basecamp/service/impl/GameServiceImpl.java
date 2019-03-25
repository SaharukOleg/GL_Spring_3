package study.basecamp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.basecamp.entity.NumberEntity;
import study.basecamp.exception.MyIdNotFoundException;
import study.basecamp.repository.NumberRepository;
import study.basecamp.service.GameService;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    private final NumberRepository numberRepository;

    @Override
    public String guessNumber(int number, int id) {
        return equalsNumbers(number , id) ? "Winner!" : "Looser!";
    }

    @Override
    public int makeNumber(int number) {
        NumberEntity entity = new NumberEntity();
        entity.setNumber(number);
        return numberRepository.save(entity).getId();
    }

    @Override
    public boolean equalsNumbers(int number, int id) {
        int guess;
        try {
            guess = numberRepository.findById(id).get().getNumber();
        }catch (Exception e){
            throw new MyIdNotFoundException("Id " + id + " not found");
        }
        return number == guess;
    }


}
