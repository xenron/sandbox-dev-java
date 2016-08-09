package imaging.java

import thumbnails.ImageProcessor
import spock.lang.*

class ImageSpec extends Specification {
  def "Test we can use imaging tools"() {
    setup:
      def processor = new ImageProcessor()
      def imageStream = getClass().getResourceAsStream("/test.png")

    when:
      def image = processor.loadImage(imageStream)
      def thumbnail = processor.generateThumbnail(image, 100)

    then:
      thumbnail.getWidth() == 100
  }
}
