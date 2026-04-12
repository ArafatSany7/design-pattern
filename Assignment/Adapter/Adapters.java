
interface Hdmi {
    void connectWithHdmiCable();
}

class Dvi {
    public void connectWithDviCable() {
        System.out.println("Connected with DVI ccable.");
    }
}

class Adapter implements Hdmi {
    private final Dvi dvi;

    public Adapter(Dvi dvi) {
        this.dvi = dvi;
    }

    @Override
    public void connectWithHdmiCable() {
        dvi.connectWithDviCable();
    }
}

public class Adapters {
    public static void main(String[] args) {
        Dvi dvi = new Dvi();
        Hdmi adapter = new Adapter(dvi);
        adapter.connectWithHdmiCable();
    }
}
