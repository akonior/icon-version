package pl.itako.iconversion

import com.google.common.collect.Lists
import groovy.io.FileType

import javax.imageio.ImageIO
import java.awt.*
import java.awt.image.BufferedImage
import java.util.List

import static java.awt.RenderingHints.KEY_TEXT_ANTIALIASING
import static java.awt.RenderingHints.VALUE_TEXT_ANTIALIAS_ON

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

    static void addTextToImage(File image, RenderingConfig config = RenderingConfig.DEFAULT, String... lines) {
        System.setProperty("awt.useSystemAAFontSettings","on");
        System.setProperty("swing.aatext", "true");

        final BufferedImage bufferedImage = ImageIO.read(image);

        final Color backgroundOverlayColor = config.backgroundOverlayColor;
        final Color textColor = config.textColor;
        final int fontSize = config.fontSize;
        final int linePadding = config.verticalLinePadding;
        final int imgWidth = bufferedImage.width;
        final int imgHeight = bufferedImage.width;
        final int lineCount = lines.length;
        final int totalLineHeight = (fontSize * (lineCount + 1)) + (linePadding * lineCount);

        GraphicsEnvironment.localGraphicsEnvironment.createGraphics(bufferedImage).with { g ->
            g.setRenderingHint(KEY_TEXT_ANTIALIASING, VALUE_TEXT_ANTIALIAS_ON);

            // Draw our background overlay
            g.setColor(backgroundOverlayColor);
            g.fillRect(0, imgHeight - totalLineHeight, imgWidth, totalLineHeight);

            // Draw each line of our text
            g.setFont(new Font(Font.MONOSPACED, Font.PLAIN, fontSize));
            g.setColor(textColor)
            lines.reverse().eachWithIndex { String line, int i ->
                final int strWidth = g.getFontMetrics().stringWidth(line);

                int x = 0;
                if (imgWidth >= strWidth) {
                    x = ((imgWidth - strWidth) / 2);
                }

                int y = imgHeight - (fontSize * (i + 1)) - (i * linePadding);

                g.drawString(line, x, y);
            }
        }

        ImageIO.write(bufferedImage, "png", image);
    }
}
