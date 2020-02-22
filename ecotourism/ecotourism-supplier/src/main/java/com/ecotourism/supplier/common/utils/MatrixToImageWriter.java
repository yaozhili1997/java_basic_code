package com.ecotourism.supplier.common.utils;

import Decoder.BASE64Encoder;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Hashtable;

public class MatrixToImageWriter {
	private static final int BLACK = 0xFF000000;
    private static final int WHITE = 0xFFFFFFFF;
    static BASE64Encoder encoder = new BASE64Encoder();

    private MatrixToImageWriter() {
    }

    public static BufferedImage toBufferedImage(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
            }
        }
        return image;
    }

    public static void writeToFile(BitMatrix matrix, String format, File file)
            throws IOException {
        BufferedImage image = toBufferedImage(matrix);
        if (!ImageIO.write(image, format, file)) {
            throw new IOException("Could not write an image of format "
                    + format + " to " + file);
        }
    }

    public static void writeToStream(BitMatrix matrix, String format,
            OutputStream stream) throws IOException {
        BufferedImage image = toBufferedImage(matrix);
        if (!ImageIO.write(image, format, stream)) {
            throw new IOException("Could not write an image of format " + format);
        }
    }
    /**
     * 返回二维码的相对路径
     * @param qrcode
     * @param qrcode
     * @return
     * @throws Exception
     */
    public static File outQrcode(String qrcode, String filePath) throws Exception {
        String path = null;
        if(filePath != null && !"".equals(filePath)) {
            path = filePath;
        } else {
            path = MatrixToImageWriter.class.getClassLoader().getResource("/").getPath();
            File webappsFile =  new File(path).getParentFile().getParentFile();
            if(!webappsFile.getName().contains("webapps")) {
                webappsFile = new File(path).getParentFile().getParentFile().getParentFile();
            }
            String root = webappsFile.getAbsolutePath();
            System.out.println(root);
            String dataPath = "data/qrcode";
            File dataPathFile = new File(root + "/" + dataPath);
            System.out.println(dataPathFile.getAbsolutePath());
            if(!dataPathFile.exists()) {
                dataPathFile.mkdirs();
            }
            path = dataPathFile.getAbsolutePath() + "/" + qrcode;
        }
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
    	String text = qrcode; // 二维码内容
        int width = 500; // 二维码图片宽度
        int height = 500; // 二维码图片高度
        String format = "jpg";// 二维码的图片格式
        Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8"); // 内容所使用字符集编码
        hints.put(EncodeHintType.MARGIN, 0);
        BitMatrix bitMatrix = new MultiFormatWriter().encode(text,
                BarcodeFormat.QR_CODE, width, height, hints);
        MatrixToImageWriter.writeToFile(bitMatrix, format, file);
        return file;
    }

    public static void getImgStream(String code,OutputStream outputStream) throws Exception {
        int width = 500; // 二维码图片宽度
        int height = 500; // 二维码图片高度
        String format = "jpg";// 二维码的图片格式
        Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8"); // 内容所使用字符集编码
        hints.put(EncodeHintType.MARGIN, 0);
        BitMatrix bitMatrix = new MultiFormatWriter().encode(code,
                BarcodeFormat.QR_CODE, width, height, hints);
        MatrixToImageWriter.writeToStream(bitMatrix, format,outputStream);
    }

     public static String fileToBase64Str(File file) {
    	 InputStream in = null;
    	 try {
			in = new FileInputStream(file);
			byte[] buffer = new byte[in.available()];
			in.read(buffer);
			return encoder.encode(buffer);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
    	return null;
     }
}
