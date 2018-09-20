package be.pxl.computerstore.hardware;

import be.pxl.computerstore.util.Computable;
import be.pxl.computerstore.util.TooManyPeripheralsException;

public class ComputerSystem implements Computable {
    private Processor processor;
    private HardDisk hardDisk;
    private ComputerCase computerCase;
    private int counter = 0;
    private Peripheral[] peripherals = new Peripheral[MAX_PERIPHERAL];
    public static final int MAX_PERIPHERAL = 3;

    public void addPeripheral(Peripheral peripheral) throws TooManyPeripheralsException {
        if (counter < MAX_PERIPHERAL) {
            peripherals[counter] = peripheral;
            counter++;
        } else {
            throw new TooManyPeripheralsException("Geen plaats meer");
        }
    }

    public void removePeripheral(String articleNumber) {
        for (int index = 0; index < MAX_PERIPHERAL; index++) {
            if (peripherals[index].getArticleNumber().equals(articleNumber)) {
                peripherals[index] = null;
            }
        }
    }

    public Peripheral[] getPeripherals() {
        return peripherals;
    }

    public int getNumberOfPeripherals() {
        return counter;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public HardDisk getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(HardDisk hardDisk) {
        this.hardDisk = hardDisk;
    }

    public ComputerCase getComputerCase() {
        return computerCase;
    }

    public void setComputerCase(ComputerCase computerCase) {
        this.computerCase = computerCase;
    }

    @Override
    public double totalPriceExcl() {
        double priceTotal = 0.0;
        if (processor != null) {
            priceTotal += processor.getPrice();
        }
        if (hardDisk != null) {
            priceTotal += hardDisk.getPrice();
        }
        if (computerCase != null){
            priceTotal += computerCase.getPrice();
        }

        for(Peripheral currentValue : peripherals){
            if(currentValue != null){
                priceTotal += currentValue.getPrice();
            }
        }

        return priceTotal;
    }
}
