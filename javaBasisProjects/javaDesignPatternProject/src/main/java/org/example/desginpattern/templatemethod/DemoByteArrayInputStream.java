package org.example.desginpattern.templatemethod;

import java.io.IOException;
import java.io.InputStream;

/**
 * template method 示例
 *
 * @author dragon
 */
public class DemoByteArrayInputStream extends InputStream {

    protected byte[] buffer;

    protected int pos;

    protected int count;

    public DemoByteArrayInputStream(byte[] buf) {
        this.buffer = buf;
        this.pos = 0;
        this.count = buf.length;
    }

    public DemoByteArrayInputStream(byte[] buf, int offset, int length) {
        this.buffer = buf;
        this.pos = offset;
        this.count = Math.min(offset + length, buf.length);
    }

    @Override
    public int read() throws IOException {
        return pos < count ? (buffer[pos++] & 0xff) : -1;
    }
}
