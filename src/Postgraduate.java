public class Postgraduate extends Student{
    Academic supervisor;

    public Academic getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Academic supervisor) {
        this.supervisor = supervisor;
    }

    Postgraduate(String name, String login, String email) {
        super(name, login, email);
    }
}
