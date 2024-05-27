package ra.business;

import java.util.Scanner;

public interface IEmployee {
    public static final float BASIC_SALARY = 1300000;
    public abstract void inputData(Scanner scanner);
    public abstract void displayData();
}
