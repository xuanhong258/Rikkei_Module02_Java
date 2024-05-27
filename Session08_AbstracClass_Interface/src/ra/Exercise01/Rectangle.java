package ra.Exercise01;

public class Rectangle implements IResizeable {
    @Override
    public void resize(double percent) {
        System.out.printf("Diện tích của hình chữ nhật tăng lên %.2f%%", percent);
    }
}
