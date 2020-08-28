import com.xuggle.mediatool.MediaToolAdapter;
import com.xuggle.mediatool.event.IVideoPictureEvent;
import com.xuggle.xuggler.IVideoPicture;

import java.awt.*;
import java.awt.image.BufferedImage;

public class TimeStamperTool extends MediaToolAdapter {

    public void onVideoPicture(IVideoPictureEvent event)
    {
        // get the graphics for the image
        BufferedImage im = event.getImage();
        Graphics2D g = im.createGraphics();
        IVideoPicture vidPic = event.getPicture(); // get video info
        String timeStampStr = String.valueOf(System.currentTimeMillis()) /*+ vidPic.getFormattedTimeStamp()*/;
        // draw yellow timestamp text
        g.setColor(Color.YELLOW);
        g.setFont(new Font("SansSerif", Font. BOLD, 24));
        g.drawString(timeStampStr, 10, im.getHeight()-10);
        super.onVideoPicture(event); // pass event along chain
    } // end of onVideoPicture()
    }
