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
