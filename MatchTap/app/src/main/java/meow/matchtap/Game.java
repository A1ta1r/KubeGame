package meow.matchtap;

import java.util.Random;

public class Game{
    private int SIZE = 16;
    private int[] numbers = new int[SIZE];
    private int steps = 0;
    private static int winTurns = 0;
    private boolean secondClick = false;
    private int NeededMatches = 8;
    public final int doneVal = -1;
    public boolean endGame = false;

    public Game(){
        FillNumbers();
        Shuffle(numbers);
        steps = 0;
        endGame = false;
    }
    public int getSIZE(){
        return SIZE;
    }
    public void setNumbers(int[] x){
        for (int i = 0;i<SIZE;i++)
            numbers[i] = x[i];
    }

    public int[] getNumbers(){
        return numbers;
    }

    public void plusStep(){
        steps++;
    }

    public static int getWinTurns(){
        return winTurns;
    }

    public void setWinTurns(int x){
        winTurns = x;
    }

    public int getSteps(){
        return steps;
    }

    public boolean SecondClick(){
        return secondClick;
    }

    public void EvenStep(){
        secondClick=!secondClick;
    }

    private void FillNumbers(){
        int k = 1;
        for (int i = 0;i<SIZE;i++){
            numbers[i] = k;
            if (i%2==1)
                k++;
        }
    }

    public void Shuffle(int[] x) {
        Random rnd = new Random();
        for (int i = SIZE - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            int temp = x[i];
            x[i] = x[index];
            x[index] = temp;
        }
    }

    public void MatchFound(int i1, int i2){
        NeededMatches--;
        if (NeededMatches==0){
            endGame = true;
        }
        else{
            numbers[i1] = doneVal;
            numbers[i2] = doneVal;
        }
    }

    public void SwapElements(int i1, int i2){
        int temp = numbers[i1];
        numbers[i1] = numbers[i2];
        numbers[i2] = temp;
        setNumbers(numbers);
    }



}
