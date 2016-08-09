(ns thumbnails.image-java
  (:require [thumbnails.image :as img])
  (:gen-class
    :methods [[loadImage [java.io.InputStream] java.awt.image.BufferedImage]
              [saveImage [java.awt.image.BufferedImage String] void]
              [generateThumbnail [java.awt.image.BufferedImage int] java.awt.image.BufferedImage]]
    :main false
    :name thumbnails.ImageProcessor))

(defn -loadImage [this image-stream]
  (img/load-image image-stream))

(defn -saveImage [this image path]
  (img/save-image image path))

(defn -generateThumbnail [this image size]
  (img/generate-thumbnail image size))
