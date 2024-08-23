package com.app.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel {

    @ManyToOne
    private Show show;
    @ManyToOne
    private Seat seat;

    @Enumerated(value = EnumType.ORDINAL)
    private ShowSeatStatus showSeatStatus;


}

// one show seat object contains info about one show
// one show can be in multiple show seat object

