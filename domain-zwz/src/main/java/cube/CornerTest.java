package cube;

public class CornerTest {
    public static void main(String[] args) {
        if(Corner.URF.ordinal() == 0){
            System.out.println(Corner.URF.name());
            System.out.println(Corner.valueOf("URF"));
        }
    }
}
