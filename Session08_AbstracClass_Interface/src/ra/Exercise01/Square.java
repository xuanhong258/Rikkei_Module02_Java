package ra.Exercise01;

public class Square implements IResizeable {
    @Override
    public void resize(double percent) {
        System.out.printf("Diện tích của hình vuông tăng lên %.2f%%", percent);
    }
}
