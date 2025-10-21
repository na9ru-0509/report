import java.util.Random;
import java.util.Scanner;

public class Main{
    enum GameState{
        TOWN, ADVENTURE,MENU
    }
    public static void main(String[] args) {
        //世界クラス
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        GameState state = GameState.TOWN;
        boolean rute = true;


        System.out.println("ようこそ!Draw World!の世界へ!");
        System.out.print("あなた(主人公)の名前を入力してください＞");
        String newname = scanner.nextLine();
        Hero hero = new Hero(newname);
        Sword s = new Sword();
        hero.sword = s;
        System.out.println("勇者" + hero.name + "はこれからこの広大な世界を冒険する");
        System.out.println("現在のステータス" + "\n名前" + hero.name + "\nHP:" + hero.hp + "\nmp:" + hero.mp);

        System.out.println("~~~~~~~~~~王城~~~~~~~~~~");
        System.out.println("勇者" + hero.name + "にはこれから魔王討伐のたびに向かってもらう。健闘を祈る");
        Tutorial tut = new Tutorial();
        tut.tutorial();
        System.out.println(hero.name + "はどうする？");

        Choice choice = new Choice();
        while (rute) {
            switch (state) {
                case TOWN:
                    System.out.println("1.冒険に出かける\n2.メニューを開く\n3.ゲームをやめる");

                    int townChoice = choice.getChoice(scanner, 1, 3);
                    if (townChoice == 1) {
                        System.out.println("あなたは冒険に出ました！");
                        state = GameState.ADVENTURE;
                    } else if (townChoice == 2) {
                        state = GameState.MENU;
                    } else {
                        System.out.println("ゲームを終了しました");
                        rute = false;
                    }
                    break;

                case ADVENTURE:
                    System.out.println("1.敵と戦う\n2.街に戻る\n3.メニューを開く");

                    int advChoice = choice.getChoice(scanner, 1, 3);
                    if (advChoice == 1) {
                        System.out.println("敵が現れた！戦闘開始！");
                        // ここにバトル処理を追加
                        Random leveRandom = new Random();
                        int level = random.nextInt(10);
                        Slime Slime = new Slime(level);
                        System.out.println("野生の" + Slime.name + "Lv.(" + level + ")" + "が現れた！");

                        while(Slime.hp > 0 && hero.hp > 0){
                            System.out.println(hero.name + "はどうする？");
                            System.out.println("コマンド");
                            System.out.println("1.攻撃\n2.逃げる");

                            int battlechoice = choice.getChoice(scanner, 1, 2);
                            if(battlechoice == 1){
                                System.out.println(Slime.name + "へ攻撃！");
                                System.out.println(hero.name + "は" + Slime.name + "に" + hero.sword.damage + "与えた!");
                                Slime.hp -= hero.sword.damage;
                                System.out.println(Slime.name + "の残りHPは" + Slime.hp);

                                if(Slime.hp == 0){
                                    System.out.println(Slime.name + "は倒れた");
                                    break;
                                }
                            }else{
                                System.out.println(hero.name + "は逃げ出した");
                                state = GameState.TOWN;
                                break;
                            }
                        }

                    } else if (advChoice == 2) {
                        System.out.println("町に戻りました。");
                        state = GameState.TOWN;
                    } else {
                        state = GameState.MENU;
                    }
                    break;

                case MENU:
                    System.out.println("1.チュートリアルを見る\n2.街に戻る");

                    int menuChoice = choice.getChoice(scanner, 1, 2);
                    if (menuChoice == 1) {
                        tut.tutorial();//チュートリアルの表示
                    }else{
                        state = GameState.TOWN;// 町に戻る
                    }
                    break;
            }
        }
    }
}
