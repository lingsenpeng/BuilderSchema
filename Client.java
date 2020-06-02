public class Client {
    public static void main(String[] args) {
        int blackNum = 2;
        int whiteNum = 3;

        TeaMakeDirector director = new TeaMakeDirector();
        for (int i = 0; i < blackNum; i++) {
            System.out.println("制作红茶");
            director.makeBlackTea().make();
        }
        for (int i = 0; i < whiteNum; i++) {
            System.out.println("制作白茶");
            director.makeWhiteTea().make();
        }

    }
}
