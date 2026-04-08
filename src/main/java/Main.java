import nu.pattern.OpenCV;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class Main {
    public static void main(String[] args) {
        OpenCV.loadShared();
        VideoSource source = new VideoSource("Big_Buck_Bunny.mp4");
        AsciiConverter converter = new AsciiConverter(1000, 0.35);
        TerminalRenderer renderer = new TerminalRenderer();

        Mat frame = new Mat();
        double fps = source.getFPS();
        long frameDuration = (long) (1000/fps);

        while(source.isOpen() && source.getNextFrame(frame)){
            double starttime = System.currentTimeMillis();

            String img = converter.convert(frame);
            renderer.render(img);

            double endtime = System.currentTimeMillis();
            long difference = (long) (endtime - starttime);

            if( difference < frameDuration) {
                try {
                    Thread.sleep(frameDuration - difference);
                } catch (InterruptedException e) {
                    System.out.print("Error: Interrupted during streaming");
                }
            }
        }

        renderer.clear();
        source.close();

    }
}

