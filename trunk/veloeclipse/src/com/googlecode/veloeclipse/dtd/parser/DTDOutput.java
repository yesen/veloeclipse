package com.googlecode.veloeclipse.dtd.parser;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

/**
 * Defines the method used for writing DTD information to a PrintWriter
 * 
 * @author Mark Wutka
 * @version $Revision: 6 $ $Date: 2005-10-26 08:14:08 +0200 (Wed, 26 Oct 2005) $ by $Author: akmal88 $
 */
public interface DTDOutput extends Serializable
{

    /**
     * DOCUMENT ME!
     * 
     * @param out
     *            DOCUMENT ME!
     * 
     * @throws IOException
     *             DOCUMENT ME!
     */
    public void write(PrintWriter out) throws IOException;
}
