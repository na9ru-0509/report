import java.util.Scanner;

public class Choice {

    public static int getChoice(Scanner scanner, int min, int max) {
        while (true) {
            System.out.print(min + "～"+ max + "の間で選択してください＞");
            String input = scanner.nextLine();
            try {
                int choice = Integer.parseInt(input);
                if (choice >= min && choice <= max) {
                    return choice;
                } else {
                    System.out.println("無効な入力です。範囲内の数字を入力してください。");
                }
            } catch (NumberFormatException e) {
                System.out.println("数値を入力してください");
            }
        }
    }
}
