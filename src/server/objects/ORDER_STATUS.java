package server.objects;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by darkbobo on 10/5/15.
 */
@XStreamAlias("ORDERSTATUS")
public enum ORDER_STATUS {
    NEW,
    COLLECTED,
    COMPLETE
}
