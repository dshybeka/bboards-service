package org.bboards.service.domains.enums

/**
 * Created by dshybeka on 17.01.2015.
 */
enum DisplayZoom {

    ELEVEN(11),
    TWELVE(12),
    THIRTEEN(13),
    FOURTEEN(14),
    FIFTEEN(15),
    SIXTEEN(16),
    SEVENTEEN(17),
    EIGHTEEN(18);

    private Integer value;

    private DisplayZoom(final Integer value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return value
    }
}