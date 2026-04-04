interface Hdmi {
    void connectWithHdmiCable();
}

class Vga {
    public void connectWithVgaCable() {
        System.out.println("Connected with VGA cable.");
    }
}

class HdmiAdapter implements Hdmi {
    private Vga vga;

    public HdmiAdapter(Vga vga) {
        this.vga = vga;
    }

    @Override
    public void connectWithHdmiCable() {
        vga.connectWithVgaCable();
    }
}

public class Hdm {
    public static void main(String[] args) {
        Vga vga = new Vga();
        Hdmi adapter = new HdmiAdapter(vga);
        adapter.connectWithHdmiCable();
    }
}
