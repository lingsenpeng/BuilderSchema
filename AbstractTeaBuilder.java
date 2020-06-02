
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
