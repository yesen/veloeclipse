package com.googlecode.veloeclipse.dtd.parser;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

/**
 * Represents a parsed Document Type Definition
 * 
 * @author Mark Wutka
 * @version $Revision: 9 $ $Date: 2007-03-14 15:04:50 +0100 (Wed, 14 Mar 2007) $ by $Author: akmal88 $
 */
public class DTD implements DTDOutput, Serializable
{

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3257853173069920050L;
    /** Contains all the elements defined in the DTD */
    public Hashtable  elements;
    /** Contains all the entities defined in the DTD */
    public Hashtable  entities;
    /** Contains all the notations defined in the DTD */
    public Hashtable  notations;
    /** Contains parsed DTD's for any external entity DTD declarations */
    public Hashtable  externalDTDs;
    /** Contains all the items defined in the DTD in their original order */
    public ArrayList  items;
    /**
     * Contains the element that is most likely the root element or null if the
     * root element can't be determined.
     */
    public DTDElement rootElement;

    /** Creates a new DTD */
    public DTD()
    {
        elements = new Hashtable();
        entities = new Hashtable();
        notations = new Hashtable();
        externalDTDs = new Hashtable();
        items = new ArrayList();
    }

    /**
     * Writes the DTD to an output writer in standard DTD format (the format the
     * parser normally reads).
     * @param outWriter
     *            The writer where the DTD will be written
     */
    public void write(PrintWriter outWriter) throws IOException
    {
        Iterator e = items.iterator();
        while (e.hasNext())
        {
            DTDOutput item = (DTDOutput) e.next();
            item.write(outWriter);
        }
    }

    /** Returns true if this object is equal to another */
    @Override
    public boolean equals(Object ob)
    {
        if (this == ob) { return true; }
        if (!(ob instanceof DTD)) { return false; }
        DTD otherDTD = (DTD) ob;
        return items.equals(otherDTD.items);
    }

    /** Stores an array of items in the items array */
    public void setItems(Object[] newItems)
    {
        items = new ArrayList(newItems.length);
        for (Object element : newItems) {
            items.add(element);
        }
    }

    /** Returns the items as an array */
    public Object[] getItems()
    {
        return items.toArray();
    }

    /** Stores an item in the items array */
    public void setItem(Object item, int i)
    {
        items.set(i, item);
    }

    /** Retrieves an item from the items array */
    public Object getItem(int i)
    {
        return items.get(i);
    }

    /** Retrieves a list of items of a particular type */
    public ArrayList getItemsByType(Class itemType)
    {
        ArrayList results = new ArrayList();
        Iterator e = items.iterator();
        while (e.hasNext())
        {
            Object ob = e.next();
            if (itemType.isAssignableFrom(ob.getClass()))
            {
                results.add(ob);
            }
        }
        return results;
    }
}
