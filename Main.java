import java.util.*;

public class Main {

    static char[][] map = new char[3][3];
    static int turn = 1;
    static int move = 0;

    static void printMap(){
        for(int row = 0; row < 3; row++){
            for(int col = 0; col < 3; col++){
                System.out.print(map[row][col]);

                if(col < 2){
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }

    static void resetMap(){
        for(int row = 0; row < 3; row++){
            for(int col = 0; col < 3; col++){
                map[row][col] = '-';
            }
        }
    }

    static int checkMap(){
        int game = 3;

       if(
        (map[0][0] == 'X' && map[0][1] == 'X' && map[0][2] == 'X') ||
        (map[1][0] == 'X' && map[1][1] == 'X' && map[1][2] == 'X') ||
        (map[2][0] == 'X' && map[2][1] == 'X' && map[2][2] == 'X') ||
        (map[0][0] == 'X' && map[1][0] == 'X' && map[2][0] == 'X') ||
        (map[0][1] == 'X' && map[1][1] == 'X' && map[2][1] == 'X') ||
        (map[0][2] == 'X' && map[1][2] == 'X' && map[2][2] == 'X') ||
        (map[0][0] == 'X' && map[1][1] == 'X' && map[2][2] == 'X') ||
        (map[0][2] == 'X' && map[1][1] == 'X' && map[2][0] == 'X')){
            game = 1;
        }
        else if(
        (map[0][0] == 'O' && map[0][1] == 'O' && map[0][2] == 'O') ||
        (map[1][0] == 'O' && map[1][1] == 'O' && map[1][2] == 'O') ||
        (map[2][0] == 'O' && map[2][1] == 'O' && map[2][2] == 'O') ||
        (map[0][0] == 'O' && map[1][0] == 'O' && map[2][0] == 'O') ||
        (map[0][1] == 'O' && map[1][1] == 'O' && map[2][1] == 'O') ||
        (map[0][2] == 'O' && map[1][2] == 'O' && map[2][2] == 'O') ||
        (map[0][0] == 'O' && map[1][1] == 'O' && map[2][2] == 'O') ||
        (map[0][2] == 'O' && map[1][1] == 'O' && map[2][0] == 'O'))
        {
            game = 2;
        }
        return game;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        resetMap();
        printMap();

        while(true){
            int newX;
            int newY;
            while(true){
                System.out.print((turn == 1 ? "Player 1 " : "Player 2 ") + "masukkan koordinat (X Y) : ");
                newX = scanner.nextInt();
                newY = scanner.nextInt();

                if(newX < 0 || newX >= 3 || newY < 0 || newY >= 3){
                    continue;
                }

                if(map[newY][newX] != '-'){
                    continue;
                }
                break;
            }

            map[newY][newX] = (turn == 1 ? 'X' : 'O');
            move++;
            int game = checkMap();
            if(game == 1){
                printMap();
                System.out.println("PLAYER 1 WIN!!");
                break;
            } else if(game == 2){
                printMap();
                System.out.println("PLAYER 2 WIN!!");
                break;
            }

            if(move == 9){
                printMap();
                System.out.println("Game draw");
                break;
            }
            turn = (turn == 1 ? 2 : 1);
            printMap();
        }

        scanner.close();
    }
}