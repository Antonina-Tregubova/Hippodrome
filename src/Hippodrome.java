
import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    public static Hippodrome game;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    void move() {
        for (Horse horse: horses) {
            horse.move();
        }
    }

    void print() {
        for (Horse horse: horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        Horse winner = null;
        int maxDistance = 0;
        for (Horse horse: horses) {
            if (horse.getDistance() > maxDistance) {
                maxDistance = (int)horse.getDistance();
                winner = horse;
            }
        }
        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args) throws InterruptedException {

        game = new Hippodrome(new ArrayList<Horse>());

        Horse horse1 = new Horse("Fain", 3, 0);
        Horse horse2 = new Horse("Burn", 3, 0);
        Horse horse3 = new Horse("Bunny", 3, 0);

        game.horses.add(horse1);
        game.horses.add(horse2);
        game.horses.add(horse3);

        game.run();
        game.printWinner();
    }
}

