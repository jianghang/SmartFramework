package com.hangjiang.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * Created by jianghang on 2017/7/27.
 */
public final class StreamUtil {

    private static final Logger logger = LoggerFactory.getLogger(StreamUtil.class);

    public static String getString(InputStream is){
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line;
        try {
            while ((line = reader.readLine()) != null){
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            logger.error("get String failure",e);
            throw new RuntimeException(e);
        }

        return stringBuilder.toString();
    }

    public static void copyStream(InputStream inputStream, OutputStream outputStream){
        int length;
        byte[] buffer = new byte[4 * 1024];
        try {
            while ((length = inputStream.read(buffer,0,buffer.length)) != -1){
                outputStream.write(buffer,0,buffer.length);
            }
            outputStream.flush();
        } catch (IOException e) {
            logger.error("copy stream failure",e);
            throw new RuntimeException(e);
        } finally {
            try {
                inputStream.close();
                outputStream.close();
            } catch (IOException e) {
                logger.error("close stream failure",e);
            }
        }
    }
}
