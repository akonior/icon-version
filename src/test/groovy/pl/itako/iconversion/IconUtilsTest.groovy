package pl.itako.iconversion

import spock.lang.Specification

import static pl.itako.iconversion.IconUtils.addTextToImage
import static pl.itako.iconversion.IconUtils.findIcons

class IconUtilsTest extends Specification {

    def "test addWatermark"() {
        given:
        InputStream is = getClass().getResourceAsStream('/test_icons/drawable-xxhdpi/ic_launcher.png')

        def file = new File('/tmp/out.png')
        def stream = new FileOutputStream(file)
        stream.write(is.bytes)
        stream.close()

        when:
        addTextToImage(file, "demo debug", "1.2.34")

        then:
        file.exists()
    }

    def 'test findIcons'() {
        given:
        URL url = getClass().getResource('/test_icons')
        def dir = url.file

        when:
        List<File> icons = findIcons(new File(dir), null)

        then:
        icons.size() == 4
    }
}
