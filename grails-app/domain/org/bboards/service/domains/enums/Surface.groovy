package org.bboards.service.domains.enums

/**
 * Created by dshybeka on 17.01.2015.
 */
enum Surface {

    PAPER("Paper"),
    CLOTH("Cloth");

    private String surfaceName;

    private Surface(String surfaceName) {
        this.surfaceName = surfaceName;
    }

}