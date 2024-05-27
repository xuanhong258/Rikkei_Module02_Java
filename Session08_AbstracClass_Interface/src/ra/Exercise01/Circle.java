package ra.Exercise01;

public class Circle implements IResizeable {
    @Override
    public void resize(double percent) {
        System.out.printf("Diện tích của hình tròn tăng lên %.2f%%", percent);
    }

}
