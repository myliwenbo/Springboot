/**
 * 
 */
package vip.xjdai.stringio;

import java.io.FileNotFoundException;
import java.io.LineNumberReader;

import org.junit.Test;

/**
 * @author lwb
 *
 */
public class ReaderDemo {

    @SuppressWarnings("resource")
    @Test
    public void charArrayReaderTest() throws FileNotFoundException {
        LineNumberReader lineNumberReader = new LineNumberReader(null);
        lineNumberReader.setLineNumber(1);
        lineNumberReader.getLineNumber();

        System.out.println("");
    }

}
