public class IllegalPointNumber extends IllegalArgumentException {
    public IllegalPointNumber(String message){ 
        super(message);
    }

    public IllegalPointNumber(){ 
        super("Illegal point number inserted");
    }
}