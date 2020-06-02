# BuilderSchema
设计模式之建造者模式

A、建造者模式的优点
*封装性
*独立，容易扩展
*便于控制细节风险，对建造过程逐步细化

一、抽象茶叶建造者
public abstract class AbstractTeaBuilder {
    /**
     * 设置制茶顺序
     * @param sequence
     */
    public abstract void setSequence(ArrayList<String> sequence);
    /**
     * 获取茶叶
     * @return
     */
    public abstract TeaModel getTeaModel();
}
二、具体茶叶建造者
  public class BlackTeaBuilder extends AbstractTeaBuilder   {

    BlackTeaModel blackTeaModel = new BlackTeaModel();

    @Override
    public void setSequence(ArrayList<String> sequence) {
        this.blackTeaModel.setSequence(sequence);
    }

    @Override
    public TeaModel getTeaModel() {
        return this.blackTeaModel;
    }
}
三、具体茶叶建造者
/**
* 红茶制造者
*/
public class BlackTeaBuilder extends AbstractTeaBuilder   {

    BlackTeaModel blackTeaModel = new BlackTeaModel();

    @Override
    public void setSequence(ArrayList<String> sequence) {
        this.blackTeaModel.setSequence(sequence);
    }

    @Override
    public TeaModel getTeaModel() {
        return this.blackTeaModel;
    }
}
/**
* 白茶制造者
*/
public class WhiteTeaBuilder extends AbstractTeaBuilder {
    private WhiteTeaModel model = new WhiteTeaModel();
    @Override
    public void setSequence(ArrayList<String> sequence) {
        model.setSequence(sequence);
    }

    @Override
    public TeaModel getTeaModel() {
        return model;
    }
}
四、抽象制茶模型
public class AppConfigs   {

    /**
     * 采摘
     */
    public static final String BAKING = "baking";
    /**
     * 萎调
     */
    public static final String DETERIORATION = "deterioration";
    /**
     * 揉捻
     */
    public static final String ROLLING = "rolling";
    /**
     * 烘干
     */
    public static final String DRY = "dry";
    /**
     * 发酵
     */
    public static final String FERMENTATION = "fermentation";
    /**
     * 保存
     */
    public static final String SAVE = "save";
}
五、红茶实现模型
public class BlackTeaModel extends TeaModel {

    @Override
    public void baking() {
        System.out.println("红茶：采摘");
    }

    @Override
    public void deterioration() {
        System.out.println("红茶：萎调");
    }

    @Override
    public void rolling() {
        System.out.println("红茶：揉捻");
    }

    @Override
    public void dry() {
        System.out.println("红茶：烘干");
    }

    @Override
    public void fermentation() {
        System.out.println("红茶：发酵");
    }

    @Override
    public void save() {
        System.out.println("红茶：保存");
    }
}
六、白茶实现模型
public class WhiteTeaModel extends TeaModel {

    @Override
    public void baking() {
        System.out.println("白茶：采摘");
    }

    @Override
    public void deterioration() {
        System.out.println("白茶：萎调");
    }

    @Override
    public void rolling() {
        System.out.println("白茶：揉捻");
    }

    @Override
    public void dry() {
        System.out.println("白茶：烘干");
    }

    @Override
    public void fermentation() {
        System.out.println("白茶：发酵");
    }

    @Override
    public void save() {
        System.out.println("白茶：保存");
    }
}
七、制茶大师，给出专业的制茶工序
public class TeaMakeDirector   {

    private ArrayList<String> sequence = new ArrayList<>();
    private WhiteTeaBuilder whiteTeaBuilder = new WhiteTeaBuilder();
    private BlackTeaBuilder blackTeaBuilder = new BlackTeaBuilder();
    /**
     * 白茶制作工序 ：采摘 → 萎调 → 烘干 → 保存
     * @return、
     */
    public WhiteTeaModel makeWhiteTea(){
        this.sequence.clear();
        this.sequence.add(AppConfigs.BAKING);
        this.sequence.add(AppConfigs.DETERIORATION);
        this.sequence.add(AppConfigs.DRY);
        this.sequence.add(AppConfigs.SAVE);
        this.whiteTeaBuilder.setSequence(this.sequence);
        return (WhiteTeaModel) this.whiteTeaBuilder.getTeaModel();
    }
    /**
     * 红茶制作工序 ：采摘 → 萎调 → 揉捻 → 发酵 → 干燥
     * @return
     */
    public BlackTeaModel makeBlackTea(){
        this.sequence.clear();
        this.sequence.add(AppConfigs.BAKING);
        this.sequence.add(AppConfigs.DETERIORATION);
        this.sequence.add(AppConfigs.ROLLING);
        this.sequence.add(AppConfigs.FERMENTATION);
        this.sequence.add(AppConfigs.DRY);
        this.blackTeaBuilder.setSequence(this.sequence);
        return (BlackTeaModel) this.blackTeaBuilder.getTeaModel();
    }
}
六、客户提需求，要 “两份红茶，三份白茶”
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
七、输入结果

制作红茶
红茶：采摘
红茶：萎调
红茶：揉捻
红茶：发酵
红茶：烘干
制作红茶
红茶：采摘
红茶：萎调
红茶：揉捻
红茶：发酵
红茶：烘干
制作白茶
白茶：采摘
白茶：萎调
白茶：烘干
白茶：保存
制作白茶
白茶：采摘
白茶：萎调
白茶：烘干
白茶：保存
制作白茶
白茶：采摘
白茶：萎调
白茶：烘干
白茶：保存
