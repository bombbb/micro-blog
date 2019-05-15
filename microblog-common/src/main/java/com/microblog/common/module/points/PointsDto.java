package com.microblog.common.module.points;


import lombok.Data;

import java.io.Serializable;

@Data
public class PointsDto implements Serializable {
    long userId;
    String type;
}
