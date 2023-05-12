
package Project;

import java.util.Calendar;

public class Vehicle {
    private int width;
    private int depth;
    private String modelName;
    private String modelYear;
    private String identification;

    private int parkInTime = 0;
    private int parkOutTime = 0;

    public void setParkInTime() {
        Calendar now = Calendar.getInstance();
        int x=Calendar.HOUR_OF_DAY;
        this.parkInTime =x;
    }

    public void setParkOutTime() {
        int x=Calendar.HOUR_OF_DAY;
        this.parkOutTime =x;
    }

    public int getParkInTime() {
        return parkInTime;
    }

    public int getParkOutTime() {
        return parkOutTime;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getDepth() {
        return depth;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelYear(String modelYear) {
        this.modelYear = modelYear;
    }

    public String getModelYear() {
        return modelYear;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getIdentification() {
        return identification;
    }

}
