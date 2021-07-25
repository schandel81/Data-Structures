public class BuilderPattern {
    private String HDD;
    private String monitor;
    private String keyboard;
    private String bluetooth;
    private String webcam;

    private BuilderPattern(Builder b) {
        HDD = b.HDD;
        monitor = b.monitor;
        keyboard = b.keyboard;
        bluetooth = b.bluetooth;
        webcam = b.webcam;
    }

    public String getHDD() {
        return HDD;
    }

    public String getMonitor() {
        return monitor;
    }

    public String getKeyboard() {
        return keyboard;
    }

    public String getBluetooth() {
        return bluetooth;
    }

    public String getWebcam() {
        return webcam;
    }

    public static class Builder {
        private String HDD;
        private String monitor;
        private String keyboard;
        private String bluetooth;
        private String webcam;

        Builder(String HDD, String monitor) {
            this.HDD = HDD;
            this.monitor = monitor;
        }
        Builder setKeyboard(String keyboard) {
            this.keyboard = keyboard;
            return this;
        }
        Builder setBluetooth(String bluetooth) {
            this.bluetooth = bluetooth;
            return this;
        }
        Builder setWebcam(String webcam) {
            this.webcam = webcam;
            return this;
        }
        BuilderPattern build() {
            BuilderPattern p1 = new BuilderPattern(this);
            return p1;
        }
    }
}

class Main {
    public static void main(String[] args) {
        BuilderPattern bp = new BuilderPattern.Builder("512", "32 inches").setBluetooth("3.0").build();
        System.out.println(bp.getBluetooth());
    }
}