package Project;

public class Slot {
    private int slotNum;
    private int width;
    private int depth;

    private Vehicle container;

    public void setContainer(Vehicle container) {
        this.container = container;
    }

    public Vehicle getContainer() {
        return container;
    }


    public int getSlotNum() {
        return slotNum;
    }

    public void setSlotNum(int slotNum) {
        this.slotNum = slotNum;
    }

    public void setWidth(int w){this.width=w;}
    public int getWidth(){return this.width;}
    public void setDepth(int d){this.depth=d;}
    public int getDepth(){return this.depth;}
    public void print(){
        System.out.println("Slot : " + this.slotNum);
        System.out.println("Depth : " + this.depth);
        System.out.println("Width : " + this.width);
    }

}
