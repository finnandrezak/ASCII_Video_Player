import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

public class VideoSource {

   private VideoCapture vc;

    public VideoSource(String path){
        this.vc = new VideoCapture(path);
    }
    public VideoSource(int index){
        this.vc = new VideoCapture(index);
    }

    public double getFPS(){
        double fps = this.vc.get(Videoio.CAP_PROP_FPS);
        return (fps > 0) ? fps : 30.0;
    }

    public boolean isOpen(){
        return this.vc.isOpened();
    }

    public boolean getNextFrame(Mat frame){
        return this.vc.read(frame);
    }

    public void close(){
        this.vc.release();
    }


}

