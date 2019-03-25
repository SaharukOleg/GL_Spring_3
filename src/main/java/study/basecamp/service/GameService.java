package study.basecamp.service;

public interface GameService {

    String guessNumber(int number , int id);

    int makeNumber(int number);

    boolean equalsNumbers(int number , int id);
}
