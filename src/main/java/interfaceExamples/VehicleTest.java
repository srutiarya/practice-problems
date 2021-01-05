package interfaceExamples;

public class VehicleTest {

}

interface Vehicle {

    public int wheelCount();

    public int enginePower();

    public int seats();

}

abstract class TwoWheeler implements Vehicle {

    public int wheelCount() {
        return 2;
    }

    abstract String transmission();

}

class Bike extends TwoWheeler {

    @Override
    public int enginePower() {
        return 0;
    }

    @Override
    public int seats() {
        return 0;
    }

    @Override
    String transmission() {
        return null;
    }

    String xyz() {
        return null;
    }
}

class FZ extends Bike {

    @Override
    String transmission() {
        return "manual";
    }

}

abstract class Sample {
    abstract void x();

    void y() {
        System.out.println("");
    }
}
