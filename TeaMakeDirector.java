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
