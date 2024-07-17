/*
    src : https://www.geeksforgeeks.org/state-design-pattern/
    
    Imagine a vending machine that sells various products. 
    The vending machine needs to manage different states such as ready to serve, 
    waiting for product selection, processing payment, and handling out-of-stock situations. 
    Design a system that models the behavior of this vending machine efficiently.

    ready to serve > waiting for product selection >  processing payment > handling out of stock situations

*/

public interface VMState {

    void handleReq();
}

public class HandleReadyToServeState implements VMState {

    @Override
    void handleReq(){
        log.info("Ready to serve")
    }
}

public class WaitingForProductSeletionState implements VMState {

    @Override
    void handleReq(){
        log.info("waiting for production selection")
    }
}
public class ProcessingPaymentState implements VMState {

    @Override
    void handleReq(){
        log.info("Processing payments")
    }
}
public class HandleOutOfStockState implements VMState {

    @Override
    void handleReq(){
        log.info("handling out of stocks")
    }
}

public class VMContext {

    VMState vmState;

    void setState(VMState currVMState){
        this.vmState = currVMState;
    }

    void request(){
        vmState.handleReq();
    }

}