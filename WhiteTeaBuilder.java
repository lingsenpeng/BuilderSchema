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
