package be.pxl.computerstore.hardware;

import be.pxl.computerstore.util.Computable;
import be.pxl.computerstore.util.TooManyPeripheralsException;

public class ComputerSystem implements Computable {
    private Processor processor;
    private HardDisk hardDisk;
    private ComputerCase computerCase;
    private int counter = 0;
    private Peripheral[] peripherals = new Peripheral[3];
    public static final int MAX_PERIPHERAL = 3;

    public void addPeripheral(Peripheral peripheral){
        try {
            peripherals[counter] = peripheral;
            counter++;
            throw new TooManyPeripheralsException("Too many peripherals");
        }
        catch(TooManyPeripheralsException e){
            System.out.println("De error is : " + e.getMessage());
        }
    }

    public void removePeripheral(String articleNumber){
        for(int index = 0; index < MAX_PERIPHERAL; index++){
            if(peripherals[index].getArticleNumber().equals(articleNumber)){
                peripherals[index] = null;
            }
        }
    }

    public Peripheral[] getPeripherals() {
        return peripherals;
    }

    public int getNumberOfPeripherals(){
        int amountPeripherals = 0;
        for(int index = 0; index < MAX_PERIPHERAL; index++){
            if(peripherals[index] != null){
                amountPeripherals++;
            }
        }
        return  amountPeripherals;
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
        double priceTotal;
        priceTotal = processor.getPrice() + hardDisk.getPrice() + computerCase.getPrice();
        return priceTotal;
    }
}
