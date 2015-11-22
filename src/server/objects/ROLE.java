package server.objects;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by clark on 10/27/15.
 */
@XStreamAlias("ROLE")
public enum ROLE {
    MANAGER,
    CASHIER,
    CHEF
}
