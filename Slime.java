public class Slime {
    String name = "スライム";
    int hp;
    int level = 10;//初期レベル（変動させる可能性あり）
    char suffix;//同名エネミーが出現する場合の識別子　例　スライム「Ａ」　スライム「Ｂ」

    public Slime(int level){
        this.hp = level * 10;
    }

    public void run(){
        System.out.println(this.name + this.suffix + "は逃げ出した！");
    }
}
