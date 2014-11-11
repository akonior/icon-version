package pl.itako.iconversion

import com.google.common.collect.Lists
import groovy.io.FileType

import javax.imageio.ImageIO
import java.awt.*
import java.awt.image.BufferedImage
import java.util.List

import static java.awt.Color.BLACK

class IconUtils {

    static List<File> findIcons(File where, File manifest) {
        List<File> result = Lists.newArrayList();
        where.eachFileRecurse(FileType.FILES) { File file ->
            //TODO use manifest for icon name
            if (file.name == "ic_launcher.png") {
                result.add(file)
            }
        }

        result
    }

    static void addTextToImage(File image, Color color = BLACK, String... lines) {
        int fontSize = 12
        int distance = 2

        final BufferedImage bufferedImage = ImageIO.read(image);

        Graphics g = bufferedImage.getGraphics();
        g.setFont(g.getFont().deriveFont(fontSize));
        g.setColor(color)
        lines.eachWithIndex { String line, int i ->
            g.drawString(line, distance, (distance + fontSize) * (i + 1));
        }

        ImageIO.write(bufferedImage, "png", image);
    }
}
