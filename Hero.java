public class Hero {
    Sword sword;
    String name; //主人公の名前
    int hp; //主人公のHP
    int mp;

    public Hero(String name){
        this.name = name;
        this.hp = 100;
        this.mp = 100;
    }
    
    public void attack(){
        System.out.println(this.name + "の攻撃!");
    }
    public void sleep(){//戦闘以外でHPを回復する手段（固定値）
        this.hp = 100;
        System.out.println(this.name + "は、眠って回復した");
    }

    public void sit(int sec) {//戦闘中にHPを回復する手段（変動値）
        this.hp += sec/2;//座った秒数の半分だけ回復する
        System.out.println(this.name + "は、" + sec + "秒座った！");
        System.out.println("hpが" + sec/2 + "回復した");
    }

    public void run(){
        System.out.println(this.name + "は逃げ出した！");
    }
}