import com.xuggle.mediatool.*;
import com.xuggle.xuggler.Xuggler;

import java.awt.image.BufferedImage;

public class TestVideo {

    public static void main(String[] args) {
        IMediaReader reader = initToolChain("116839154_3179794965389368_8085608633532331597_n.mp4");
        while (reader.readPacket() == null) {
//            Thread.sleep(1000);
            System.out.println(".");
        }

    }

    private static IMediaReader initToolChain(String fn){
        IMediaReader reader = ToolFactory.makeReader(fn);
        reader.setBufferedImageTypeToGenerate(BufferedImage.TYPE_3BYTE_BGR);

        String outPutFN = System.getProperty("user.dir") + "\\r\\123.mp4";
        IMediaWriter writer = ToolFactory.makeWriter(outPutFN, reader);
        System.out.println("writing op to " + outPutFN);

        IMediaTool timeStamper = new TimeStamperTool();
        reader.addListener(timeStamper);
        timeStamper.addListener(writer);

        // add a viewer to the writer, to see the modified media
//        writer.addListener( ToolFactory.makeViewer(
//                IMediaViewer.Mode.AUDIO_VIDEO, true,
//                javax.swing.WindowConstants.EXIT_ON_CLOSE));

        return  reader;
    }
}
