import nu.pattern.OpenCV;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public void main (String[] args){
    OpenCV.loadLocally();

    Mat img = Imgcodecs.imread("BMW.svg.png");

    if(img.empty()){
        System.out.println("picture not found, check the file path");
    }else{
        AsciiConverter converter = new AsciiConverter(80, 0.35);

        String result = converter.convert(img);
        System.out.println(result);
    }
}

