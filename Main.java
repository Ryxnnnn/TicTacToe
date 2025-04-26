import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

    public static void main(String[] args) {


            char[][] gb = GameBoard.gameBoard;
                GameBoard.printGameBoard(gb);


                while (true) {
                    Scanner scan = new Scanner(System.in);
                    System.out.println("Enter your placement (1-9)");
                    int playerPos = scan.nextInt();

                    while (playerPositions.contains(playerPos) || cpuPositions.contains(playerPos)) {
                        System.out.println("Position taken! Enter a correct Positions");
                        playerPos = scan.nextInt();
                    }
                    PlacePiece.placePiece(gb, playerPos, "Player");
                    String result = CheckingWinner.checkWinner();
                    if(result.length() > 0) {
                        System.out.println(result);
                        break;
                    }


                    Random rand = new Random();
                    int cpuPos = rand.nextInt(9) + 1;
                    while (playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)) {
                        cpuPos = rand.nextInt(9) + 1;
                    }
                    PlacePiece.placePiece(gb, cpuPos, "CPU");

                    GameBoard.printGameBoard(gb);

                    result = CheckingWinner.checkWinner();
                        if(result.length() > 0) {
                            System.out.println(result);
                            break;
                        }
                    System.out.println(result);
                }

                }

        }


