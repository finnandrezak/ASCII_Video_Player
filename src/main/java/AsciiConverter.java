import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

public class AsciiConverter {
    private static final String SCALE = ".'`\\\"^,:;Il!i><~+_-?][}{1)(|\\\\/tfjrxnuvczXYUJCLQ0OZmwqpdbkhaoo*#&8%B@$";
    private int targetWidth;
    private double aspectRatioCorrection;
    private Mat grayscaleMat = new Mat();
    private Mat resizedMat = new Mat();

    public  AsciiConverter(int targetWidth, double aspectRatioCorrection){
        this.targetWidth = targetWidth;
        this.aspectRatioCorrection = aspectRatioCorrection;
    }

    public String convert (Mat frame){
        if(frame == null || frame.empty() || frame.cols() == 0)return "";

        double scale = targetWidth / (double) frame.cols();
        int targetHeight = (int) Math.max(1, Math.round(frame.rows()* scale * aspectRatioCorrection));

        Imgproc.resize( frame, resizedMat, new Size(targetWidth, targetHeight));
        Imgproc.cvtColor(resizedMat, grayscaleMat, Imgproc.COLOR_BGR2GRAY);

        StringBuilder sb = new StringBuilder();

        for(int row = 0; row < grayscaleMat.rows(); row++){
            for(int col = 0; col < grayscaleMat.cols(); col++){
                double brightness = grayscaleMat.get(row, col)[0];

                int charIndex = (int) (brightness * (SCALE.length() - 1) /255.0);
                sb.append(SCALE.charAt(charIndex));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}

