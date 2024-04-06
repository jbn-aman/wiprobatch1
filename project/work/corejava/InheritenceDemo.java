class BasicPhone {

    void makeCall() {
        System.out.println("Make calls..");
    }

    void receiveCall() {
        System.out.println("Receive calls..");
    }

    void sendTextMsg() {
        System.out.println("send text message..");
    }

    void receiveTextMsg() {
        System.out.println("receiveTextMsg..");
    }
}

class SmartPhone extends BasicPhone {

    void browseInternet() {
        System.out.println("Browse Internet..");
    }

    void useCamera() {
        System.out.println("use camera..");
    }
}

class InheritenceDemo {

    public static void main(String[] args) {

        SmartPhone sPhone = new SmartPhone();
        sPhone.makeCall();
        sPhone.receiveCall();
        sPhone.sendTextMsg();
        sPhone.receiveTextMsg();
        sPhone.browseInternet();
        sPhone.useCamera();
    }
}
