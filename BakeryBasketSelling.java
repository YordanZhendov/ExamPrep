import java.util.Map;
import java.util.Scanner;

public class dw {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        String[][] bakerySize = new String[n][n];

        for (int row = 0; row < bakerySize.length; row++) {
            bakerySize[row] = scanner.nextLine().split("");

        }

        int collectedMoney = 0;
        int rowIndex = 0;
        int columnIndex = 0;
        for (int row = 0; row < bakerySize.length; row++) {
            for (int column = 0; column < bakerySize[row].length; column++) {
                if (bakerySize[row][column].equals("S")) {
                    rowIndex = row;
                    columnIndex = column;
                }

            }

        }

        boolean news = true;
        while (collectedMoney < 50) {
            String command = scanner.nextLine();
            int moneyFound;
            String currentLocation;
            switch (command) {

                case "right":
                    bakerySize[rowIndex][columnIndex] = "-";
                    if (columnIndex + 1 > bakerySize[columnIndex].length-1) {
                        news = false;
                        break;
                    }
                    if (bakerySize[rowIndex][columnIndex + 1].equals("O")) {
                        bakerySize[rowIndex][columnIndex + 1] = "-";
                        for (int row = 0; row < bakerySize.length; row++) {
                            for (int column = 0; column < bakerySize[row].length; column++) {
                                if (bakerySize[row][column].equals("O")) {
                                    rowIndex = row;
                                    columnIndex = column;
                                    break;
                                }
                            }
                        }
                    } else {
                        columnIndex += 1;

                    }
                    currentLocation = bakerySize[rowIndex][columnIndex];
                    if (!(currentLocation.equals("-") || currentLocation.equals("O"))) {
                        moneyFound = Integer.parseInt(currentLocation);
                        collectedMoney += moneyFound;
                    }
                    bakerySize[rowIndex][columnIndex] = "S";
                    break;
                case "down":
                    bakerySize[rowIndex][columnIndex] = "-";
                    if (rowIndex + 1 > bakerySize[rowIndex].length-1) {
                        news = false;
                        break;
                    }
                    if (bakerySize[rowIndex+1][columnIndex].equals("O")) {
                        bakerySize[rowIndex+1][columnIndex] = "-";
                        for (int row = 0; row < bakerySize.length; row++) {
                            for (int column = 0; column < bakerySize[row].length; column++) {
                                if (bakerySize[row][column].equals("O")) {
                                    rowIndex = row;
                                    columnIndex = column;
                                    break;
                                }
                            }
                        }
                    } else {
                        rowIndex += 1;

                    }
                    currentLocation = bakerySize[rowIndex][columnIndex];
                    if (!(currentLocation.equals("-") || currentLocation.equals("O"))) {
                        moneyFound = Integer.parseInt(currentLocation);
                        collectedMoney += moneyFound;
                    }
                    bakerySize[rowIndex][columnIndex] = "S";
                    break;
                case "up":
                    bakerySize[rowIndex][columnIndex] = "-";
                    if (rowIndex - 1 < 0) {
                        news = false;
                        break;
                    }
                    if (bakerySize[rowIndex-1][columnIndex].equals("O")) {
                        bakerySize[rowIndex-1][columnIndex] = "-";
                        for (int row = 0; row < bakerySize.length; row++) {
                            for (int column = 0; column < bakerySize[row].length; column++) {
                                if (bakerySize[row][column].equals("O")) {
                                    rowIndex = row;
                                    columnIndex = column;
                                    break;
                                }
                            }
                        }
                    } else {
                        rowIndex -= 1;

                    }
                    currentLocation = bakerySize[rowIndex][columnIndex];
                    if (!(currentLocation.equals("-") || currentLocation.equals("O"))) {
                        moneyFound = Integer.parseInt(currentLocation);
                        collectedMoney += moneyFound;
                    }
                    bakerySize[rowIndex][columnIndex] = "S";
                    break;
                case "left":
                    bakerySize[rowIndex][columnIndex] = "-";
                    if (columnIndex -1 <0) {
                        news = false;
                        break;
                    }
                    if (bakerySize[rowIndex][columnIndex-1].equals("O")) {
                        bakerySize[rowIndex][columnIndex-1] = "-";
                        for (int row = 0; row < bakerySize.length; row++) {
                            for (int column = 0; column < bakerySize[row].length; column++) {
                                if (bakerySize[row][column].equals("O")) {
                                    rowIndex = row;
                                    columnIndex = column;
                                    break;
                                }
                            }
                        }
                    } else {
                        columnIndex -= 1;

                    }
                    currentLocation = bakerySize[rowIndex][columnIndex];
                    if (!(currentLocation.equals("-") || currentLocation.equals("O"))) {
                        moneyFound = Integer.parseInt(currentLocation);
                        collectedMoney += moneyFound;
                    }
                    bakerySize[rowIndex][columnIndex] = "S";
                    break;
            }

            if (!news) {
                break;
            }

        }

        if (news) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        } else {
            System.out.println("Bad news, you are out of the bakery.");
        }

        System.out.printf("Money: %d", collectedMoney);

        for (int row = 0; row < bakerySize.length; row++) {
            System.out.println();
            for (int column = 0; column < bakerySize[row].length; column++) {
                System.out.print(bakerySize[row][column]);

            }

        }
    }
}
