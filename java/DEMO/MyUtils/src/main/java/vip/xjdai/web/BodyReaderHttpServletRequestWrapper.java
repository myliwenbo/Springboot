package vip.xjdai.web;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import vip.xjdai.common.utils.Encodes;

/**
 * 重写HttpServletRequest 实现 getInputStream可以多次重读读取
 *
 * @author lwb
 */
public class BodyReaderHttpServletRequestWrapper extends HttpServletRequestWrapper {

    private Map<String, String[]> paramsMap;
    //保存流中的数据
    private final byte[] body;

    public BodyReaderHttpServletRequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        this.body = BodyReaderHttpServletRequestWrapper.readBytes((InputStream) request.getInputStream());
        this.paramsMap = "POST".equals(request.getMethod().toUpperCase())
                ? this.getParamMapFromPost((HttpServletRequest) this)
                : this.getParamMapFromGet((HttpServletRequest) this);
    }

    /**
     * 读取流数据并且保存
     *
     * @param in 流数据
     * @return 读取的流
     * @throws IOException
     */
    private static byte[] readBytes(InputStream in) throws IOException {
        BufferedInputStream bufin = new BufferedInputStream(in);
        int buffSize = 1024;
        ByteArrayOutputStream out = new ByteArrayOutputStream(buffSize);
        byte[] temp = new byte[buffSize];
        int size = 0;
        while ((size = bufin.read(temp)) != -1) {
            out.write(temp, 0, size);
        }
        bufin.close();
        byte[] content = out.toByteArray();
        return content;
    }

    private String decodeValue(String value) throws UnsupportedEncodingException {
        if (value.contains("%u")) {
            return Encodes.urlDecode((String) value.replaceAll("%", "%25"));
        }
        try {
            return URLDecoder.decode(value.replaceAll("%", "%25"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    /**
     * 在调用getInputStream函数时，创建新的流，包含原先数据流中的信息，然后返回。
     */
    public ServletInputStream getInputStream() throws IOException {
        /**
         * 这个this.boby就是读取好的数据
         */
        final ByteArrayInputStream bais = new ByteArrayInputStream(this.body);
        return new ServletInputStream() {

            public boolean isFinished() {
                return false;
            }

            public boolean isReady() {
                return false;
            }

            public int read() throws IOException {
                return bais.read();
            }

            public void setReadListener(ReadListener arg0) {
            }
        };
    }

    public String getParameter(String name) {
        String[] values = this.paramsMap.get(name);
        if (values == null || values.length == 0) {
            return null;
        }
        return values[0];
    }

    public Map<String, String[]> getParameterMap() {
        return this.paramsMap;
    }

    public Enumeration<String> getParameterNames() {
        return Collections.enumeration(this.paramsMap.keySet());
    }

    public String[] getParameterValues(String name) {
        return this.paramsMap.get(name);
    }

    private Map<String, String[]> getParamMapFromGet(HttpServletRequest request) throws UnsupportedEncodingException {
        return this.parseQueryString(request.getQueryString());
    }

    private HashMap<String, String[]> getParamMapFromPost(HttpServletRequest request) throws UnsupportedEncodingException {
        String body = "";
        try {
            body = this.getRequestBody((InputStream) request.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        HashMap<String, String[]> result = new HashMap<String, String[]>();
        if (null == body || 0 == body.length()) {
            return result;
        }
        return this.parseQueryString(body);
    }

    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader((InputStream) this.getInputStream()));
    }

    private String getRequestBody(InputStream stream) {
        String line = "";
        StringBuilder body = new StringBuilder();
        int counter = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        try {
            while ((line = reader.readLine()) != null) {
                if (counter > 0) {
                    body.append("rn");
                }
                body.append(line);
                ++counter;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return body.toString();
    }

    public HashMap<String, String[]> parseQueryString(String s) throws UnsupportedEncodingException {
        String[] valArray = null;
        if (s == null) {
            return new HashMap<String, String[]>();
        }
        HashMap<String, String[]> ht = new HashMap<String, String[]>();
        StringTokenizer st = new StringTokenizer(s, "&");
        while (st.hasMoreTokens()) {
            String pair = st.nextToken();
            int pos = pair.indexOf(61);
            if (pos == -1)
                continue;
            String key = pair.substring(0, pos);
            String val = pair.substring(pos + 1, pair.length());
            if (ht.containsKey(key)) {
                String[] oldVals = ht.get(key);
                valArray = new String[oldVals.length + 1];
                for (int i = 0; i < oldVals.length; ++i) {
                    valArray[i] = oldVals[i];
                }
                valArray[oldVals.length] = this.decodeValue(val);
            } else {
                valArray = new String[]{this.decodeValue(val)};
            }
            ht.put(key, valArray);
        }
        return ht;
    }

}
