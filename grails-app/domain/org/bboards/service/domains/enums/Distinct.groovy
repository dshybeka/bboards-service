package org.bboards.service.domains.enums

/**
 * Created by dshybeka on 17.01.2015.
 */
enum Distinct {

    CENTR("minsk.center"),
    FRUNZ("minsk.frunz"),
    MOSKV("minsk.moskv"),
    PARTIZ("minsk.partiz"),
    OCTBR("minsk.octbr"),
    ZAVODSK("minsk.zavodsk"),
    LENINSK("minsk.leninsk"),
    PERVOMSK("minsk.pervomsk"),
    SOVETSK("minsk.sovetsk");

    private String name;

    private Distinct(String name) {
        this.name = name;
    }

}