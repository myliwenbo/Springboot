package vip.xjdai.springbootjava.JVM.parent.io;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileInputStreamImpl extends FileInputStream {
    /**
     * Creates a <code>FileInputStream</code> by
     * opening a connection to an actual file,
     * the file named by the path name <code>name</code>
     * in the file system.  A new <code>FileDescriptor</code>
     * object is created to represent this file
     * connection.
     * <p>
     * First, if there is a security
     * manager, its <code>checkRead</code> method
     * is called with the <code>name</code> argument
     * as its argument.
     * <p>
     * If the named file does not exist, is a directory rather than a regular
     * file, or for some other reason cannot be opened for reading then a
     * <code>FileNotFoundException</code> is thrown.
     *
     * @param name the system-dependent file name.
     * @throws FileNotFoundException if the file does not exist,
     *                               is a directory rather than a regular file,
     *                               or for some other reason cannot be opened for
     *                               reading.
     * @throws SecurityException     if a security manager exists and its
     *                               <code>checkRead</code> method denies read access
     *                               to the file.
     * @see SecurityManager#checkRead(String)
     */
    public FileInputStreamImpl(String name) throws FileNotFoundException {
        super(name);
    }

    /**
     * Creates a <code>FileInputStream</code> by
     * opening a connection to an actual file,
     * the file named by the <code>File</code>
     * object <code>file</code> in the file system.
     * A new <code>FileDescriptor</code> object
     * is created to represent this file connection.
     * <p>
     * First, if there is a security manager,
     * its <code>checkRead</code> method  is called
     * with the path represented by the <code>file</code>
     * argument as its argument.
     * <p>
     * If the named file does not exist, is a directory rather than a regular
     * file, or for some other reason cannot be opened for reading then a
     * <code>FileNotFoundException</code> is thrown.
     *
     * @param file the file to be opened for reading.
     * @throws FileNotFoundException if the file does not exist,
     *                               is a directory rather than a regular file,
     *                               or for some other reason cannot be opened for
     *                               reading.
     * @throws SecurityException     if a security manager exists and its
     *                               <code>checkRead</code> method denies read access to the file.
     * @see File#getPath()
     * @see SecurityManager#checkRead(String)
     */
    public FileInputStreamImpl(File file) throws FileNotFoundException {
        super(file);
    }

    /**
     * Creates a <code>FileInputStream</code> by using the file descriptor
     * <code>fdObj</code>, which represents an existing connection to an
     * actual file in the file system.
     * <p>
     * If there is a security manager, its <code>checkRead</code> method is
     * called with the file descriptor <code>fdObj</code> as its argument to
     * see if it's ok to read the file descriptor. If read access is denied
     * to the file descriptor a <code>SecurityException</code> is thrown.
     * <p>
     * If <code>fdObj</code> is null then a <code>NullPointerException</code>
     * is thrown.
     * <p>
     * This constructor does not throw an exception if <code>fdObj</code>
     * is {@link FileDescriptor#valid() invalid}.
     * However, if the methods are invoked on the resulting stream to attempt
     * I/O on the stream, an <code>IOException</code> is thrown.
     *
     * @param fdObj the file descriptor to be opened for reading.
     * @throws SecurityException if a security manager exists and its
     *                           <code>checkRead</code> method denies read access to the
     *                           file descriptor.
     * @see SecurityManager#checkRead(FileDescriptor)
     */
    public FileInputStreamImpl(FileDescriptor fdObj) {
        super(fdObj);
    }
}
