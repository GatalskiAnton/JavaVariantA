public class Undergraduate extends Student {
    Academic tutor;
    Undergraduate(String name, String login, String email) {
        super(name, login, email);
    }

    public Academic getTutor() {
        return tutor;
    }

    public void setTutor(Academic tutor) {
        this.tutor = tutor;
    }
}
